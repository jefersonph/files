all:		dgram-clnt dgram-svc

dgram-clnt:	dgram-clnt.c dgram.h
		@gcc -o dgram-clnt dgram-clnt.c

dgram-svc:	dgram-svc.c dgram.h
		@gcc -o dgram-svc dgram-svc.c

clean:
		@rm -f dgram-clnt dgram-svc
