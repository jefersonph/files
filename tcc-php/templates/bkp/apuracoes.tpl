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
                        						<td class="roleTitle" nowrap>Apurações</td>
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
										<a class="roleaction" href="apuracoes.php?act=apuracoes.add"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Notas</a>
									</td>
								</tr>
								<tr>
									<td class="actionbkgrd">
										<a class="roleaction" href="descontos.php?act=descontos.add"><img width="16" height="13" hspace="8" border="0" src="img/action.gif">Punição</a>
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
			<tr>
				<td>			
					<form name="form" method="POST" action="{$FORM_SEND}" style="display:inline">
						<input type="hidden" name="act" value="{$AACT[0]}.{$AACT[1]}.lst" />
						<input type="hidden" name="add" value="1" />
						<tr>
							<td colspan="2" class="toptd">
						                <div class="vign-dialogTabDiv">
							                    <ul class="vign-tabList">
					        		                <li id="search-li" class="vign-onItem">Apurações | </li>
					                        		<li id="projects-li">Notas</li>
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
                                                                <label  class="vign-formElementLabelRequired">  Edição: </label>
                                                        </td>
                                                        <td width="90%">

                                                                <select name=edicoes_id onchange="{if $LIST eq 'quesito'}zeraCombo(document.form.quesitos_id);{/if}submit();">
                                                                        {html_options values=$edicoes_ids selected=$edicoes_id output=$edicoes_names}
                                                                </select>
                                                        </td>
                                                </tr>
						{if $LIST eq 'quesito'}
						<tr>
							
                                                        <td nowrap="nowrap">
                                                                <label  class="vign-formElementLabelRequired">  Quesito: </label>
                                                        </td>
                                                        <td width="90%">
								<select name=quesitos_id onchange="submit();">
                                                                        {html_options values=$quesitos_ids selected=$quesitos_id output=$quesitos_names}
                                                                </select>
							</td>
						</tr>
						{/if}
					</form>
			</td>
		</tr>
	</table>
	{if $FLAG eq 'escola'}
	
	<table class="vign-listViewTable" width="100%">
		<tr>
			<td colspan="2">
				<img width="1" height="10" src="img/dotclear.gif"/>
			</td>
		</tr>
		<tr>
			<td width="100%">
					<form name="form2" method="POST" action="{$FORM_SEND}" style="display:inline">
						<input type="hidden" name="act" value="{$AACT[0]}.{$AACT[1]}.add" />
						{if $AACT[1] eq 'add'}
							<input type="hidden" name="edicoes_id" value="{$edicoes_id}" />
							<input type="hidden" name="quesitos_id"value="{$quesitos_id}"  />
						{/if}
					
						<table width="100%">
	                                                <tr>
								<td></td>
							{section name=jurado loop=$NUM_JURADOS}
        	                                                <td class="vign-gridBody1Details">
                		                                	Jurado{$smarty.section.jurado.index_next}
                                	            		 </td>
							{/section}
							</tr>
							{section name=row loop=$LIST_ESCOLAS_EDICAO}
	                                                <tr class="{cycle values='vign-gridBody0Details,vign-gridBody1Details'}">
        	                                                <td width="20%">
                		                                	{$LIST_ESCOLAS_EDICAO[row].NOME}                		                                	
                                	            		 </td>
								{section name=nota loop=$NUM_JURADOS}
        	                                                <td>
                                                              		<input type="text" name="nota-{$LIST_ESCOLAS_EDICAO[row].ID_ESCOLA}-{$smarty.section.nota.index_next}" value="{$LIST_ESCOLAS_EDICAO[row].NOTAS[$smarty.section.nota.index_next].NOTA}" size="5" maxlength="4" class="vign-formElementControl" onkeypress="return infraMascaraNumeroSeparador(this,event,'.');" />
                		                               
                                	            		</td>
								{/section}
							</tr>
							{/section}
							<tr>
								<td colspan="{$NUM_JURADOS}">
									<img width="1" height="10" src="img/dotclear.gif"/>
								</td>
							</tr>
							<tr>
								<td nowrap="nowrap"></td>
								<td colspan="{$NUM_JURADOS}"> 
									<input type="submit" name="doOK" class="vign-formDialogButton"	value="Salvar">
								&nbsp&nbsp{$MSG}
								</td>
							</tr> 
						</table>

					</form>
				</td>
			</tr> 
			<tr>
				<td colspan="2">
					<img width="1" height="10" src="img/dotclear.gif"/>
				</td>
			</tr>
		</table>
	{/if}
	</td>
	

</tr>

{include file="footer.tpl"}
