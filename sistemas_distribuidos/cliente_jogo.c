#include <stdio.h>
#include <string.h>
#include </usr/include/rpc/rpc.h>

int main(int argc, char *argv[])
{
 int res;
 char *ps;
 char jogada[256];

 if (argc!=4)  {
    fprintf(stderr,"Uso:\n%s <servidor> <jogador> <jogada>\n",argv[0]);
    return(1);
 }
 if (strcmp(argv[3],"tesoura")==0)
    sprintf(jogada,"0:%s",argv[2]);
 else if (strcmp(argv[3],"pedra")==0)
    sprintf(jogada,"1:%s",argv[2]);
 else if (strcmp(argv[3],"papel")==0)
    sprintf(jogada,"2:%s",argv[2]);
 else  {
    fprintf(stderr,"Uso:\n%s <servidor> <jogador> <jogada>\n",argv[0]);
    fprintf(stderr,"Jogada deve ser: tesoura, pedra ou papel\n");
    return(1);
 }
 ps = jogada;
 if (callrpc(argv[1],0x20000000LU,1,1,
            (xdrproc_t)xdr_wrapstring,(char *)&ps,
            (xdrproc_t)xdr_int,(char *)&res) != 0)
    return(1);
 printf("Resultado: %d\n",res);
 return(0);
}
