<?php
session_start();
include 'config.php';	

listar($REPO_DIR.$_SESSION["nome_empresa"][0]);

function listar($local){
        $ponteiro  = opendir($local);

        while ($nome_itens = readdir($ponteiro)) {
                $itens[] = $nome_itens;
        }

        sort($itens);
        foreach ($itens as $listar) {
           if ($listar!="." && $listar!=".." && $listar!=".svn"){
                        if (is_dir($listar)) {
                                $pastas[]=$listar;
                        } else{
                                $arquivos[]=$listar;
                        }
           }
        }

        if ($arquivos != "") {
                echo '<span>Servidores da empresa: '.$_SESSION["nome_empresa"][0].'</span> <br />';
			    foreach($arquivos as $listar){
					echo '<span id="'.$listar.'">'.$listar.'</span> <br />';
				}
        }
}
/*
<html>
<head>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script> 
</head>
<body>

<form action="" id="meu_formulario" method="post">
        <input type="text" name="nomeUser">
        <input type="text" name="idadeUser">
</form>

<div id="aqui">Aqui </div>
<div id="results"> </div>
<br/>
<div id="results2"> </div>

<script type="text/javascript">
$("#aqui").bind('click', function(){
        $.ajax({
                type: "POST",
                url: "teste2.php",
                data: {option:"servidor", empresa:"empresa1"},
                success: function(msg){
                        $("#results").html(msg);
                }
        });
});

$('#servidores option').live('click', function(){
        $.ajax({
                type: "POST",
                url: "teste2.php",
                data: {option:"arquivo", empresa:"empresa1"},
                success: function(msg){
                        $("#results2").html(msg);
                }               
        });
});
</script>

</body>
</html>

*/

?>


