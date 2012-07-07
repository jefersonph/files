#!/bin/bash

myvar=`ls -1 dados/*.txt`;
arr=$(echo $myvar | tr " " "\n")
ID=1000

for x in $arr
do	
  echo $x
  cat $x | while read linha
  do
	echo $ID
	# MATRICULA,NOME,login
	MAT="`echo "$linha" | cut -d, -f1`"
	NOME="`echo "$linha" | cut -d, -f2`"
	LOGIN="`echo "$linha" | cut -d, -f3`"
	
	# usando o codigo da questã4 para ajustar maiusculas/minusculas
	NOMEF="`./questao4.sh $NOME|sed 's/ $//'`" 
			# sed par limpar espacos extras no fim
	
	# gerando uma linha passwd
	echo "$LOGIN:x:$ID:100:$NOMEF,$MAT:/home/$LOGIN:/bin/bash" >> dados/passwd
	
	# incrementando ID (campo com identificador do usuáo)
	ID=$(($ID + 1))
  done
	 mv $x{,.feito}
done
