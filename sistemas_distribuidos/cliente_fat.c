#include <stdio.h>
#include </usr/include/rpc/rpc.h>

int main()
{
 int i,stat;
 double res;

 for (i=0;i<10;++i)  {
     stat = callrpc("localhost",0x20000000LU,1,1,
                    (xdrproc_t)xdr_int,(char *)&i,
                    (xdrproc_t)xdr_double,(char *)&res);
     if (stat != 0)
        return(1);
     printf("%d! = %lf\n",i,res);
 }
 return(0);
}
