#include <stdio.h>
#include <stdlib.h>

main () {
char var[100];
int ip = 2345;

sprintf(var, "echo %d", ip);
system(var);

}
