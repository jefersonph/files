<?php
include 'config.php';	 

if($START == true){
	mkdir($REPO_DIR);
	svn_checkout($REPO_SVN,$REPO_DIR);
}
else{
	$services = array();
	$services2 = array();

	$revision1 = lerArquivo($FILE_TMP);
	$revision2 = svn_update($REPO_DIR);
	$revisionStart = (int)$revision1;
	$revisionStart++;

	for($i=$revisionStart; $i <= $revision2; $i++){
		$log = svn_log($REPO_DIR, $i);
		foreach($log as $t=>$a){
				 foreach($a['paths']as $u){
					array_push($services, $u['path']);
				 }
			}
	}

	foreach($services as $u){		
			$tmp = explode('/', $u);
			array_push($services2, $tmp[1]);		
	}
	$services = array_unique($services2);

	foreach($services as $u){		
			echo $u;
	}

	gravarArquivo($FILE_TMP, $revision2);

}
function lerArquivo($file){
	$conteudo = file($file);
	$a = "";
	foreach($conteudo as $t){
			$a .=  $t ;
	}
	return $a;
}

function gravarArquivo($file, $texto){
	$logfile = fopen($file, "w+");
	fwrite($logfile, $texto);
	fclose($logfile);
}
?>
