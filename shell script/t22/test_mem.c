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
    int idarea2, chave2, tam2;
    tam2 = (TAM * sizeof(PROCESSOS)) + 1;
    idarea2 = shmget(CHAVE, tam2, IPC_CREAT | 0664);
    if(idarea2 == -1) {
        fprintf(stderr, "Erro no shmget\n");
        return (1);
    }

    te2 = (PROCESSOS *) shmat(idarea2, 0, 0);
    if (te2 == NULL) {
        fprintf(stderr, "ERRO ao tentar se conectar a area\n");
        return (1);
   }
   te2[0].p1 = getpid();
   te2[0].p2 = 20;
	
}	
