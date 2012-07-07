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
						<input type="hidden" name="act" value="{$AACT[0]}.{$AACT[1]}" />
						<input type="hidden" name="add" value="1" />
						<input type="hidden" name="list" value="1" />
						<tr>
							<td colspan="2" class="toptd">
						                <div class="vign-dialogTabDiv">
							                    <ul class="vign-tabList">
					        		                <li id="search-li" class="vign-onItem">Apurações | </li>
					                        		<li id="projects-li">Punição</li>
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

                                                        {if $AACT[2] eq 'upd'}
                                                                <input type="hidden" name="edicoes_id" size="10" readonly value="{$EDICAO.ID_EDICAO}" class="vign-formElementControl" />
                                                                <input type="text" name="edicao_nome" size="10" readonly value="{$EDICAO.ESTADO} - {$EDICAO.ANO}" class="vign-formElementControl" />
                                                        {else}
                                                                <select name=edicoes_id onchange="submit();">
                                                                        {html_options values=$edicoes_ids selected=$edicoes_id output=$edicoes_names}
                                                                </select>
                                                        {/if}
                                                        </td>
                                                </tr>
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
						{/if}
					
						<table width="100%">
	                                                <tr>
								<td></td>
        	                                                <td class="vign-gridBody1Details">
                		                                	Punição
                                	            		 </td>
							</tr>
							{section name=row loop=$LIST_ESCOLAS_EDICAO}
	                                                <tr>
        	                                                <td class="{$CLASS_CSS[row]}" width="20%">
                		                                	{$LIST_ESCOLAS_EDICAO[row].NOME}
                                	            		 </td>
        	                                                <td class="{$CLASS_CSS[row]}">
                                                              		<input type="text" name="desconto-{$LIST_ESCOLAS_EDICAO[row].ID_ESCOLA}" value="{$LIST_ESCOLAS_EDICAO[row].DESCONTO}" size="5" maxlength="5" class="vign-formElementControl" onkeypress="return infraMascaraNumeroSeparador(this,event,'.');"/>
                		                               
                                	            		</td>
							</tr>
							{/section}
							<tr>
								<td nowrap="nowrap"></td>
								<td >
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
