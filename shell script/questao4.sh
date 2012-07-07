#!/bin/bash
for m in $*
do
D=${#m}
if (( D > 3 ))
then
TXT="`echo $m|cut -c1|tr a-z A-Z`"
TXT="$TXT`echo $m|cut -c2- | tr A-Z a-z`"
else 
TXT="`echo $m|tr A-Z a-z`"
fi
echo -ne "$TXT "
done
echo -ne "\n"
