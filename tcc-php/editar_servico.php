<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<?php
session_start();
include 'config.php';	
?>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-BR" xml:lang="pt-BR">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema</title>
<link href="css/vmc.css" rel="stylesheet" type="text/css"></link>
<link href="jquery-ui/css/cupertino/jquery-ui-1.8.12.custom.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" charset="utf-8" src="js/jquery.min.js"></script>
<script language="javascript" src="js/vignTables.js"></script>
<script language="javascript" src="js/common.js"></script>
<!--<script language="javascript" src="ckeditor/ckeditor.js"></script>-->
<script language="javascript" src="jquery-ui/js/jquery-ui-1.8.12.custom.min.js"></script>


<script language="javascript">
function msgAlerta(msg){
		if(msg!=''&&msg!=null){
			alert(msg);
		} 
}
</script>


</head>
<body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0" class="vign-consoleBody" onload="msgAlerta('');">
	<table id="table_master_table" width="100%" height="100%" cellpadding="0" cellspacing="0" border="0" class="vign-headerBackground">
		<tr class="vign-headerBackground2">
			<td class="vign-headerLogo" height="30" width="150"><img src="img/dotclear.gif" alt="" height="30" width="150" border="0"></td>
			<td class="vign-rightside-header" width="90%" colspan="2"><img src="img/dotclear.gif" alt="" height="30" width="600" border="0"></td>
        	</tr>

        	<tr class="vign-navbar" style="display:none">
                	<td id="vign-headerTitle" height="23">&nbsp;</td>
                	<td class="vign-rightside" colspan="2" id="vign-navcontainer">&nbsp;</td>
	        </tr>
        	<tr>
		        <td height="22" valign="top" colspan="3" id="vign-menucontainer">
	
	<script language="javascript" src="js/vignMenu.js"></script>

				<ul>

			                <li id="menuM0" onMouseOver="consoleMenus[0].showMenu()" onMouseOut="consoleMenus[0].hideMenu()"><a href="index.php?op=servidor" id="servidor">Servidor</a></li>
			                <li id="menuM1" onMouseOver="consoleMenus[1].showMenu()" onMouseOut="consoleMenus[1].hideMenu()"><a href="index.php?op=servico" id="servico">Serviço</a></li>
			                <li id="menuM2" onMouseOver="consoleMenus[2].showMenu()" onMouseOut="consoleMenus[2].hideMenu()"><a href="index.php?op=usuario" id="usuario">Usuário</a></li>
			                <li id="menuM3" onMouseOver="consoleMenus[3].showMenu()" onMouseOut="consoleMenus[3].hideMenu()"><a href="index.php?op=empresa" id="empresa">Empresa</a></li>
							<li class="last_item">&nbsp;</li>
			    </ul>

				<ul id="info_user">
					<li>USUÁRIO: <?php echo $_SESSION["login"];?></li>
					<li>PERMISSÃO: <?php echo $_SESSION["permissao"];?></li>
					<li><a href="#" onClick="sair()" id="sair">LOGOUT</a></li>
				</ul>
				<div id="results_sair"></div>
	

	<script language="javascript" src="js/vignMenuConfig.js"></script>


			</td>

		</tr>

		<tr>
			<td height="7" colspan="3"><img  src="img/dotclear.gif"   height="7" width="1" alt=""></td>
		</tr>
<tr>
	<td valign="top" width="5%">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="actionBorder" id="actionFormatTable">
			<tr>
				<td valign="top" height="20" bgcolor="#FFFFFF" class="actionBorderHead">

					Menu de Ações<br><img src="img/dotclear.gif" height="1" width="180">
				</td>
			</tr>

			<tr>
				<td valign="top" class="actionBkgrd">
					<div  style="overflow:scroll:height:100%">
						<div id="ApplicationAdministratorMenu1" style="display:block">

							<table width="100%" border="0" cellspacing="0" cellpadding="5" bordercolor="#FFFFFF" id="ApplicationAdministratorTable">
								<tr>
                        						<td class="roleTitle" nowrap>Serviços</td>
						                        <td class="roleTitle" width="17" align="right">
						                            	<a href="javascript:toggleRoleActionDiv(document.getElementById('ApplicationAdministrator1'))">
					                                	<img src="img/shade.gif" alt="Mostrar/Ocultar ações para esta seção" height="19" width="17" align="right" border="0" hspace="8">
						                                </a>
						                         </td>

								</tr>
							</table>
						        <table width="100%" border="0" cellspacing="0" cellpadding="10" bordercolor="#FFFFFF" id="ApplicationAdministrator1" >
								<tr>
									<td class="actionbkgrd">
										<a class="roleaction" href="javascript:window.history.back()"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Voltar</a>
									</td>
								</tr>

								<tr>
									<td class="actionbkgrd">
										<a class="roleaction" href="#"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Listar</a>
										<!--<a class="roleaction" href="#"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Listar</a>-->
									</td>
								</tr>
							</table>
						</div>

					</div>
				</td>
			</tr>

		</table>
	</td>

	<!-- FIM MENU -->
	<td>
		<img width="10" height="1" src="img/dotclear.gif"/>

	</td>
	<!-- CONTEUDO -->
	<td width="95%" valign="top">
				<div id="result"></div>
				<div id="result3"></div>
			</td>

</tr>

<script language="javascript">
	var idservico = <?php echo $_GET['id'];?>;
	$.ajax({
                type: "POST",
				url: "receber.php",
				data: {operacao:"editar_servico", idservico: idservico},
				success: function(msg){
					$("#result").html(msg);
					$(".button" ).button();
					$.ajax({
							type: "POST",
							url: "receber.php",
							data: {operacao:"listar_empresas_option"},
							success: function(msg){
									$("#empresa_op").html(msg);
									$.ajax({
										type: "POST",
										url: "receber.php",
										data: {operacao:"listar_servidores_option",empresa:$('#empresas').val(),op:"c_servico", servidor:$('#servidor_op').find('option').filter(':selected').text()},
										success: function(msg){
												$("#servidor_op").html(msg);
										}
									});	
							}
					});
			}
    });
	$('#cancelar').live('click', function() {
		window.history.back();
	});
	
	
	$('#empresa_op option').live('click', function(){		
		$.ajax({
			type: "POST",
			url: "receber.php",
			data: {operacao:"listar_servidores_option",empresa:$('#empresas').val(),op:"c_servico", servidor:$('#servidor_op').find('option').filter(':selected').text()},
			success: function(msg){
					$("#servidor_op").html(msg);
			}
		});	
	});
	$('#salvar').live('click', function() {
		$.ajax({
                type: "POST",
				url: "receber.php",
				data: {operacao:"atualizar_servico", id: idservico, descricao: $('#descricao').val()},
				success: function(msg){
				$("#result3").html(msg);
			}
        });
	});
	$('#cancelar').live('click', function() {
		window.history.back();
	});

	
</script>

		<tr>
                        <td height="7" colspan="3"><img  src="img/dotclear.gif"   height="7" width="1" alt=""></td>
                </tr>
        </table>
</body>
</html>
        