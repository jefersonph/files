#!/bin/bash

# TITULO: Resposta 6 do T13/T14
# DATA: 08/Setembro/2010

# Quem se deu conta, a questão 4 convertia qualquer sequencia de
# cars para ficar a primeira letra em maiuscula e a segunda em
# minuscula. Era só usar. Podia gerar um novo programa com a
# questao 4 e apenas chamar ele. Aqui eu irei chamar. Deve ter
# um script chamado questao4.sh com o codigo exatamente igual
# ao que esta na questão 4 do T14

ARQ=$1

ID=1000
cat $ARQ | while read linha
do
	#echo "Eu li a linha $linha"
	# Formato linha de entrada
	# MATRICULA,NOME,login
	MAT="`echo "$linha" | cut -d, -f1`"
	NOME="`echo "$linha" | cut -d, -f2`"
	LOGIN="`echo "$linha" | cut -d, -f3`"
	
	# usando o codigo da questão 4 para ajustar maiusculas/minusculas
	NOMEF="`./questao4.sh $NOME|sed 's/ $//'`" 
			# sed par limpar espacos extras no fim
	
	# gerando uma linha passwd
	echo "$LOGIN:x:$ID:100:$NOMEF,$MAT:/home/$LOGIN:/bin/bash"
	
	# incrementando ID (campo com identificador do usuário)
	ID=$(($ID + 1))
	
done
