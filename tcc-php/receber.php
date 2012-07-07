<?php
session_start();
include 'config.php';	 

$conexao = mysql_connect($DB_HOST, $DB_USER, $DB_PASS) or die("deu erro!");
mysql_select_db($DB) or die("deu erro !");

if ($_POST['operacao'] == "login") {
		extract($_POST);
		if(!$login  || !$senha ){
			echo "<p>&nbsp;</p>";
			echo "Os Campos s&atilde;o Obrigatorios";
			exit();
		}
		$login=addslashes($login);
		$senha=addslashes($senha);
		 
		$re = mysql_query("select COUNT(*) from usuarios where login = '{$login}' and senha = '{$senha}'");
		$total = mysql_result($re,0);
		 
		if($total == 1) {

			$re = mysql_query("select permissao, empresas_id_empresas from usuarios where login = '{$login}'");
			$row = mysql_fetch_row($re);

			$re2 = mysql_query("SELECT nome FROM empresas WHERE id_empresas = {$row[1]}");
			$nome_empresa = mysql_fetch_row($re2);

			$_SESSION["login"] =($login);
			$_SESSION["permissao"] = $row[0];
			$_SESSION["id_empresa"] = $row[1];
			$_SESSION["nome_empresa"] = $nome_empresa;

			echo' <script type="text/javascript" language="javascript">
					window.location.assign("index.php");
				</script>
			';
		}
		else{
			session_destroy();
			echo "Dados incorretos!";
		}
        
} 
else if($_POST['operacao'] == "sair") {
	session_destroy();
	echo' <script type="text/javascript" language="javascript">
				window.location.assign("login.php");
		  </script>
	';
			
}
else if($_POST['operacao'] == "salvar_arquivo") {

$conteudo = file($_POST['file']);
foreach($conteudo as $t){
        $a .=  $t ;
}

$novoarquivo2 = fopen($_POST['file2'], "w+");
fwrite($novoarquivo2, $a);
fclose($novoarquivo2);

$texto = $_POST['ckeditor'];
$texto = str_replace("<br />","", $texto);
$texto = str_replace("<p>","", $texto);
$texto = str_replace("</p>","", $texto);
$texto = ereg_replace("[\t]","",$texto);

$novoarquivo = fopen($_POST['file'], "w+");
fwrite($novoarquivo, $texto);
fclose($novoarquivo);

echo "<span class='bold'>Arquivo foi salvo!</span>";
}
else if($_POST['operacao'] == "listar_servidores") {
	
		$empresa = mysql_query("select id_empresas from empresas where nome = '{$_SESSION["nome_empresa"][0]}'");
		$row = mysql_fetch_row($empresa);
		
		
		
		echo '<span class=bold>'.$_SESSION["nome_empresa"][0].'</span><br />';
		$re2 = mysql_query("select nome, id_servidores from servidores where empresas_id_empresas = '{$row[0]}'");		
		while ($row2 = mysql_fetch_array($re2, MYSQL_ASSOC)) {
				echo '<table cellpadding="5px" cellspacing="0">';
				echo '<tr>';
				echo '<td>'.$row2['nome'].'</td>';
				if($_SESSION["permissao"] == "moderado"){		
					echo '<td><a href="editar_servidor.php?id='.$row2['id_servidores'].'">Editar!</a></td>';					
					echo '<td><a href="editar_servidor.php?id='.$row2['id_servidores'].'">Enviar Informações!</a></td>';
				}				
				echo '</tr>';					
				echo '</table>';
		}							
						
	
}
else if($_POST['operacao'] == "listar_servidores_adm") {
	
	$re = mysql_query("select nome, id_empresas from empresas");		
			
			while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {
					echo '<span class=bold>'.$row['nome'].'</span><br />';
					$re2 = mysql_query("select nome, id_servidores from servidores where empresas_id_empresas = '{$row['id_empresas']}'");		
					while ($row2 = mysql_fetch_array($re2, MYSQL_ASSOC)) {
							echo '<table cellpadding="5px" cellspacing="0">';
							echo '<tr>';
							echo '<td>'.$row2['nome'].'</td>';
							echo '<td><a href="editar_servidor.php?id='.$row2['id_servidores'].'">Editar!</a></td>';
							echo '<td><a href="#" onClick="excluir_servidor('."'".''.$row2['id_servidores'].''."'".','."'".''.$row2['nome'].''."'".')">Deletar!</a></td>';
							echo '<td><a href="#" onClick="enviar_servidor('."'".''.$row2['id_servidores'].''."'".','."'".''.$row2['nome'].''."'".')">Enviar Alterações!</a></td>';
							echo '</tr>';					
							echo '</table>';
					}							
			}				
}

