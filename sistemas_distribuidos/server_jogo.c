#include <stdio.h>
#include </usr/include/rpc/rpc.h>

typedef struct {
 char nome[256];
 int  opcao;
} JOGADA;

JOGADA jogadas[2];
int num_jogadas = 0;

int *jogada(char **jog_nome)
{
 static int res;
 int opcao;
 char *ps;
 int i;

 ps = *jog_nome;
 if (num_jogadas>=2 || ps[1]!=':')  {
    res = 0;
    return(&res);
 }
 opcao = ps[0] - '0';
 if (opcao<0 || opcao>2)  {
    res = 0;
    return(&res);
 }
 for (i=0;i<num_jogadas;++i)
     if (strcmp(jogadas[i].nome,ps+2)==0)  {
        res = 0;
        return(&res);
     }
 strcpy(jogadas[num_jogadas].nome,ps+2);
 jogadas[num_jogadas].opcao = opcao;
 printf("|%s|%d|\n",jogadas[num_jogadas].nome,jogadas[num_jogadas].opcao);
 ++num_jogadas;
 res = 1;
 return(&res);
}

int main()
{
 if (registerrpc(0x20000000LU,1,1,jogada,xdr_wrapstring,xdr_int)==-1)
    return(1);
 svc_run();
 return(1);
}
