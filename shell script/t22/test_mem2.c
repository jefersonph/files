#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <termios.h>

#define TAM 2
#define CHAVE 87654321
#define STRM 300

typedef struct {
    int p1;
    int p2;
} PROCESSOS;


int main()
{
    PROCESSOS *te2;
    int pid = getpid();
    int idarea2, chave2, tam2;
    
    tam2 = (TAM * sizeof(PROCESSOS)) + 1;    // alocando apenas +1 byte além do necessário
    
    idarea2 = shmget(CHAVE, tam2, IPC_EXCL);
    if(idarea2 == -1) {
        fprintf(stderr, "Erro no shmget\n");
        return (1);
    }

    te2 = (PROCESSOS *) shmat(idarea2, 0, 0);
    if (te2 == NULL) {
        fprintf(stderr, "ERRO ao tentar se conectar a area\n");
        return (1);
   }
   printf("P1: %d\n",te2[0].p1);
   printf("P2: %d\n",te2[0].p2);

    if (shmctl(idarea2, IPC_RMID, 0) == -1) {
          fprintf(stderr, "ERRO. Não consegui remover.\n");
                  return (1);
    }


}

