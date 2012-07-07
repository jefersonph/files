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
		{if $smarty.session.permissao neq "restrito"}
		<table class="vign-listViewTable" width="100%">
			  <tbody>
				<tr>
				  <td>Nome Servi&ccedil;o:</td>
				  <td><input id="nome_servico" size="50" name="servico"></td>
				</tr>
				<tr>
				  <td>Descri&ccedil;&atilde;o:</td>
				  <td><input id="descricao" name="descricao"></td>
				</tr>
				<tr>
				  <td>Arquivo de Configura&ccedil;&atilde;o:</td>
				  <td><input id="arquivo_conf" name="arqConfig"></td>
				</tr>
				<tr>
				  <td>Empresa:</td>
				  <td><div id="empresa_op"></div></td>
				</tr>
				<tr>
				  <td>Servidor:</td>
				  <td><div id="servidor_op">
					<select>
						<option></option>
					</select
				  </div></td>
				</tr>
				<tr>
				  <td>
					<br />
					<div id="salvar" class="button">Salvar</div>
					<div id="cancelar "class="button">Cancelar</div>	
					
				  
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
	$('#salvar').bind('click', function(){		
		$.ajax({
                type: "POST",
				url: "receber.php",
				data: {operacao:"criar_servico", nome_servico:$('#nome_servico').val(), descricao: $('#descricao').val(),arquivo_conf: $('#arquivo_conf').val(), empresa:$('#empresa_op').find('option').filter(':selected').text(), servidor:$('#servidor_op').find('option').filter(':selected').text() },
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
