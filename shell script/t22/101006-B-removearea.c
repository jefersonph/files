/* TITULO: Exemplo de como remover área compartilhada
 * DATA: 06/Outubro/2010
 * 
*/
#include <stdio.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <termios.h>


int main()
{
	int area, ch;

		printf("Digite a chave a ser pesquisada (0 se não tem chave): ");
		scanf("%d", &ch);
		if (ch>0){
			area = shmget(ch, 100, IPC_EXCL);
			/* O IPC_EXCL não vai criar uma nova área se chave já existir
			 * NOTA: Para encontrar, chave e valor devem bater */
			if (area == -1 ){
				fprintf(stderr,"Não encontrei chave %d\n", ch);
				return(1);
			}
			if (shmctl(area, IPC_RMID, 0)==-1){
				fprintf(stderr, "ERRO. Não consegui remover. Tenho permissão?\n");
				return(1);
			}
			printf("Segmento de memoria ID=%d chave=%d removido\n", area, ch);
			return(0);
		}
		printf ("Então digite o ID da area: ");
		scanf("%d", &area);
		if (shmctl(area, IPC_RMID, 0)==-1){
				fprintf(stderr, "ERRO. Não consegui remover. Tenho permissão? Area existe?\n");
				return(1);
		}
		printf("Segmento de memoria ID=%d removido\n", area);
		return(0);
}
