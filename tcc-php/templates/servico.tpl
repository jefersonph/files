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
								{if $smarty.session.permissao neq "restrito"}
								<tr>
									<td class="actionbkgrd">
										<a class="roleaction"  href="index.php?op=c_servico"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Criar</a>
									</td>
								</tr>
								{/if}
								<tr>
									<td class="actionbkgrd">
										<a class="roleaction" href="#"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Listar</a>										
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
			{if $smarty.session.permissao eq "administrador"}
				Escolha a empresa:				
			{/if}	
			<div id="results"> </div>
			<div id="results2"> </div>
			<div id="results3"> </div>
			<div id="results_update"> </div>
		</table>
	</td>

</tr>
{if $smarty.session.permissao eq "administrador"}
{literal}
<script language="javascript">
	$.ajax({
			type: "POST",
			url: "receber.php",
			data: {operacao:"listar_empresas_option"},
			success: function(msg){
					$("#results").html(msg);
			}
	});
	$('#empresas option').live('click', function(){
		$.ajax({
                type: "POST",
				url: "receber.php",
				data: {operacao:"listar_servidores_option",empresa: $(this).val()},
				success: function(msg){
				$("#results2").html(msg);
			}
        });
	});
	$('#servidores option').live('click', function(){		
		$.ajax({
                type: "POST",
				url: "receber.php",
				data: {operacao:"listar_servicos", servidor:$(this).val(), empresa:$('#empresas').val()},
				success: function(msg){
				$("#results3").html(msg);
			}
        });
	});
	
</script>
{/literal}
{/if}

{if $smarty.session.permissao neq "administrador"}
{literal}
<script language="javascript">
		$.ajax({
                type: "POST",
				url: "receber.php",
				data: {operacao:"listar_servidores_option", empresa:"false"},
				success: function(msg){
				$("#results").html(msg);
			}
        });
	
	$('#servidores option').live('click', function(){
		$.ajax({
                type: "POST",
				url: "receber.php",
				data: {operacao:"listar_servicos", servidor:$(this).val(), empresa:"false"},
				success: function(msg){
				$("#results2").html(msg);
			}
        });
	});

</script>
{/literal}
{/if}
{include file="footer.tpl"}
