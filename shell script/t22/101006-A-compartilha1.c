/* TITULO: Exemplo de criação de memória compartilhada
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
	int area;
	

	area = shmget(IPC_PRIVATE, 1000, IPC_CREAT | 0644);
	if (area == -1) {
		fprintf(stderr, "Erro no shmget\n");
		return(1);
	}
	
	printf("Criada uma área com o id = %d e com 1000 bytes. Verifique com ipcs\n", area);
	area = shmget(600, 100, IPC_CREAT | 0660);
	printf("Criada uma área com o id = %d e chave = %d com 100 bytes. Verifique com ipcs\n", area, 600);
	
}
