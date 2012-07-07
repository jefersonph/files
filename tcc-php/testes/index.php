<?php

$conteudo = file("/usr/local/apache/htdocs/jeferson/ssl.conf"); 

foreach($conteudo as $t){
	$a .=  $t;
}

$t1 = str_replace("\\r","", json_encode($a));
$t1 = str_replace("\"","", $t1);
$t1 = str_replace("\\n","<br/>", $t1);

?>

<html>
<head>
	<title>Sample CKEditor Site</title>
	<script type="text/javascript" src="http://trrdsv-centos5.terra.com.br/jeferson/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script> 
</head>
<body>
	<form  id="form1" action="#" method="post">
		<p>
				My Editor:<br />
				<textarea id="editor1" name="editor1"></textarea>
				<script type="text/javascript">
					CKEDITOR.replace( 'editor1',
						{	
						toolbar :	
							[							
							['Cut','Copy','Paste','PasteText'],
							['Undo','Redo','-','SelectAll','RemoveFormat']								
							]
							});		
					CKEDITOR.instances.editor1.setData("<?php echo $t1; ?>");
					
				</script>				
		</p>	
	</form>
	<div id="aqui">Aqui </div>
	<div id="results"> </div>
</body>
</html>
<script type="text/javascript">

$("#aqui").bind('click', function(){
	$.ajax({
		type: "POST",
		url: "teste2.php",
		data: {ckeditor: CKEDITOR.instances.editor1.getData(), file:"nome.txt"},
		success: function(msg){
			$("#results").html(msg);
		}		
	});
});
</script>



