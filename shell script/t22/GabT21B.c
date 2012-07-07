/*
 * TITULO: Resposta B do Exercício T21
 * DATA: 13/Outubro/2010
 * 
 * Pode ser feito em trios no laboratório.
 * 
 * Considere o seguinte programa.
 * 
 * Observe que ele é um simple sistema que:
 * 	- cria uma estrutura para alunos
 *  - pede ao usuário que digite nome e matricula dos alunos
 *  - ordena pela matricula
 *  - imprime os dados ordenados
 *  - remove a alocacao
 *  
 *  Faça as seguintes alterações no programa:
 *   - Dois processo, vamos chamar de P1 e P2
 *   - P1 irá criar uma área compartilhada e solicitar ao usuário que
 *     a alimente. 
 *   - P2 irá ordenar os dados
 *   - P1 irá imprimir os dados ordenados e desalocar
 *  
 *  VEJA QUE NÃO TERÁ MALLOC, terás que usar memória compartilhada
*/

/* Nesta solução, P2 é filho fork de P1
 * 
 **/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <termios.h>

#define STRM 300
#define TAM 5

#define CHAVE 2030405060

typedef struct {
    char nome[STRM];
    int mat;
} DADOS;

int lestring(char[], int);
int ordena(DADOS *, int);
int ledados(DADOS *, int);
int imprime(DADOS *, int);

int main()
{
    DADOS *d;
    char *controle;
    int pid;

    int idarea, chave, tam;

    tam = (TAM * sizeof(DADOS)) + 1;	// alocando apenas +1 byte além do necessário

    pid = fork();
    if (pid < 0) {
	fprintf(stderr, "ERRO no fork\n");
	return (1);
    }
    printf("Sou o processo %d\n", getpid());


    if (pid > 0) {		// PAI. Codigo do P1
// +++++++++++++++++++++++ CODIGO DO P1
	idarea = shmget(CHAVE, tam, IPC_CREAT | 0644);
	if (idarea == -1) {
	    fprintf(stderr, "Erro no shmget\n");
	    return (1);
	}
	/* Area criada. Fazendo o d apontar para ela */

	d = (DADOS *) shmat(idarea, 0, 0);
	if (d == NULL) {
	    fprintf(stderr, "ERRO ao tentar se conectar a area\n");
	    return (1);
	}

	/* fazendo o flag controle apontar para um posicao ao final */
	controle = (char *) &d[TAM];

	*controle = 0;
	/* indicando ao outro processo de que ainda não estão prontos
	 * os dados
	 * */

	printf("Digite os dados para %d alunos\n", TAM);

	ledados(d, TAM);

	printf("Voce digitou com sucesso %d alunos\n", TAM);

	*controle = 1;		//indicando que o outro pode ordenar

	while (*controle == 1);

	printf("Imprimindo...\n");
	imprime(d, TAM);

	printf("Removendo area\n");

	if (shmctl(idarea, IPC_RMID, 0) == -1) {
	    fprintf(stderr, "ERRO. Não consegui remover.\n");
	    return (1);
	}

	return (0);



// +++++++++++++++++++++++ CODIGO DO P2         
    } else {			// FILHO. Codigo do P2
	/* tentando localiar a area pela chave */
	sleep(1);		// para evitar o filho localizar a area antes de criada
	idarea = shmget(CHAVE, tam, IPC_EXCL);
	if (idarea == -1) {
	    fprintf(stderr,
		    "Erro no shmget. Chave %d existe? Foi craida?\n",
		    CHAVE);
	    return (1);
	}
	/* Area localizada. Fazendo o d apontar para ela */

	d = (DADOS *) shmat(idarea, 0, 0);
	if (d == NULL) {
	    fprintf(stderr, "ERRO ao tentar se conectar a area\n");
	    return (1);
	}

	/* fazendo o flag controle apontar para um posicao ao final */
	controle = (char *) &d[TAM];

	/* aguardando o outro processo alimentar os dados */
	printf("Estou esperando os dados ficarem prontos\n");
	while (*controle == 0);

	printf("Ordenando pela matricula\n");
	ordena(d, TAM);

	*controle = 0;		// colocando zero para o outro saber

	return (0);

    }


}

int imprime(DADOS * d, int t)
{
    int i;
    for (i = 0; i < t; i++) {
	printf("%10d %s\n", d[i].mat, d[i].nome);
    }
}

int ledados(DADOS * d, int t)
{
    int i;

    for (i = 0; i < t; i++) {
	printf("\n[%d] Nome: ", i);
	lestring(d[i].nome, STRM);
	printf("[%d] Matricula: ", i);
	while (scanf("%d", &d[i].mat) != 1) {
	    /* Se digitou algo que nao eh numero, limpa buffer
	     * (um fflsuh moderado) */
	    while (fgetc(stdin) != '\n');
	}
    }
}

int ordena(DADOS * d, int t)
{
    int i, m, j;
    DADOS temp;

    for (i = 0; i < t; i++) {
	/* Metodo da seleção. Horrível, mas simples e fácil de implementar
	 * (e como ninguém aqui irá cadastrar milhares de alunos... */
	m = i;
	for (j = i + 1; j < t; j++) {
	    if (d[m].mat > d[j].mat)
		m = j;
	}
	if (m != i) {
	    temp = d[i];
	    d[i] = d[m];
	    d[m] = temp;
	}
    }
}

int lestring(char s[], int max)
{
    int i = 0;
    char letra;

    for (i = 0; i < (max - 1); i++) {
	letra = fgetc(stdin);
	if ((letra == '\n') && (i == 0)) {
	    i = i - 1;
	    continue;
	}
	if (letra == '\n')
	    break;
	s[i] = letra;
    }
    s[i] = 0;
    return (i);
}