else if($_POST['operacao'] == "listar_servidores_option") {
if($_POST['empresa'] == "false")
		$_POST['empresa'] = $_SESSION["nome_empresa"][0];
		
$re2 = mysql_query("select id_empresas from empresas where nome = '{$_POST['empresa']}'");
$row2 = mysql_fetch_array($re2, MYSQL_ASSOC);

$re = mysql_query("select id_servidores, nome from servidores where empresas_id_empresas = {$row2['id_empresas']}");
	echo '<select id="servidores">';
	while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {
			echo '<option value='.$row['id_servidores'].'>'.$row['nome'].'</option>';
	}
	echo '</select>';
	
}

else if($_POST['operacao'] == "listar_servicos") {
	if($_POST['empresa'] == "false")
		$_POST['empresa'] = $_SESSION["nome_empresa"][0];

	$empresa = mysql_query("select id_empresas from empresas where nome = '{$_POST['empresa']}'");
	$id_empresa = mysql_fetch_array($empresa, MYSQL_ASSOC);

	$servidor = mysql_query("select nome from servidores where id_servidores = '{$_POST['servidor']}'");
	$id_servidor = mysql_fetch_array($servidor, MYSQL_ASSOC);
	
	$servicos = mysql_query("select id_servicos, nome, arquivo_configuracao from servicos where servidores_id_servidores = {$_POST['servidor']} and  servidores_empresas_id_empresas  = {$id_empresa['id_empresas']}");
	
	echo '<table cellpadding="5px" cellspacing="0">';
	while ($row = mysql_fetch_array($servicos, MYSQL_ASSOC)) {	
		echo '<tr id="'.$row['nome'].'">';
			echo '<td>'.$row['arquivo_configuracao'].'</td>';
			if($_SESSION["permissao"] == "restrito"){						
				echo '<td><a class="pst_ver" value="'.$row['nome'].'" href="visualizar_arquivos.php?empresa='.$_POST['empresa'].'&servidor='.$id_servidor['nome'].'&servico='.$row['nome'].'&arquivo='.$row['arquivo_configuracao'].'">Visualizar!</a></td>';						
			}
			else{					
				echo '<td><a class="pst_editar" value="'.$row['nome'].'" href="editar_arquivo.php?empresa='.$_POST['empresa'].'&servidor='.$id_servidor['nome'].'&servico='.$row['nome'].'&arquivo='.$row['arquivo_configuracao'].'">Editar!</a></td>';												
				echo '<td><a class="pst_deletar" href="#" onClick="excluir_servico('."'".''.$row['id_servicos'].''."'".','."'".''.$row['nome'].''."'".')">Deletar!</a></td>';						
				echo '<td><a class="pst_ver" value="'.$row['nome'].'" href="visualizar_arquivos.php?empresa='.$_POST['empresa'].'&servidor='.$id_servidor['nome'].'&servico='.$row['nome'].'&arquivo='.$row['arquivo_configuracao'].'">Visualizar!</a></td>';													
				echo '<td><a class="pst_ver" value="'.$row['nome'].'" href="editar_servico.php?id='.$row['id_servicos'].'">Editar Serviço!</a></td>';													
			}
			echo '<td><a class="pst_editar" value="'.$row['nome'].'" href="diferenca.php?empresa='.$_POST['empresa'].'&servidor='.$id_servidor['nome'].'&servico='.$row['nome'].'&arquivo='.$row['arquivo_configuracao'].'">Visualizar Diferença!</a></td>';													
		echo '</tr>';					
	}
	echo '</table>';
	
	
}

