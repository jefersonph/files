{include file="header.tpl" title=foo}

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
                        						<td class="roleTitle" nowrap>Arquivos</td>
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
										<a class="roleaction"  href="javascript:window.history.back()"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Voltar</a>
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
		<table class="vign-listViewTable" width="100%">
			<form  id="form1" action="#" method="post">
				<p>
						Editor de Arquivo:<br />
						<textarea id="editor1" name="editor1"></textarea>
						{literal}
						<script type="text/javascript">
							CKEDITOR.config.startupMode = 'source';
							CKEDITOR.replace( 'editor1',
								{	
								toolbar :	
									[
									['Source','-'],
										['Cut','Copy','Paste','PasteText'],
										['Undo','Redo','-','SelectAll','RemoveFormat']								
									]
									});			
							CKEDITOR.instances.editor1.setData("<?php echo $t1; ?>");
						</script>
						{/literal}						
				</p>
			</form>
		<div class="button">Salvar</div>
		<div class="button">Cancelar</div>
		<div id="results"> </div>
		</table>
	</td>

</tr>
{literal}
<script language="javascript">
$("#aqui").bind('click', function(){
	$.ajax({
		type: "POST",
		url: "teste2.php",
		data: {ckeditor: $("#cke_editor1 textarea").val(), file:"nome.txt"},
		success: function(msg){
			$("#results").text(msg);
		}		
	});
});
$(function() {
	$(".button" ).button();		
});
</script>
{/literal}
{include file="footer.tpl"}

