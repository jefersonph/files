#include <stdio.h>
#include <signal.h>
#include <unistd.h>

int a = 0;

/* Rotina de tratamento de sinais. Ela sempre tem um parâtro int que será sinal que a invocou */
void tratahup(int sinal)
{
	a = 1;
}

int main()
{
   
   signal(1, tratahup);

   printf("Meu pid eh %i\n", getpid());
   
   while( a != 1){
	}
   
     
}
