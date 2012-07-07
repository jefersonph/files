/* Arquivo: socket-tcp-svc.c
 * Autor:   Roland Teodorowitsch
 * Data:    1 set. 2006
 */


#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include "stream.h"


double obtem_nota(char *matricula)
{
  double nota;
  FILE *f;
  int achou,i,t,j;
  char linha[TAM_LINHA+1];
  char m[TAM_MATRICULA+1];
  char n[TAM_NOTA+1];

  f = fopen(ARQ_NOTAS,"r");
  if (f==NULL)
     return(-2.0); /* Impossivel abrir o arquivo */
  achou = 0;
  nota = -1.0; /* Matricula não encontrada */
  while (!achou)  {
        if (fgets(linha,TAM_LINHA,f)==NULL)
           break;
        /* Remove eventual '\n' no final da linha */
        t = strlen(linha);
        if (linha[t-1]=='\n')
           linha[--t]='\0';
        /* Pula espaços iniciais */
        i = 0;
        while (linha[i]!='\0' && (linha[i]==' ' || linha[i]=='\t') )
              ++i;
        /* Se a linha esta vazia, retorna erro */
        if (linha[i]=='\0')  {
           fclose(f);
           return(-3.0); /* Arquivo de notas invalido */
        }
        /* Separa o número de matricula */
        j = 0;
	while (linha[i]!='\0' && linha[i]!=' ' && linha[i]!='\t' && j<TAM_MATRICULA)
              m[j++] = linha[i++];
        /* Se o tamanho do número de matricula for maior, retorna erro */
        if (linha[i]!='\0' && linha[i]!=' ' && linha[i]!='\t')  {
           fclose(f);
           return(-3.0); /* Arquivo de notas invalido */
        }
        m[j]='\0';
        /* Se não é o número de matricula procurado vai para a proxima linha */
        if (strcmp(m,matricula)!=0)
           continue;
        /* Pula espaços entre a matricula e a nota */
        while (linha[i]!='\0' && (linha[i]==' ' || linha[i]=='\t') )
              ++i;
        /* Se o resto da linha esta vazia, retorna erro */
        if (linha[i]=='\0')  {
           fclose(f);
           return(-3.0); /* Arquivo de notas invalido */
        }
        /* Separa a nota */
        j = 0;
	while (linha[i]!='\0' && linha[i]!=' ' && linha[i]!='\t' && j<TAM_NOTA)
              n[j++] = linha[i++];
        /* Se o tamanho do número de matricula for maior, retorna erro */
        if (linha[i]!='\0' && linha[i]!=' ' && linha[i]!='\t')  {
           fclose(f);
           return(-3.0); /* Arquivo de notas invalido */
        }
        n[j]='\0';
        fclose(f);
        nota = atof(n);
        return(nota);
  }
  fclose(f);
  return(nota);
}


int main(int argc, char *argv[])
{
  struct sockaddr_in svc_address;
  struct sockaddr_in clnt_address;
  int svc_sockfd,clnt_sockfd;
  socklen_t clnt_len,svc_len;
  char matricula[TAM_MATRICULA+1];
  double nota;

  svc_sockfd = socket(AF_INET, SOCK_STREAM, 0);
  if (svc_sockfd<0)  {
     fprintf(stderr,"%s: erro em socket(): %s\n",argv[0],strerror(errno));
     exit(1);
  }
  svc_len = sizeof(svc_address);
  bzero((char *)&svc_address,svc_len);
  svc_address.sin_family = AF_INET;
  svc_address.sin_addr.s_addr = INADDR_ANY;
  svc_address.sin_port = htons(SOCKET_PORT);
  if (bind(svc_sockfd,(struct sockaddr *)&svc_address,svc_len) < 0)  {
     fprintf(stderr,"%s: erro em bind(): %s\n",argv[0],strerror(errno));
     exit(1);
  }

  listen(svc_sockfd, 5);

  while (1)  {

        clnt_sockfd = accept (svc_sockfd,(struct sockaddr *)&clnt_address, &clnt_len);
        if (clnt_sockfd < 0)  {
           fprintf(stderr,"%s: erro em accept(): %s\n",argv[0],strerror(errno));
           exit(1);
        }
        read(clnt_sockfd, matricula, sizeof(char)*(TAM_MATRICULA+1));
        nota = obtem_nota(matricula);
        write(clnt_sockfd, &nota, sizeof(double));
        close(clnt_sockfd);
  }
  return(0);
}

