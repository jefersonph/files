CC        = gcc 

compila:	defT16

defT16:		defT16.c
		@gcc -o defT16 defT16.c -l crypt

tudo:		clean compila

clean:
		@rm -f defT16
		@rm -f dados/passwd

teste:		clean compila
		@./defT16 dados/*.txt
