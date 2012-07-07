<?php

function syslog_open(){
	openlog('carnaval_apuracao', LOG_PID|LOG_NDELAY, LOG_LOCAL6);
}

function my_syslog($nivel, $arquivo, $linha, $mensagem){
	syslog($nivel, '['.$arquivo.'] ['.$linha.'] '.$mensagem);
}

?>

