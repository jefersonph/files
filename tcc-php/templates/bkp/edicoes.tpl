{include file="header.tpl" title=foo}

{literal}
<script language="javascript">
function validar(){	
	if (infraTrim(document.getElementById('estado').value)=='') {
    	alert('Informe o estado.');
    	document.getElementById('estado').focus();
    	return false;
  	}else if ((infraTrim(document.getElementById('ano').value)=='')) {
    	alert('Informe o ano.');
    	document.getElementById('ano').focus();
    	return false;
  	}else if((document.getElementById('ano').value<2000)){
  		alert('Informe um ano válido.');
    	document.getElementById('ano').focus();
    	return false;
  	}else if (infraTrim(document.getElementById('num_jurados').value)=='') {
    	alert('Informe o número de jurados.');
    	document.getElementById('num_jurados').focus();
    	return false;
  	}else if (infraTrim(document.getElementById('num_rebaixados').value)=='') {
    	alert('Informe o número de rebaixados.');
    	document.getElementById('num_rebaixados').focus();
    	return false;
  	}else{
  		document.getElementById('form1').submit();
  	}
}
</script>
{/literal}

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
                        						<td class="roleTitle" nowrap>Edições</td>
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
										<a class="roleaction" href="edicoes.php?act=edicoes.add"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Criar</a>
									</td>
								</tr>
								<tr>
									<td class="actionbkgrd">
										<a class="roleaction" href="edicoes.php?act=edicoes.upd"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Listar</a>
									</td>
								</tr>
								<tr>
									<td class="actionbkgrd">
										<a class="roleaction" href="edicoes.php?act=edicoes.relEscola"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Relacionar Escolas</a>
									</td>
								</tr>
								<tr>
									<td class="actionbkgrd">
										<a class="roleaction" href="edicoes.php?act=edicoes.relQuesito"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Relacionar Quesitos</a>
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
	{if $FLAG neq 'escola' and $FLAG neq 'quesito'}
	<td width="95%" valign="top">
		<table class="vign-listViewTable" width="100%">
			<tr>
				<td>			
					<form id="form1" name="form" method="POST" action="{$FORM_SEND}" style="display:inline">
						<input type="hidden" name="act" value="{$AACT[0]}.{$AACT[1]}" />
						<input type="hidden" name="add" value="1" />
						<input type="hidden" name="list" value="1" />
						<tr>
							<td colspan="2" class="toptd">
						                <div class="vign-dialogTabDiv">
							                    <ul class="vign-tabList">
					        		                <li id="search-li" class="vign-onItem">Edições | </li>
					                        		<li id="projects-li">Criar / Alterar</li>
							                    </ul>
							         </div>
							</td>
						</tr>				
						<tr>
							<td colspan="2">
								<div style="color:green;"></div>		
							</td>
						</tr>	
						{if $AACT[1] eq 'upd'}
							<input type="hidden" name="id" size="10" readonly value="{$EDICAO.ID_EDICAO}" class="vign-formElementControl" />
						{/if}
						<tr>		
							<td nowrap="nowrap">
								<label  class="vign-formElementLabelRequired">	Estado: </label>
							</td>
							<td width="90%">
								<input type="text" name="estado" id="estado" size="5" maxlength="2" value="{$EDICAO.ESTADO}" class="vign-formElementControl" />
							</td>
						</tr>
						<tr>		
							<td nowrap="nowrap">
								<label  class="vign-formElementLabelRequired">	Ano: </label>
							</td>
							<td width="90%">
								<input type="text" name="ano" id="ano" size="10" maxlength="4" value="{$EDICAO.ANO}" class="vign-formElementControl" onkeypress="return infraIsNumberPressed(this,event)"/>
							</td>
						</tr>
						<tr>		
							<td nowrap="nowrap">
								<label  class="vign-formElementLabelRequired">	Número de Jurados: </label>
							</td>
							<td width="90%">
								<input type="text" id="num_jurados" name="num_jurados" size="10" maxlength="10" value="{$EDICAO.NUM_JURADOS}" class="vign-formElementControl" onkeypress="return infraIsNumberPressed(this,event)"/>
							</td>
						</tr>
						<tr>		
							<td nowrap="nowrap">
								<label  class="vign-formElementLabelRequired">	Número de Rebaixados: </label>
							</td>
							<td width="90%">
								<input type="text" id="num_rebaixados" name="num_rebaixados" size="10" maxlength="10" value="{$EDICAO.NUM_REBAIXADOS}" class="vign-formElementControl" onkeypress="return infraIsNumberPressed(this,event)"/>
							</td>
						</tr>
						<tr>		
							<td nowrap="nowrap">
								<label  class="vign-formElementLabelRequired">	Descarte de Notas: </label>
							</td>
							<td width="90%">
								<select name=descarte_id>
									{html_options values=$descarte_ids selected=$descarte_id output=$descarte_names}
								</select>

							</td>
						</tr>
						<tr>		
							<td nowrap="nowrap">
								<label  class="vign-formElementLabelRequired">	Finalizada: </label>
							</td>
							<td width="90%">
								<select name=finalizado_id>
									{html_options values=$finalizado_ids selected=$finalizado_id output=$finalizado_names}
								</select>

							</td>
						</tr>


						<tr>
							<td nowrap="nowrap"></td>
							<td width="90%">
								<input type="button" name="doOK" class="vign-formDialogButton"	value="Salvar" onclick="validar();">
							&nbsp&nbsp{$MSG}
							</td>
						</tr>
					</form>
				</td>
			</tr> 
			<tr>
				<td colspan="2">
					<img width="1" height="10" src="img/dotclear.gif"/>
				</td>
			</tr>
			<tr>
				<td class="vign-gridBG" colspan="2">
					<table id="table_gridList_propertyPage" border="0" cellspacing="0" cellpadding="10" width="100%" summary="List View" >
						<tr class="vign-gridHeaderTitleRow" >
							<th class="vign-gridColumnHead" scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Código</span>
							</th>
							<th class="vign-gridColumnHead"  scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Estado</span>
				  			</th>
							<th class="vign-gridColumnHead"  scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Ano</span>
				  			</th>
							<th class="vign-gridColumnHead"  scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Num Jurados</span>
				  			</th>
							<th class="vign-gridColumnHead"  scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Num Rebaixados</span>
				  			</th>
							<th class="vign-gridColumnHead"  scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Descarte de Nota</span>
				  			</th>
							<th class="vign-gridColumnHead"  scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Finalizada</span>
				  			</th>
							<th class="vign-gridColumnHead"  scope="col" align="left" colspan="2">
								<span class="vign-gridHeaderTitleText">Opções</span>
				  			</th>
						</tr>
						<!-- LINHAS -->
						{section name=row loop=$LIST_EDICOES}
						<tr>
							<td class="{$CLASS_CSS[row]}" width="10%">
								{$LIST_EDICOES[row].ID_EDICAO}
							</td>
							<td class="{$CLASS_CSS[row]}" width="10%">
								{$LIST_EDICOES[row].ESTADO}
							</td>
							<td class="{$CLASS_CSS[row]}" width="10%">
								{$LIST_EDICOES[row].ANO}
							</td>
							<td class="{$CLASS_CSS[row]}" width="10%">
								{$LIST_EDICOES[row].NUM_JURADOS}
							</td>	
							<td class="{$CLASS_CSS[row]}" width="10%">
								{$LIST_EDICOES[row].NUM_REBAIXADOS}
							</td>	
							<td class="{$CLASS_CSS[row]}" width="10%">
								{$LIST_EDICOES[row].DESCARTE_NOTA}
							</td>	
							<td class="{$CLASS_CSS[row]}" width="10%">
								{$LIST_EDICOES[row].FINALIZADO}
							</td>	
							<td class="{$CLASS_CSS[row]}" width="10%">
								<a href="{$AACT[0]}.php?act={$AACT[0]}.upd&id={$LIST_EDICOES[row].ID_EDICAO}">Alterar</a>
							</td>	
							<td class="{$CLASS_CSS[row]}" width="10%">
									<a href="{$AACT[0]}.php?act={$AACT[0]}.del&id={$LIST_EDICOES[row].ID_EDICAO}" onclick="return confirm('Deseja excluir?')">Excluir</a>
							</td>	
						</tr>
						{/section}

						<!-- /LINHAS -->
					</table>
				</td>	
			</tr>
		</table>
	</td>
	{elseif $FLAG eq 'escola'}
		{include file="edicoes_escolas.tpl"}
	{elseif $FLAG eq 'quesito'}
		{include file="edicoes_quesitos.tpl"}

	{/if}
	

</tr>

{include file="footer.tpl"}