else if($_POST['operacao'] == "listar_empresas_option") {
	$re = mysql_query("select nome from empresas");
	echo '<select id="empresas">';
	while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {
			echo '<option>'.$row['nome'].'</option>';
	}
	echo '</select>';
}

else if($_POST['operacao'] == "verificar_sintaxe") {
$texto = $_POST['file'];
$texto = str_replace("<br />","", $texto);
$texto = str_replace("<p>","", $texto);
$texto = str_replace("</p>","", $texto);
$texto = ereg_replace("[\t]","",$texto);


touch("/tmp/temp.txt");
$novoarquivo = fopen("/tmp/temp.txt", "w+");
fwrite($novoarquivo, $texto);
fclose($novoarquivo);	
	
	switch ($_POST['service']) {
    case "Apache":
        system("/usr/sbin/apache2 -t -f /tmp/temp.txt", $retval);
        break;
    case "Lighttpd":
		system("/usr/sbin/lighttpd -t -f /tmp/temp.txt", $retval);     
        break;
	case "Samba":
		system("/usr/bin/testparm -s /tmp/temp.txt", $retval);
        break;
	case "Squid":
		system("/usr/sbin/squid -k check /tmp/temp.txt", $retval);
        break;		
	}	
	if($retval == 0)
		echo "<span class='bold'>Sintaxe esta correta!</span>";
	else
		echo "<span class='bold'>Sintaxe não esta correta!</span>";

}

else if($_POST['operacao'] == "listar_usuarios") {
	if($_POST['empresa'] == "false")
		$_POST['empresa'] = $_SESSION["nome_empresa"][0];
		
	$empresa = mysql_query("select id_empresas from empresas where nome = '{$_POST["empresa"]}'");
	$row = mysql_fetch_row($empresa);
	
	echo '<br /><span>Usuários da empresa: '.$_POST["empresa"].'</span> <br />';
	$re = mysql_query("select nome, id_usuarios from usuarios where empresas_id_empresas = {$row[0]}");
	while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {
			echo '<table cellpadding="5px" cellspacing="0">';
			echo '<tr>';
			echo '<td>'.$row['nome'].'</td>';
			if($_SESSION["permissao"] != "restrito"){	
				echo '<td><a href="editar_usuario.php?id='.$row['id_usuarios'].'">Editar!</a></td>';
				echo '<td><a class="pst_deletar" href="#" onClick="excluir_usuario('."'".''.$row['id_usuarios'].''."'".','."'".''.$row['nome'].''."'".')">Deletar!</a></td>';						
			}
			echo '</tr>';					
			echo '</table>';
	}
			
}
else if($_POST['operacao'] == "listar_empresas") {
	if($_SESSION["permissao"] == "administrador"){
		$re = mysql_query("select id_empresas, nome, contato from empresas");		
		while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {			
			echo '<table cellpadding="5px" cellspacing="0">';
			echo '<tr>';
			echo '<td>Nome:</td>';
			echo '<td>'.$row['nome'].'</td>';
			echo '<td>Contato:</td>';
			echo '<td>'.$row['contato'].'</td>';
			echo '<td><a href="editar_empresa.php?id='.$row['id_empresas'].'">Editar!</a></td>';
			echo '<td><a class="pst_deletar" href="#" onClick="excluir_empresa('."'".''.$row['id_empresas'].''."'".','."'".''.$row['nome'].''."'".')">Deletar!</a></td>';						
			echo '</tr>';					
			echo '</table>';
			echo '<br />';
		}
		
	}			
	else{
		$re = mysql_query("select id_empresas, nome, contato from empresas where nome = '{$_SESSION["nome_empresa"][0]}'");		
		while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {
			echo '<span id="'.$row["id_empresas"].'">'.'Nome: '.$row["nome"].' Contato: '.$row["contato"].'</span> <br />';
		}
	}	
	
}
else if($_POST['operacao'] == "editar_servidor"){
$re = mysql_query("select * from servidores where id_servidores = '{$_POST["idservidor"]}'");		
		while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {
			echo '<table id="c_servidor" class="vign-listViewTable" width="100%"> <tbody>';
			echo '<tr><td>Nome Servidor:</td> <td><input id="nome_server" size="50" name="servidor" value="'.$row["nome"].'"></td></tr>';
			echo '<tr><td>IP:</td><td><input id="ip" name="ip" value="'.$row["ip"].'"></td></tr>';
			echo '<tr><td>M&aacute;scara:</td><td><input id="mascara" name="mascara" value="'.$row["mascara"].'"></td></tr>';
			echo '<tr><td>Arquitetura:</td><td><input id="arquitetura" name="arquitetura" value="'.$row["arquitetura"].'"></td></tr>';
			echo '<tr><td>Sistema Operacional:</td><td><input id="so" name="so" value="'.$row["so"].'"></td></tr>';
			echo '<tr><td>Descri&ccedil;&atilde;o:</td><td><input id="descricao" nome="descricao" value="'.$row["descricao"].'"></td></tr>';
			echo '<tr><td>Empresa:</td><td><div id="empresa_op"></div></td></tr>';			
			echo '<tr> <td><br /><div id="salvar" class="button">Salvar</div><div id="cancelar" class="button">Cancelar</div></td></tr>';
			echo '</tbody></table>';				
		}
}

