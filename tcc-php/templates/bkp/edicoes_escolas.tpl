
{literal}
<script language="javascript">
function validar(){	
	if (infraTrim(document.getElementById('edicoes_id').value)=='0') {
    	alert('Selecione a edição.');
    	document.getElementById('edicoes_id').focus();
    	return false;
  	}else if ((infraTrim(document.getElementById('escolas_id').value)=='')) {
    	alert('Selecione a escola.');
    	document.getElementById('escolas_id').focus();
    	return false;
  	}else if ((infraTrim(document.getElementById('ordem_desfile').value)=='')) {
    	alert('Informe a ordem do desfile');
    	document.getElementById('ordem_desfile').focus();
    	return false;
  	}else{
  		document.getElementById('form1').submit();
  	}
}

function criaJson(edicoes_id){
		document.getElementById('act').value="{$AACT[0]}.jsoncont";
		document.getElementById('hdnedicoesid').value=document.getElementById(edicoes_id).value;
  		document.getElementById('form1').submit();
}
</script>
{/literal}
	<!-- CONTEUDO -->
	<td width="95%" valign="top">
		<table class="vign-listViewTable" width="100%">
			<tr>
				<td>			
					<form id="form1" name="form" method="POST" action="{$FORM_SEND}" style="display:inline">
						<input type="hidden" id="act" name="act" value="{$AACT[0]}.{$AACT[1]}.{$AACT[2]}" />
						<input type="hidden" id="hdnedicoesid" name="hdnedicoesid"/>
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
								<label  class="vign-formElementLabelRequired">	Edição: </label>
							</td>
							<td width="10%">

							{if $AACT[2] eq 'upd'}
								<input type="hidden" id="edicoes_id" name="edicoes_id" size="10" readonly value="{$EDICAO.ID_EDICAO}" class="vign-formElementControl" />
							 	{$EDICAO.ESTADO} - {$EDICAO.ANO}
							{else}
									<select id="edicoes_id" name="edicoes_id" onchange="{if $EDICAO.ID_ESCOLA}zeraCombo(document.form.escolas_id);{/if}submit();">
                                                                        {html_options values=$edicoes_ids selected=$edicoes_id output=$edicoes_names}
                                                                </select>
							{/if}
							</td>
						</tr>
						<tr>		
							<td nowrap="nowrap">
								<label  class="vign-formElementLabelRequired">	Escolas: </label>
							</td>
							<td width="90%">
							{if $AACT[2] eq 'upd'}
								<input type="hidden" id="escolas_id" name="escolas_id" size="10" readonly value="{$EDICAO.ID_ESCOLA}" class="vign-formElementControl" />
							 	{$EDICAO.NOME}
							{else}
								<select id="escolas_id" name="escolas_id" >
                                                                        {html_options values=$escolas_ids selected=$escolas_id output=$escolas_names}
                                                                </select>
							{/if}
							</td>
						</tr>
						<tr>
                                                        <td nowrap="nowrap">
                                                                <label  class="vign-formElementLabelRequired">  Ordem de desfile: </label>
                                                        </td>
                                                        <td width="90%">
                                                                <input type="text" id="ordem_desfile" name="ordem_desfile" size="10" maxlength="2" value="{$EDICAO.ORDEM_DESFILE}" class="vign-formElementControl" onkeypress="return infraIsNumberPressed(this,event)"/>
                                                        </td>
                                                </tr>
						<tr>
                                                        <td nowrap="nowrap">
                                                                <label  class="vign-formElementLabelRequired">  Posição: </label>
                                                        </td>
                                                        <td width="90%">
                                                                <input type="text" name="posicao" size="10" maxlength="2" value="{$EDICAO.POSICAO}" class="vign-formElementControl" onkeypress="return infraIsNumberPressed(this,event)"/>
                                                        </td>
                                                </tr>
						<tr>
                                                        <td nowrap="nowrap">
                                                                <label  class="vign-formElementLabelRequired">  Url: </label>
                                                        </td>
                                                        <td width="90%">
                                                                <input type="text" name="url" size="100" maxlength="300" value="{$EDICAO.URL}" class="vign-formElementControl" />
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
							<th class="vign-gridColumnHead"  scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Edição</span>
				  			</th>
							<th class="vign-gridColumnHead"  scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Escolas
									<img width="250" height="10" src="img/dotclear.gif"/> Ordem
									<img width="25" height="10" src="img/dotclear.gif"/>Posição
									<img width="25" height="10" src="img/dotclear.gif"/>Opções
								</span>
				  			</th>
				  			<th class="vign-gridColumnHead"  scope="col" align="left">
								<span class="vign-gridHeaderTitleText">Atualiza classificação</span>
				  			</th>
						</tr>
						<!-- LINHAS -->
						{section name=row loop=$LIST_EDICAO_GROUP}
						<tr>
							<td class="{$CLASS_CSS[row]}" width="10%">
								{$LIST_EDICAO_GROUP[row].ESTADO} - {$LIST_EDICAO_GROUP[row].ANO}
							</td>
							<td class="{$CLASS_CSS[row]}" >
							{section name=row2 loop=$LIST_ESCOLAS_EDICAO[row]}
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
								<td class="{$CLASS_CSS[row]}" width="300px">
									<a href="{$AACT[0]}.php?act={$AACT[0]}.relEscola.get&edicoes_id={$LIST_ESCOLAS_EDICAO[row][row2].ID_EDICAO}&escolas_id={$LIST_ESCOLAS_EDICAO[row][row2].ID_ESCOLA}">{$LIST_ESCOLAS_EDICAO[row][row2].NOME}</a>
								</td>	
								<td class="{$CLASS_CSS[row]}" width="60px">
									{$LIST_ESCOLAS_EDICAO[row][row2].ORDEM_DESFILE}
								</td>	
								<td class="{$CLASS_CSS[row]}" width="60px">
									{if $LIST_ESCOLAS_EDICAO[row][row2].POSICAO eq ''} - {/if}
									{$LIST_ESCOLAS_EDICAO[row][row2].POSICAO}
								</td>	
							<td class="{$CLASS_CSS[row]}" width="10%">
								<a href="{$AACT[0]}.php?act={$AACT[0]}.relEscola.get&edicoes_id={$LIST_ESCOLAS_EDICAO[row][row2].ID_EDICAO}&escolas_id={$LIST_ESCOLAS_EDICAO[row][row2].ID_ESCOLA}">Alterar</a>
							</td>	
							<td class="{$CLASS_CSS[row]}" width="10%">
								<a href="{$AACT[0]}.php?act={$AACT[0]}.relEscola.del&edicoes_id={$LIST_ESCOLAS_EDICAO[row][row2].ID_EDICAO}&escolas_id={$LIST_ESCOLAS_EDICAO[row][row2].ID_ESCOLA}" onclick="return confirm('Deseja excluir?')">Excluir</a>
								<input type="hidden" id="{$LIST_EDICAO_GROUP[row].ESTADO}-{$LIST_EDICAO_GROUP[row].ANO}" name="{$LIST_EDICAO_GROUP[row].ESTADO}-{$LIST_EDICAO_GROUP[row].ANO}" value="{$LIST_ESCOLAS_EDICAO[row][row2].ID_EDICAO}">
							</td>
							</tr>
							</table>
							{/section}
							</td>
							<td class="{$CLASS_CSS[row]}">
								<input type="button" name="doOK" class="vign-formDialogButton"	value="Atualizar classificação no site" onclick="criaJson('{$LIST_EDICAO_GROUP[row].ESTADO}-{$LIST_EDICAO_GROUP[row].ANO}');">
							</td>
						</tr>
						{/section}

						<!-- /LINHAS -->
					</table>
				</td>	
			</tr>
		</table>
	</td>