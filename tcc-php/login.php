<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-BR" xml:lang="pt-BR">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema</title>
<link href="css/vmc.css" rel="stylesheet" type="text/css"></link>
<link href="jquery-ui/css/cupertino/jquery-ui-1.8.12.custom.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" charset="utf-8" src="js/jquery.min.js"></script>
<script language="javascript" src="jquery-ui/js/jquery-ui-1.8.12.custom.min.js"></script>
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
	
	
			</td>
		</tr>

		<tr>
			<td height="7" colspan="3"><img  src="img/dotclear.gif"   height="7" width="1" alt=""></td>
		</tr>

<tr>
	<td valign="top" width="5%">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="actionBorder" id="actionFormatTable">
			

		</table>
	</td>

	<!-- FIM MENU -->
	<td>
		<img width="10" height="1" src="img/dotclear.gif"/>
	</td>

	<!-- CONTEUDO -->
	<td width="95%" valign="top">
		<table class="vign-listViewTable" width="100%">
			<form action="#" method="post" >
				<table style="text-align: left; width: 100%;" border="0"  cellpadding="2" cellspacing="2">
					<tbody>
						<tr>
						  <td width="10%">Login:</td>
						  <td><input type="text" name="login" id="nome"  size="25"maxlength="15" value=""  /></td>
						</tr>
						<tr>
						  <td width="10%">Senha:</td>
						  <td><input type="password" name="senha" id="senha" size="25" maxlength="15" value="" /></td>
						</tr>						
					</tbody>
				</table>		
				<p>&nbsp;</p>
			</form>
			 <div id="enviar" class="button">Enviar</div>
			 
			 <div id="inclusao" class="ui-state-error ui-corner-all" style="display:none; width:300px; margin-top:25px"></div>
		</table>
	</td>

</tr>

		<tr>
                        <td height="7" colspan="3"><img  src="img/dotclear.gif"   height="7" width="1" alt=""></td>

                </tr>
        </table>
<script language="javascript">
$(function() {
	$(".button" ).button();		

	$('#senha').keypress(function(event) {
		  if (event.which == '13') {
		   $.ajax({
                type: "POST",
                url: "receber.php",
                data: {login: $("#nome").val(), senha: $("#senha").val(), operacao: "login"},
                success: function(msg){
                             $("#inclusao").html(msg);
                           $("#inclusao").css('display','block');

                }
        });

			}
	});

	$("#enviar").bind('click', function(){
        $.ajax({
                type: "POST",
                url: "receber.php",
                data: {login: $("#nome").val(), senha: $("#senha").val(), operacao: "login"},
                success: function(msg){
							$("#inclusao").html(msg);
							$("#inclusao").css('display','block');
								
                }
        });
	});	
});		

</script>
</body>
</html>
        