else if($_POST['operacao'] == "editar_servico"){
$re = mysql_query("select * from servicos where id_servicos = '{$_POST["idservico"]}'");		
		while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {
			echo '<table class="vign-listViewTable" width="100%">';
			echo '<tbody><tr> <td>Nome Servi&ccedil;o:</td><td><input id="nome_servico" size="50" name="servico" value="'.$row['nome'].'"></td></tr>';
			echo '<tr><td>Descri&ccedil;&atilde;o:</td><td><input id="descricao" name="descricao" value="'.$row['descricao'].'"></td></tr>';
			echo '<tr><td>Arquivo de Configura&ccedil;&atilde;o:</td><td><input id="arquivo_conf" name="arqConfig" value="'.$row['arquivo_configuracao'].'"></td></tr>';
			echo '<tr><td>Empresa:</td><td><div id="empresa_op"></div></td></tr>';
			echo '<tr><td>Servidor:</td>';
			echo '<td><div id="servidor_op"><select><option></option></select></div></td></tr>';
			echo '<tr><td><br /><div id="salvar" class="button">Salvar</div><div id="cancelar"class="button">Cancelar</div></td></tr>';
			echo '</tbody></table>';				
		}
}

else if($_POST['operacao'] == "editar_usuario"){
			$re = mysql_query("select * from usuarios where id_usuarios = '{$_POST["idusuario"]}'");		
			while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {
				echo '<table id="c_usuario" class="vign-listViewTable" width="100%"><tbody>';
				echo '<tr><td>Nome:</td><td><input id="nome_user" size="50" name="nome" value="'.$row["nome"].'"></td></tr>';
				echo '<tr><td>Senha:</td><td><input id="senha" name="senha" type="password"></td></tr>';
				echo '<tr><td>Login:</td><td><input id="login" name="login" value="'.$row["login"].'"></td></tr>';
				echo '<tr><td>E-Mail</td><td><input id="email" name="email" value="'.$row["email"].'"></td></tr>';
				echo '<tr><td>CPF:</td><td><input id="cpf" name="cpf" value="'.$row["cpf"].'"></td></tr>';
				echo '<tr><td>Permissão</td><td><select id="permissao"><option>administrador</option><option>moderado</option><option>restrito</option></select></td></tr>';
				echo '<tr><td>Empresa:</td><td><div id="empresa_op"></div></td></tr>';
				echo '<tr><td><br /><div id="salvar" class="button">Salvar</div><div id="cancelar" class="button">Cancelar</div></td></tr>';
				echo '</tbody></table>';
			}		
}

