#include <stdio.h>
#include <stdlib.h>
#include </usr/include/rpc/rpc.h>

double *fat (int *n)
{
 static double res;
 int x;

 x = *n;
 res = 1.0;
 while (x>1)
   res *= x--;
 return(&res);
}

int main()
{
 if (registerrpc(0x20000000LU,1,1,fat,xdr_int,xdr_double) == -1)
     exit(1);
 svc_run();
 return(1);
}
