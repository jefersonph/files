<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<?php
include_once 'geshi/geshi.php';
include 'config.php';	
$file = $REPO_DIR.$_GET['empresa']."/".$_GET['servidor']."/".$_GET['servico']."/".$_GET['arquivo'];

$conteudo = file($file);

foreach($conteudo as $t){
        $a .=  $t ;
}
$geshi = new GeSHi($a, 'bash');
?>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema</title>
<link href="jquery-ui/css/cupertino/jquery-ui-1.8.12.custom.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" charset="utf-8" src="js/jquery.min.js"></script>
<script language="javascript" src="jquery-ui/js/jquery-ui-1.8.12.custom.min.js"></script>
<script language="javascript" src="js/visualizar_arquivos.js"></script>

</head>

<body>
		<div id="file"  style="display:none" title="Visualizador de Arquivos"><?php echo $geshi->parse_code(); ?></div>
</body>
</html>