else if($_POST['operacao'] == "editar_empresa"){
			$re = mysql_query("select * from empresas where id_empresas = '{$_POST["idempresa"]}'");		
			while ($row = mysql_fetch_array($re, MYSQL_ASSOC)) {
				echo '<table id="c_empresa" class="vign-listViewTable" width="100%"><tbody>';
				echo '<tr><td>Nome Empresa:</td><td><input id="nome_empresa" size="50" name="empresa" value="'.$row["nome"].'"></td></tr>';
				echo '<tr><td>CNPJ:</td><td><input id="cnpj" name="cnpj" value="'.$row["cnpj"].'"></td></tr>';
				echo '<tr><td>Endere&ccedil;o:</td><td><input id="endereco" name="endereco" value="'.$row["endereco"].'"></td></tr>';
				echo '<tr><td>Telefone:</td><td><input id="telefone" name="telefone" value="'.$row["telefone"].'"></td></tr>';
				echo '<tr><td>Contato:</td><td><input id="contato" name="contato" value="'.$row["contato"].'"></td></tr>';
				echo '<tr><td><br /><div id="salvar" class="button">Salvar</div><div id="cancelar" class="button">Cancelar</div></td></tr>';
				echo '</tbody></table>';
			}	
}


else if($_POST['operacao'] == "criar_usuario") {

	$empresa = mysql_query("select id_empresas from empresas where nome = '{$_POST["empresa"]}'");
	$row = mysql_fetch_row($empresa);

	$sql = "INSERT INTO usuarios (id_usuarios, nome, login, email, cpf, senha, permissao, empresas_id_empresas)VALUES(NULL, '{$_POST['nome_user']}','{$_POST['login']}','{$_POST['email']}','{$_POST['cpf']}','{$_POST['senha']}','{$_POST['permissao']}','{$row[0]}')";
	if (!mysql_query($sql,$conexao)) {
			die('Error: ' . mysql_error());
		}
			echo "<span class='bold'>Usuário foi adicionado!</span>";
}

else if($_POST['operacao'] == "criar_servico") {

	$empresa = mysql_query("select id_empresas from empresas where nome = '{$_POST["empresa"]}'");
	$id_empresa = mysql_fetch_row($empresa);
	
	$servidor = mysql_query("select id_servidores from servidores where nome = '{$_POST["servidor"]}'");
	$id_servidor = mysql_fetch_row($servidor);
	
	$sql = "INSERT INTO servicos (id_servicos, servidores_id_servidores, servidores_empresas_id_empresas, nome, descricao, arquivo_configuracao)VALUES(NULL, '{$id_servidor[0]}','{$id_empresa[0]}','{$_POST['nome_servico']}','{$_POST['descricao']}','{$_POST['arquivo_conf']}')";
	
	if (!mysql_query($sql,$conexao)) {
			die('Error: ' . mysql_error());
		}
			echo "<span class='bold'>Serviço foi adicionado!</span>";
	
	$ponteiro = $REPO_DIR.$_POST['empresa']."/".$_POST['servidor']."/";
	$ponteiro2 = $TMP_DIR.$_POST['empresa']."/".$_POST['servidor']."/";
	mkdir($ponteiro.$_POST['nome_servico'], 0755);
	mkdir($ponteiro2.$_POST['nome_servico'], 0755);
	touch($ponteiro.$_POST['nome_servico']."/".$_POST['arquivo_conf']);	
	touch($ponteiro2.$_POST['nome_servico']."/".$_POST['arquivo_conf']);	
	svn_add($ponteiro.$_POST['nome_servico']);
	svn_add($ponteiro.$_POST['nome_servico']."/".$_POST['arquivo_conf']);
	
}

