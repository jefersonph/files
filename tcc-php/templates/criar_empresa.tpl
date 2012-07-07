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
                        						<td class="roleTitle" nowrap>Empresa</td>
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
		<span>Informações do Servidor:</span>
		<table id="c_empresa" class="vign-listViewTable" width="100%">
			  <tbody>
				<tr>
				  <td>Nome Empresa:</td>
				  <td><input id="nome_empresa" size="50" name="empresa"></td>
				</tr>
				<tr>
				  <td>CNPJ:</td>
				  <td><input id="cnpj" name="cnpj"></td>
				</tr>
				<tr>
				  <td>Endere&ccedil;o:</td>
				  <td><input id="endereco" name="endereco"></td>
				</tr>
				<tr>
				  <td>Telefone:</td>
				  <td><input id="telefone" name="telefone"></td>
				</tr>
				<tr>
				  <td>Contato:</td>
				  <td><input id="contato" name="contato"></td>
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
	$('#salvar').bind('click', function(){		
		$.ajax({
                type: "POST",
				url: "receber.php",
				data: {operacao:"criar_empresa", nome_empresa:$('#nome_empresa').val(), cnpj:$('#cnpj').val(), endereco:$('#endereco').val(), telefone: $('#telefone').val(), contato: $('#contato').val()  },
				success: function(msg){
				$("#results3").html(msg);
			}
        });
	});
	$('#cancelar').live('click', function() {
		window.history.back();
	});
	$('#empresa_op option').live('click', function(){		
		$.ajax({
			type: "POST",
			url: "receber.php",
			data: {operacao:"listar_servidores_option",empresa:$('#empresas').val(),op:"c_servico"},
			success: function(msg){
					$("#servidor_op").html(msg);
			}
		});	
	});
</script>
{/literal}
{include file="footer.tpl"}
