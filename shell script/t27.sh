#!/bin/bash

# TITULO: T27
# DATA: 17/Nov/2010

ARQ=$1
echo "authoritative;"
echo "default-lease-time 300;    # 5 minutos"
echo "max-lease-time 1800;       # 30 minutos"
echo " "
echo "subnet 10.100.0.0 netmask 255.0.0.0{"
echo "    option domain-name-servers 10.100.0.1;"
echo "    option routers 10.100.0.1;"
echo "    option subnet-mask 255.0.0.0;"
echo "    range 10.100.0.0 10.100.100.255;"
echo " "
echo "	# LABINS"
cat $ARQ | while read linha
do
    
    LABIN="`echo "$linha" | cut -d" " -f1`"
    MAQUINA="`echo "$linha" | cut -d" " -f2`"
    MAC="`echo "$linha" | cut -d" " -f3`"
    
    echo "	host labin_$LABIN"_"$MAQUINA {"
    echo "		hardware ethernet $MAC;" 
    echo "      		fixed-address 10.0.$LABIN"."$MAQUINA;"	
    echo "      		option host-name labin_$LABIN"_"$MAQUINA;"
    echo "	}"
    echo " "
done
echo "}"