else if($_POST['operacao'] == "criar_empresa") {

	$sql = "INSERT INTO  empresas (id_empresas, nome, cnpj, endereco, telefone, contato) VALUES (NULL,'{$_POST['nome_empresa']}','{$_POST['cnpj']}','{$_POST['endereco']}','{$_POST['telefone']}','{$_POST['contato']}')";
	
	if (!mysql_query($sql,$conexao)) {
		die('Error: ' . mysql_error());
	}
		mkdir($REPO_DIR.$_POST['nome_empresa']);
		mkdir($SVN_DIR.$_POST['nome_empresa']);
		mkdir($TMP_DIR.$_POST['nome_empresa']);
		echo "<span class='bold'>Empresa foi criada!</span>";
}

else if($_POST['operacao'] == "criar_servidor") {
	
  
	
  
	$empresa = mysql_query("select id_empresas from empresas where nome = '{$_POST["empresa"]}'");
	$row = mysql_fetch_row($empresa);
		
	$sql="INSERT INTO servidores (id_servidores, nome, ip, mascara, arquitetura, so, descricao, empresas_id_empresas) VALUES (NULL, '{$_POST['nome_server']}','{$_POST['ip']}','{$_POST['mascara']}','{$_POST['arquitetura']}','{$_POST['so']}','{$_POST['descricao']}','{$row[0]}')";
	
	if (!mysql_query($sql,$conexao)) {
		die('Error: ' . mysql_error());
	}
		svn_repos_create($SVN_DIR.$_POST["empresa"]."/".$_POST['nome_server']);
		svn_checkout('file://'.$SVN_DIR.$_POST["empresa"]."/".$_POST['nome_server'], $REPO_DIR.$_POST["empresa"]."/".$_POST['nome_server']);
		mkdir($TMP_DIR.$_POST["empresa"]."/".$_POST['nome_server']);
		criar_vhost($SVN_DIR, $_POST["empresa"],$_POST['nome_server']);
		echo "<span class='bold'>Servidor foi adicionado!</span>";	
		
		
}
else if($_POST['operacao'] == "atualizar_usuario") {
	
	mysql_query("UPDATE usuarios SET nome = '{$_POST['nome_user']}', login = '{$_POST['login']}', email = '{$_POST['email']}', cpf = '{$_POST['cpf']}', senha = '{$_POST['senha']}', permissao = '{$_POST['permissao']}' WHERE id_usuarios = '{$_POST['id']}'");
	echo "<span class='bold'>Usuário atualizado!</span>";
}

else if($_POST['operacao'] == "atualizar_servidor") {
	
	mysql_query("UPDATE servidores SET ip = '{$_POST['ip']}', mascara = '{$_POST['mascara']}', arquitetura = '{$_POST['arquitetura']}', so = '{$_POST['so']}', descricao  = '{$_POST['descricao']}' WHERE id_servidores = '{$_POST['id']}'");
	echo "<span class='bold'>Servidor foi atualizado!</span>";
}

else if($_POST['operacao'] == "atualizar_servico") {
	
	mysql_query("UPDATE servicos SET descricao = '{$_POST['descricao']}' WHERE id_servicos = '{$_POST['id']}'");	
	echo "<span class='bold'>Serviço foi atualizado!</span>";
}

else if($_POST['operacao'] == "enviar_servidor") {
	$servidor = mysql_query("select nome, empresas_id_empresas from servidores where id_servidores = '{$_POST["id"]}'");
	$id_servidor = mysql_fetch_row($servidor);
	
	$empresa = mysql_query("select nome from empresas where id_empresas = '{$id_servidor[1]}'");
	$id_empresa = mysql_fetch_row($empresa);
	
	//echo $REPO_DIR.$id_empresa[0]."/".$id_servidor[0];
	svn_commit('Commit System Automatic', array($REPO_DIR.$id_empresa[0]."/".$id_servidor[0]));
	
	echo "<span class='bold'>Informações enviadas com sucesso!</span>";
}

else if($_POST['operacao'] == "excluir_usuario") {

	mysql_query("DELETE FROM usuarios WHERE id_usuarios = {$_POST['id']}");
	
	echo "<span class='bold'>Usuário foi apagado!</span>";

}

