#!/bin/bash
# TITULO: Pequeno exemplo de um servidor
# DATA: 08/Setembro/2010

DIR="lixo teste"
LOG="exemplo.log"

while true
do
	for d in $DIR 
	do 
		chmod -r a+rX $d 2>> $LOG
	done
	sleep 10
done

