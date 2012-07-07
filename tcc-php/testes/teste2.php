<?php

$texto = $_POST['ckeditor'];
$texto = str_replace("<br />","", $texto);
$texto = str_replace("<p>","", $texto);
$texto = str_replace("</p>","", $texto);
$texto = ereg_replace("[\t]","",$texto);

$novoarquivo = fopen("/usr/local/apache/htdocs/jeferson/ssl.conf", "w+");
fwrite($novoarquivo, $texto);
fclose($novoarquivo);

?>