else if($_POST['operacao'] == "excluir_empresa") {

	$empresa = mysql_query("select nome from empresas where id_empresas = '{$_POST["id"]}'");
	$id_empresa = mysql_fetch_row($empresa);
		
	$ponteiro = $REPO_DIR.$id_empresa[0]."/";
	$ponteiro2 = $SVN_DIR.$id_empresa[0]."/";
	$ponteiro3 = $TMP_DIR.$id_empresa[0]."/";
	exec('rm -rf '.$ponteiro.'');
	exec('rm -rf '.$ponteiro2.'');
	exec('rm -rf '.$ponteiro3.'');
		
	mysql_query("DELETE FROM empresas WHERE id_empresas = {$_POST['id']}");
	echo "<span class='bold'>Empresa foi apagada!</span>";

}

else if($_POST['operacao'] == "excluir_servidor") {

	$servidor = mysql_query("select nome, empresas_id_empresas from servidores where id_servidores = '{$_POST["id"]}'");
	$id_servidor = mysql_fetch_row($servidor);
	
	$empresa = mysql_query("select nome from empresas where id_empresas = '{$id_servidor[1]}'");
	$id_empresa = mysql_fetch_row($empresa);
	
	$ponteiro = $REPO_DIR.$id_empresa[0]."/".$id_servidor[0]."/";
	$ponteiro2 = $SVN_DIR.$id_empresa[0]."/".$id_servidor[0]."/";
	$ponteiro3 = $TMP_DIR.$id_empresa[0]."/".$id_servidor[0]."/";
	exec('rm -rf '.$ponteiro.'');
	exec('rm -rf '.$ponteiro2.'');
	exec('rm -rf '.$ponteiro3.'');
	
	mysql_query("DELETE FROM servidores WHERE id_servidores = {$_POST['id']}");
	echo "<span class='bold'>Servidor foi apagado!</span>";
	
}

else if($_POST['operacao'] == "excluir_servico") {

	$servico = mysql_query("select servidores_id_servidores, servidores_empresas_id_empresas, nome from servicos where id_servicos = '{$_POST["id"]}'");
	$id_servico = mysql_fetch_row($servico);
	
	$servidor = mysql_query("select nome from servidores where id_servidores = '{$id_servico[0]}'");
	$id_servidor = mysql_fetch_row($servidor);
	
	$empresa = mysql_query("select nome from empresas where id_empresas = '{$id_servico[1]}'");
	$id_empresa = mysql_fetch_row($empresa);
	
	$ponteiro = $REPO_DIR.$id_empresa[0]."/".$id_servidor[0]."/".$id_servico[2]."/";
	$ponteiro2 = $TMP_DIR.$id_empresa[0]."/".$id_servidor[0]."/".$id_servico[2]."/";
	exec('rm -rf '.$ponteiro.'');
	exec('rm -rf '.$ponteiro2.'');
	
	mysql_query("DELETE FROM servicos WHERE id_servicos = {$_POST['id']}");
	echo "<span class='bold'>Serviço foi apagado!</span>";

}
function criar_vhost($SVN_DIR, $empresa, $server){

	$novoarquivo = fopen("/etc/apache2/mods-available/dav_svn.conf", "a+");

	$t1 = $empresa.'-'.$server;
	$t2 = $SVN_DIR.$empresa.'/'.$server;
	
	$var[0] = "<Location /" . $t1 . ">";
	$var[1] = "DAV svn";
	$var[2] = "SVNPath " . $t2;
	$var[3] = "AuthType Basic";
	$var[4] = "AuthName \"Subversion repository\"";
	$var[5] = "AuthUserFile /etc/svn-passwd";
	$var[6] = "<LimitExcept GET PROPFIND OPTIONS REPORT>";
	$var[7] = "Require valid-user";
	$var[8] = "</LimitExcept>";
	$var[9] = "</Location>";
	$var[10] = " ";


	for($i=0; $i < 11; $i++){
		fwrite($novoarquivo, $var[$i] . "\n");
	}	
	
	fclose($novoarquivo);	
	exec('sudo /etc/init.d/apache2 reload');
}

?>
