#include <stdio.h>

double fat (int n)
{
 double res;

 res = 1.0;
 while (n>1)
   res *= n--;
 return(res);
}

int main()
{
 int i;
 for (i=0;i<10;++i)
     printf("%d! = %lf\n",i,fat(i));
 return(0);
}
