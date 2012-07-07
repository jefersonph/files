#!/bin/bash

IN=`cat $1`
VAR=0
arr=$(echo $IN | tr ":" "\n")
vst=1

echo "Digite a palavra a ser pesquisada:\n"
read palavra

for x in $arr
do
    nome[VAR]=$x
    VAR=$(($VAR + 1))
done

for (( i=0,a=1; i < ${#nome[@]}; i++,a++))
do
	if [ "${nome[i]}" = "$palavra" ]
	then
		echo "Definicao: ${nome[a]}"
		vst=0
		break
	fi
done

if [ "$vst" = "1" ]
then
	echo "Informe a descricao para a palavra pesquisada:"
	read definicao
	echo ":$palavra:$definicao" >> $1	
	sed ':a;$!N;s/\n//;ta;' $1 > palavras2.txt
	mv palavras2.txt $1	
fi
