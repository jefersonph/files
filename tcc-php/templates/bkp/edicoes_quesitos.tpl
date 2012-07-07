{literal}
<script language="javascript">
function validar(){	
	if (infraTrim(document.getElementById('edicoes_id').value)=='0') {
    	alert('Selecione a edição.');
    	document.getElementById('edicoes_id').focus();
    	return false;
  	}else if (infraTrim(document.getElementById('quesitos_id').value)=='0') {
    	alert('Selecione o quesito.');
    	document.getElementById('quesitos_id').focus();
    	return false;
  	}else if (infraTrim(document.getElementById('ordem').value)=='') {
    	alert('Informe a ordem de apuração.');
    	document.getElementById('ordem').focus();
    	return false;
  	}else if (infraTrim(document.getElementById('ordem_desempate').value)=='') {
    	alert('Informe a ordem de desempate.');
    	document.getElementById('ordem_desempate').focus();
    	return false;
  	}else{
  		document.getElementById('form1').submit();
  	}
}
</script>
{/literal}
	<!-- CONTEUDO -->
	<td width="95%" valign="top">
		<table class="vign-listViewTable" width="100%">
			<tr>
				<td>			
					<form id="form1" name="form" method="POST" action="{$FORM_SEND}" style="display:inline">
						<input type="hidden" name="act" value="{$AACT[0]}.{$AACT[1]}.{$AACT[2]}" />
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
						<tr>		
							<td nowrap="nowrap">
								<label  class="vign-formElementLabelRequired">	Edição: </label>
							</td>
							<td width="10%">

							{if $AACT[2] eq 'upd'}
								<input type="hidden" id="edicoes_id" name="edicoes_id" size="10" readonly value="{$EDICAO.ID_EDICAO}" class="vign-formElementControl" />
							 	{$EDICAO.ESTADO} - {$EDICAO.ANO}
							{else}
								<select id="edicoes_id" name="edicoes_id" onchange="{if $EDICAO.ID_QUESITO}zeraCombo(document.form.quesitos_id);{/if}submit();">
                                                                        {html_options values=$edicoes_ids selected=$edicoes_id output=$edicoes_names}
                                                                </select>
							{/if}
							</td>
						</tr>
						<tr>		
							<td nowrap="nowrap">
								<label  class="vign-formElementLabelRequired">	Quesitos: </label>
							</td>
							<td width="90%">
							{if $AACT[2] eq 'upd'}
								<input type="hidden" id="quesitos_id" name="quesitos_id" size="10" readonly value="{$EDICAO.ID_QUESITO}" class="vign-formElementControl" />
							 	{$EDICAO.NOME}
							{else}
								<select name="quesitos_id" id="quesitos_id" >
                                                                        {html_options values=$quesitos_ids selected=$quesitos_id output=$quesitos_names}
                                                                </select>
							{/if}
							</td>
						</tr>
						<tr>
                                                        <td nowrap="nowrap">
                                                                <label  class="vign-formElementLabelRequired">  Ordem Apuração: </label>
                                                        </td>
                                                        <td width="90%">
                                                                <input type="text" id="ordem" name="ordem" size="10" maxlength="2" value="{$EDICAO.ORDEM}" class="vign-formElementControl" onkeypress="return infraIsNumberPressed(this,event)"/>
                                                        </td>
                                                </tr>
						<tr>
                                                        <td nowrap="nowrap">
                                                                <label  class="vign-formElementLabelRequired">  Ordem de Desempate: </label>
                                                        </td>
                                                        <td width="90%">
                                                                <input type="text" id="ordem_desempate" name="ordem_desempate" size="10" maxlength="2" value="{$EDICAO.ORDEM_DESEMPATE}" class="vign-formElementControl" onkeypress="return infraIsNumberPressed(this,event)"/>
                                                        </td>
                                                </tr>
						<tr>
                                                        <td nowrap="nowrap">
                                                                <label  class="vign-formElementLabelRequired">  Imagem: </label>
                                                        </td>
                                                        <td width="90%">
                                                                <input type="text" name="imagem" size="100" maxlength="100" value="{$EDICAO.IMAGEM}" class="vign-formElementControl" />
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
								<span class="vign-gridHeaderTitleText">Quesitos
									<img width="250" height="10" src="img/dotclear.gif"/> Ordem
									<img width="25" height="10" src="img/dotclear.gif"/>Ordem Desempate
									<img width="25" height="10" src="img/dotclear.gif"/>Opções
								</span>
				  			</th>
						</tr>
						<!-- LINHAS -->
						{section name=row loop=$LIST_EDICAO_GROUP}
						<tr>
							<td class="{$CLASS_CSS[row]}" width="10%">
								{$LIST_EDICAO_GROUP[row].ESTADO} - {$LIST_EDICAO_GROUP[row].ANO}
							</td>
							<td class="{$CLASS_CSS[row]}" width="90%">
							{section name=row2 loop=$LIST_QUESITOS_EDICAO[row]}
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="{$CLASS_CSS[row]}" width="300px">
										<a href="{$AACT[0]}.php?act={$AACT[0]}.relQuesito.get&edicoes_id={$LIST_QUESITOS_EDICAO[row][row2].ID_EDICAO}&quesitos_id={$LIST_QUESITOS_EDICAO[row][row2].ID_QUESITO}">{$LIST_QUESITOS_EDICAO[row][row2].NOME}</a>
									</td>	
									<td class="{$CLASS_CSS[row]}" width="60px">
										{$LIST_QUESITOS_EDICAO[row][row2].ORDEM}
									</td>	
									<td class="{$CLASS_CSS[row]}" width="160px">
										{$LIST_QUESITOS_EDICAO[row][row2].ORDEM_DESEMPATE}
									</td>	
									<td class="{$CLASS_CSS[row]}" width="40px">
										<a href="{$AACT[0]}.php?act={$AACT[0]}.relQuesito.get&edicoes_id={$LIST_QUESITOS_EDICAO[row][row2].ID_EDICAO}&quesitos_id={$LIST_QUESITOS_EDICAO[row][row2].ID_QUESITO}">Alterar</a>
									</td>	
									<td class="{$CLASS_CSS[row]}" width="40px">
										<a href="{$AACT[0]}.php?act={$AACT[0]}.relQuesito.del&edicoes_id={$LIST_QUESITOS_EDICAO[row][row2].ID_EDICAO}&quesitos_id={$LIST_QUESITOS_EDICAO[row][row2].ID_QUESITO}" onclick="return confirm('Deseja excluir?')">Excluir</a>
									</td>	
								</tr>
							</table>
							{/section}
							</td>
						</tr>
						{/section}

						<!-- /LINHAS -->
					</table>
				</td>	
			</tr>
		</table>
	</td>


