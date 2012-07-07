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
                        						<td class="roleTitle" nowrap>Usuário</td>
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
		{if $smarty.session.permissao eq "administrador"}
		<span>Informações do Usuário:</span>
		<table id="c_usuario" class="vign-listViewTable" width="100%">
			  <tbody>
				<tr>
				  <td>Nome:</td>
				  <td><input id="nome_user" size="50" name="nome"></td>
				</tr>
				<tr>
				  <td>Senha:</td>
				  <td><input id="senha" name="senha" type="password"></td>
				</tr>
				<tr>
				  <td>Login:</td>
				  <td><input id="login" name="login"></td>
				</tr>
				<tr>
				  <td>E-Mail</td>
				  <td><input id="email" name="email"></td>
				</tr>
				<tr>
				  <td>CPF:</td>
				  <td><input id="cpf" name="cpf"></td>
				</tr>
				<tr>
				  <td>Permissão:</td>				  
				  <td>
					<div id="permissao_op">
					<select>
					  <option>administrador</option>
					  <option>moderado</option>
					  <option>restrito</option>					  
					</select>
					</div>
				  </td>
				</tr>
				<tr>
				  <td>Empresa:</td>
				  <td><div id="empresa_op"></div></td>
				</tr>
				<tr>
				  <td>
					<br />
					<div id="salvar" class="button">Salvar</div>
					<div id="cancelar" class="button">Cancelar</div>	
					
				  
				  <div id="results3"></div>
				  </td>
				</tr>
			  </tbody>			
		</table>		
		{/if}
	</td>

</tr>
{literal}
<script language="javascript">
	$(function() {
		$(".button" ).button();
	});
	$.ajax({
			type: "POST",
			url: "receber.php",
			data: {operacao:"listar_empresas_option"},
			success: function(msg){
					$("#empresa_op").html(msg);
			}
	});
	$('#salvar').bind('click', function(){		
		$.ajax({
                type: "POST",
				url: "receber.php",
				data: {operacao:"criar_usuario", login:$('#login').val() ,nome_user:$('#nome_user').val(), senha:$('#senha').val(),email:$('#email').val(), cpf:$('#cpf').val(), setor: $('#setor').val() , empresa:$('#empresa_op').find('option').filter(':selected').text(), permissao:$('#permissao_op').find('option').filter(':selected').text() },
				success: function(msg){
				$("#results3").html(msg);
			}
        });
	});
	$('#cancelar').live('click', function() {
		window.history.back();
	});
</script>
{/literal}
{include file="footer.tpl"}
