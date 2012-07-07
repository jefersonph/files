/* 
TITULO: Definição do Exercício T16
DATA: 15/Setembro/2010

Este pequeno código em C faz o mesmo que foi solicitado no T13,
le todos os arquivos passados por parâmetros e escreve
em dados/passwd o arquivo no formato passwd

ALTERE o código para que:

a) gere o hash da senha que deve entrar no lugar do primeiro 'x'
da linha passwd. Para gerar o hash use a função crypt assim:

hash = crypt(senhaTexto, DUASLetrasQuaiquer);


exemplo: hash = crypt("teste", "xy");

hash tem que ser uma variável do tipo char *

b) faça um MakeFile simples com as opções
compila: compila o código fonte
clean: apapa os fontes e o dados/passwd
tudo: clean e compila
teste: clean, compila e executa o codigo passando como parametro *.txt


c) Após esta alteração, crie arquivos com milhares de linhas
de entrada e teste o desempenho para gerar as linhas do 
passwd com o script T13 (terás que alterar ele para escrever
em dados/passwd pois originalmente, o gabarito, imprime na tela)
e com este programa em C.


DICA: colando time na frente do comando ele mesmo te dá o tempo.
Exemplo:
 ./exemplo.sh<ENTER>
 Apenas executa
 
 time ./exemplo.sh<ENTER>
o time executa e diz quanto tempo levou


Acredito que você irá se surpreender
*/
#include <stdio.h>
#include <string.h>

#define PASSWD "dados/passwd"
#define TAM 1000

/* transforma uma frase com a primeira letra em Maiúscula
elgio scHlEMer == Elgio Schlemer
*/
char *acertaMai (char *s)
{
		char *r;
		char f=1;
		char c;
		
		r = s;
		while (*r){
			if ((*r >= 'a')&&(*r <= 'z')){
				if (f) {
					*r = *r - 32;
					f = 0;
				}
				r++;
				continue;
			}
			if (*r == ' ') f=1;
			if ((*r >= 'A') && (*r <= 'Z')){
				if (f==0){
					*r = *r + 32;
				}
			}
			r++;
		}
		return(s);
}

int main (int argc, char *argv[])
{
	int i, l;
	FILE *arq, *senha;
	char linha[TAM];
	char *mat, *nome, *login, *senhaTexto;
	
	int uid=1000;
	
	//hash = crypt("teste", "xy");
	senha = fopen(PASSWD, "a");
		/* abre o arquivo para append */
	if (senha == NULL){
		fprintf(stderr, "ERRO: não pude abrir %s\n", PASSWD);
		return(1);
	}
	
	for (i=1; i<argc; i++){
		arq = fopen(argv[i], "r");
		if (arq == NULL){
			fprintf(stderr, "Erro ao tentar ler %s\n", argv[i]);
			continue; // pega o próximo
		}
		
		l =0;
		while (fgets(linha, TAM, arq)){
			l++;
			/* para cada linha do arquivo 
			 *  MATRICULA,NOME,login,senha
			 * 
			 * Usando a função strtok da string.h para pegar
			 * cada campo em seu ponteiro
			 * */
			mat = strtok(linha, ",");
			nome = acertaMai(strtok(NULL, ","));
			login = strtok(NULL, ",");
			senhaTexto = strtok(NULL, "\n");
			char *hash = crypt(senhaTexto, "xy");
			//printf("teste: %s", hash);
			//char senha = crypt(senhaTexto, "xy");
			//fulano1:x:1000:100:FUlano Um:/home/fulano1:/bin/bash
			/* Considera-se que o arquivo NÃO TEM ERRO!!! */
			 fprintf(senha, "%s:x:%d:100:%s:", login, uid, nome);
		 	 fprintf(senha, "/home/%s:/bin/bash:%s\n", login, hash);
			uid++;
		}
		fclose(arq);
	}
	fclose(senha);
	return(0);
}
