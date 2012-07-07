//Global Vars
var disabledElementList;   //var that will be stored with a list of elements to disable
                           //for each jsp to handle if necessary.
                           //because the default function disableElements() does not
                           //handle disabling certain elements (i.e. span elements)
                           //correctly

var vign_popwin = null; //var used by Popwin and verifyWinLoaded().  This global var is
						//is needed because setTimeout() method only allows string
						//parameters.

//Purpose: Detects if the browser type is Netscape
//Returns: a boolean value whether the browser type is netscape.
function isNetscape() {
	if(document.getElementById && !document.all)
		return true;
	return false;
}


function sair(){
	var name = confirm("Você tem certeza?");
	if(name){
		$.ajax({
				type: "POST",
				url: "receber.php",
				data: {operacao:"sair"},
				success: function(msg){
				console.log(msg);
				$("#results_sair").html(msg);
			}
		});
	}
}

function excluir_servidor(idservidor1, servidor1){
	var name = confirm("Você tem certeza?");
	if(name){
		$.ajax({
				type: "POST",
				url: "receber.php",
				data: {operacao:"excluir_servidor", servidor:servidor1, id:idservidor1},
				success: function(msg){
				console.log(msg);
				$("#results_update").html(msg);
			}
		});
	}
}

function excluir_usuario(idusuario, nome){
	var name = confirm("Você tem certeza?");
	if(name){
		$.ajax({
				type: "POST",
				url: "receber.php",
				data: {operacao:"excluir_usuario", usuario:nome, id:idusuario},
				success: function(msg){
				console.log(msg);
				$("#results_update").html(msg);
			}
		});
	}
}

function excluir_empresa(idempresa, nome){
	var name = confirm("Você tem certeza?");
	if(name){
		$.ajax({
				type: "POST",
				url: "receber.php",
				data: {operacao:"excluir_empresa", usuario:nome, id:idempresa},
				success: function(msg){
				console.log(msg);
				$("#results_update").html(msg);
			}
		});
	}
}

function excluir_servico(id, nome){
	var name = confirm("Você tem certeza?");
	if(name){
		$.ajax({
				type: "POST",
				url: "receber.php",
				data: {operacao:"excluir_servico", id:id},
				success: function(msg){
				console.log(msg);
				$("#results_update").html(msg);
			}
		});
	}
}
function enviar_servidor(id, nome){
	var name = confirm("Você tem certeza?");
	if(name){
		$.ajax({
				type: "POST",
				url: "receber.php",
				data: {operacao:"enviar_servidor", id:id},
				success: function(msg){
				console.log(msg);
				$("#results_update").html(msg);
			}
		});
	}
}
function isIE() {
	 if (document.all)
	    return true;
	 return false;
}

function infraRTrim(String){
  while(String.charAt((String.length -1))==' '){
    String = String.substring(0,String.length-1);
  }
  return String;
}

function infraLTrim(String){
  while(String.charAt(0)==' '){
    String = String.replace(String.charAt(0),'');
  }
  return String;
}

function infraBrowserIE(){
  var agt=navigator.userAgent.toLowerCase();
  if (agt.indexOf('msie')!=-1){
    return true;
  }
  return false;
}

function infraTrim(String){
  String = infraLTrim(String);
  return infraRTrim(String);
}

function infraIsNumberPressed(objeto, evt){
  if (infraBrowserIE()){
    if (evt.keyCode < 48 || evt.keyCode > 57){
      return false
    }
  }else{
    if ((evt.charCode < 48 || evt.charCode > 57) && evt.keyCode == 0){
      return false
    }
  }
  return true;
}

function infraMascaraNumeroSeparador(objeto, evt, sep){
  if (infraBrowserIE()){
    if ((evt.keyCode < 48 || evt.keyCode > 57) && (objeto.value.indexOf(sep)!=-1 || String.fromCharCode(evt.keyCode)!=sep)){
      return false
    }
  } else {
    if ((evt.charCode < 48 || evt.charCode > 57) && (objeto.value.indexOf(sep)!=-1 || String.fromCharCode(evt.charCode)!=sep)&&evt.keyCode==0){
      return false
    }
  }
}

//Purpose: to open a pop up window.
//Params: context - context of url
//		  path - path of new window
//		  key - the active session key
//        target - name of the window
//        features - any features that a user wants to supply, if the user does not,
//                  calls function fSet to set default
//        width - width of window
//        height - height of window
//        modal - whether or not the resulting window is modal.  note, this is a boolean,
//               so the value false works, whereas "false" (in quotes) doesn't.
//        unique - whether or not a new browser window is opened when the same action is
//				performed multiple times.  if isUnique is true, a new browser is opened each time.
//				note, this is a boolean, so the value false works, whereas "false" (in quotes) doesn't.
//
//Returns: the window handle
function Popwin(context, path, key, target, features, width, height, modal, unique) {

//	var url = context + path;
//	return SimplePopwin(url, target, features, width, height, modal, unique);

	var ftrs;

	if (features == "") {
		ftrs = fSet(features);
	} else {
		ftrs = features;
	}

	var str = ftrs + ",height=" + height
 	str += ",width=" + width

	if (window.screen) {
		var sh = screen.availHeight - 30;
		var sw = screen.availWidth - 10;

		var txc = (sw - width) / 2;
		var tyc = (sh - height) / 2;

		str += ",left=" + txc + ",screenX=" + txc;
		str += ",top=" + tyc + ",screenY=" + tyc;
	}

	if (unique) {
		target = target + new Date().getTime();
	}

	// if path is empty, that probably means they're doing a form submit on the window
	// default to the transfer.jsp with ContextUtils.TRANSFER_MAKE_ACTIVE flag set to true
	var transfer = false;
	if ( isEmpty(path) || isBlank(path) ) {
		path = "/secure/common/session/transfer.jsp?makeActive=true";
		transfer = true;
	}

	// get the source context
	var srcContext = window.location.pathname;
	if ( isEmpty(srcContext) || isBlank(srcContext) || (srcContext.length < 2) ) {
		// default to app console if we can't find the context
		srcContext = "/AppConsole";
	} else {
		// find the first '/' past the context
		var index = srcContext.indexOf("/", 1);
		if ( index != -1 ) {
			srcContext = srcContext.substring(0, index);
		}
	}

	// Create a url to the dispatch hopper which includes the session key, destination context and path
	// Note the parameter VgnSessionKey must match VgnSessionMgr.VGN_SESSION_KEY
	var popwinUrl = srcContext + "/secure/common/session/dispatch.jsp?VgnSessionKey=" + escape(key) + "&context=" + escape(context) + "&path=" + escape(path);


	// Add session key to target
	var targetKey = createBrowserSafeName(target + "_" + key);




	if(modal && supportsShowModal() ) {
	    showModalDialog(popwinUrl,targetKey,str,width,height);
	} else {

		// By setting popwinUrl to win.location, we guarantee a repost even when a popup
		// window with the target name already exists.
		var win = window.open('',targetKey,str);
		win.location = popwinUrl;

	    // if we're doing a transfer then we need to allow the transfer.jsp to fully
	    // load. this is to allow session dispatching to work properly and avoid
	    // concurrent dispatches. we manage this by looking for the form that transfer.jsp
	    // will create to let us know its done. thx casey.

	   //Detecting if IE.  This while loop does not work in netscape.
	   //The fix in the else statement should work in IE as well, but do not
	   //have time to test the netscape soln in IE for this release.
	   //Should be used by both browsers in 7.1  Will enter vicket
	   if (isIE()) {
	        while ( transfer ) {
				if ( !win || win.closed || (win.document && win.document.forms[0]) ) {
		    	    transfer = false;
        	    }
			}
      	}  else {
      	    vign_popwin = win;
      	    verifyWinLoaded();
      	    vign_popwin = null;
      	}
        return win;
    }
}

//Purpose:  If we're doing a transfer then we need to allow the transfer.jsp to fully
//          load. this is to allow session dispatching to work properly and avoid
//          concurrent dispatches. we manage this by looking for the form that transfer.jsp
//          will create to let us know its done.  Uses global var vign_popwin, since setTimeout
//          only allows passing strings as its parameter
//
//TODO:     Right now only being called in the Netscape case. We should use this approach
//          for IE as well in 7.1; See Popwin function.
//
//Returns:  Just returns out of the function once vign_popwin has been fully loaded.
function verifyWinLoaded() {
	//If the user closed the window at this point, just return
    if (!vign_popwin || vign_popwin.closed) {
        return;
    }
    //Because the dispatch.jsp sometimes will take a while to load to do its
    //session magic, must determine that window.document.forms[0] in transfer.jsp
    //has been loaded before performing any other actions
    if (vign_popwin && !vign_popwin.closed) {
        if (vign_popwin.document) {
            if (vign_popwin.document.forms[0]) {
                return;
            }
        }
    }

    setTimeout('verifyWinLoaded()', 100);
}

function SimplePopwin(theUrl, winName, features, width, height, isModal, isUnique) {
	var ftrs;
	if (features == "") {
		ftrs = fSet(features);
	} else {
		ftrs = features;
	}

	// escape the windowName in case it has any nonAlphaNumeric or non-underscore
	// characters
	winName = createBrowserSafeName(winName);

	var str = ftrs + ",height=" + height + ",innerHeight=" + height;
	str += ",width=" + width + ",innerWidth=" + width;

	if (window.screen) {
		var sh = screen.availHeight - 30;
		var sw = screen.availWidth - 10;

		var txc = (sw - width) / 2;
		var tyc = (sh - height) / 2;

		str += ",left=" + txc + ",screenX=" + txc;
		str += ",top=" + tyc + ",screenY=" + tyc;
	}

	if(isModal && supportsShowModal() ) {
	    showModalDialog(theUrl,winName,str,width,height);
	} else {
		if (isUnique) {
			winName = winName + new Date().getTime();
		}

	    return window.open(theUrl, winName, str);
	}
}

function supportsShowModal() {

    var name = navigator.appName;
    var version = navigator.appVersion.substring(0,navigator.appVersion.indexOf("."));
    if( name == "Microsoft Internet Explorer" && parseInt(version) >= 4 ) {
       return true;

    } else {
       return false;
    }
}

//Purpose: Returns a string that wraps the form with the appropriate html and body
//         tags.
//Params: form - A string that is a well-structured html form
//Returns: a well structured string representation of an html document
function getHtmlDoc (form) {
	return "<html><body>" + form + "</body></html>";
}

//Purpose:  Returns a string that is an html form used to submit data to the hierarchy browser.
//Params:   contextPath - required; the portion of the request's uri that denotes the context of the request.
//          service- required; the name of the service provider
//          title- the title of the hierarchy browser
//          rootPath- the beginning of the tree in the hierarchy browser
//          logicalPath- path beyond the root path
//          multiselect- whether the browser has multiple selections
//          formBeanId- id of the form bean in the session to populate.
//          formBeanClass- class of the form bean in the session.
//          formBeanProperty- name of the form bean's property to populate with the selected id(s)
//          formAction- an alternate action that the hierarchybrowser will submit to.
//                      If the not specified, when a user selects OK, the hierarchybrowser
//                      will post to hierarchyBrowserClose.jsp
//          formObj - required if you want your form to retain dirty parameters. (If a user
//                    has changed any elements in the form, then need to add
//                    as parameters to the request.)
//          requestParamName - attribute name of the request parameter object optionally set in the list view.
//          refreshCmd - cmd to pass to the the window.opener.submitCmd(cmd) javascript method, if null will do
//                       normal window.opener.location.reload()
//          linkAssets - whether the leaf assets should be links.
//          displayAssets- whether leaf assets should be displayed
//          enableContainerSelectors- whether to allow the user to select container assets
//          enableAssetSelectors- whether to allow the user to select leaf assets.
//          displayPath- whether the list selectable drop-down path should be displayed at the top
//                       of the list view
//          listTitle- a sting representation of the list title for this instance of the tag
//
//Notes: -If the contextPath and service params are not provided, the function will
//        alert the user, and return back to the caller.
//
function getHierarchyBrowserForm (formName, hbFormAction, contextPath, sessionKey, service, title, rootPath, logicalPath, multiselect, formBeanId, formBeanClass, formBeanProperty, formAction, formObj, requestParamName, refreshCmd, linkAssets, displayAssets, enableContainerSelectors, enableAssetSelectors, displayPath, listTitle) {

    if (isEmpty(contextPath) || isBlank(contextPath)) {
        alert("Please provide a context path.");
        return;
    }

    if (isEmpty(service) || isBlank(service)) {
        alert("Please provide a service provider.");
        return;
    }

    var form = "<form name='"+formName+"' method='post' action='"+contextPath+hbFormAction+"'>";
    var begField = "<input type='hidden' name='";
    var valueField = "' value='";
    var endField = "' >";

    form = form + begField + "spfSPId" + valueField + service + endField;

    if (!isEmpty(title) && !isBlank(title)) {
        form = form + begField + "hb_title" + valueField + title + endField;
    }

    //Determine if have a root path
    //so will be placed on the url correctly.
    if (!isEmpty(rootPath) && !isBlank(rootPath)) {
        form = form + begField + "spfRP" + valueField + rootPath + endField;
    }

    //Determine if have a logical path
    //so will be placed on the url correctly.
    if (!isEmpty(logicalPath) && !isBlank(logicalPath)) {
        form = form + begField + "spfLP" + valueField + logicalPath + endField;
    }

    if (!isEmpty(multiselect) && !isBlank(multiselect)) {
        form = form + begField + "multiselect" + valueField + multiselect + endField;
    }

    if (!isEmpty(formBeanId) && !isBlank(formBeanId)) {
        form = form + begField + "hb_formBeanId" + valueField + formBeanId + endField;
    }

    if (!isEmpty(formBeanClass) && !isBlank(formBeanClass)) {
        form = form + begField + "hb_formBeanClass" + valueField + formBeanClass + endField;
    }

    if (!isEmpty(formBeanProperty) && !isBlank(formBeanProperty)) {
        form = form + begField + "hb_formBeanProperty" + valueField + formBeanProperty + endField;
    }

    if (!isEmpty(formAction) && !isBlank(formAction)) {
        form = form + begField + "hb_formAction" + valueField + formAction + endField;
    }

    if (!isEmpty(requestParamName) && !isBlank(requestParamName)) {
        form = form + begField + "hb_requestParamName" + valueField + requestParamName + endField;
    }

    if (!isEmpty(refreshCmd) && !isBlank(refreshCmd)) {
        form = form + begField + "hb_refreshCmd" + valueField + refreshCmd + endField;
    }

    if (!isEmpty(linkAssets) && !isBlank(linkAssets)) {
        form = form + begField + "hb_linkAssets" + valueField + linkAssets + endField;
    }

    if (!isEmpty(displayAssets) && !isBlank(displayAssets)) {
        form = form + begField + "hb_displayAssets" + valueField + displayAssets + endField;
    }

    if (!isEmpty(enableContainerSelectors) && !isBlank(enableContainerSelectors)) {
        form = form + begField + "hb_enableContainerSelectors" + valueField + enableContainerSelectors + endField;
    }

    if (!isEmpty(enableAssetSelectors) && !isBlank(enableAssetSelectors)) {
        form = form + begField + "hb_enableAssetSelectors" + valueField + enableAssetSelectors + endField;
    }

    if (!isEmpty(displayPath) && !isBlank(displayPath)) {
        form = form + begField + "hb_displayPath" + valueField + displayPath + endField;
    }

    if (!isEmpty(listTitle) && !isBlank(listTitle)) {
        form = form + begField + "hb_listTitle" + valueField + listTitle + endField;
    }

    if (!isEmpty(sessionKey) && !isBlank(sessionKey)) {
        form = form + begField + "VgnSessionKey" + valueField + sessionKey + endField;
    }

	// finally add context path
    form = form + begField + "hb_contextPath" + valueField + contextPath + endField;

    //Determine if user has passed a formObj
    if (formObj != null) {
        var elementList = formObj.elements;
        if (elementList.length != null && elementList.length > 0) {
            var hasChanged = false;

            for (i=0;i<elementList.length;i++) {
                //If disabled dont remember dirty value.
                if (elementList.disabled == false) {
                    hasChanged = isFrmElementDirty(elementList[i]);
                    if (hasChanged && elementList[i].name != 'undefined' && !isEmpty(elementList[i].name) && !isBlank(elementList[i].name)) {
                        form = form + begField + "hb_dirtyParam_" + elementList[i].name + valueField + elementList[i].value + endField;
                    }
                }
            }  //end of for loop
        } //end of if
    } // end of if
    form = form + "</form>";

    return form;

}

//Purpose:  Opens the search hierarchy browser and sets certain params on the request that
//          the browser may need.
//Params:   contextPath - required; the portion of the request's uri that denotes the context of the request.
//			sessionKey - required; the active session key.
//          service- required; the name of the service provider
//          title- the title of the hierarchy browser
//          rootPath- the beginning of the tree in the hierarchy browser
//          logicalPath- path beyond the root path
//          multiselect- whether the browser has multiple selections
//          formBeanId- id of the form bean in the session to populate.
//          formBeanClass- class of the form bean in the session.
//          formBeanProperty- name of the form bean's property to populate with the selected id(s)
//          formAction- an alternate action that the hierarchybrowser will submit to.
//                      If the not specified, when a user selects OK, the hierarchybrowser
//                      will post to hierarchyBrowserClose.jsp
//          formObj - required if you want your form to retain dirty parameters. (If a user
//                    has changed any elements in the form, then need to add
//                    as parameters to the request.)
//          requestParamName - attribute name of the request parameter object optionally set in the list view.
//          refreshCmd - cmd to pass to the the window.opener.submitCmd(cmd) javascript method, if null will do
//                       normal window.opener.location.reload()
//          linkAssets - whether the leaf assets should be links.
//          displayAssets- whether leaf assets should be displayed
//          enableContainerSelectors- whether to allow the user to select container assets
//          enableAssetSelectors- whether to allow the user to select leaf assets.
//          displayPath- whether the list selectable drop-down path should be displayed at the top
//                       of the list view
//          listTitle- a sting representation of the list title for this instance of the tag
//
//Notes: -If the contextPath and service params are not provided, the function will
//        alert the user, and return back to the caller.
//
function openSearchBrowser(contextPath, sessionKey, service, title, rootPath, logicalPath, multiselect, formBeanId, formBeanClass, formBeanProperty, formAction, formObj, requestParamName, refreshCmd, linkAssets, displayAssets, enableContainerSelectors, enableAssetSelectors, displayPath, listTitle) {

    var form = getHierarchyBrowserForm("searchBrowserForm", "/secure/common/searchBrowser.jsp", contextPath, sessionKey, service, title, rootPath, logicalPath, multiselect, formBeanId, formBeanClass, formBeanProperty, formAction, formObj, requestParamName, refreshCmd, linkAssets, displayAssets, enableContainerSelectors, enableAssetSelectors, displayPath, listTitle);
    var win = Popwin(contextPath, '', sessionKey, 'searchBrowser', '', '700', '600');

    win.document.write(getHtmlDoc(form));
    win.document.forms[0].submit();

}

//Purpose:  Opens the hierarchy browser and sets certain params on the request that
//          the browser may need.
//Params:   contextPath - required; the portion of the request's uri that denotes the context of the request.
//			sessionKey - required; the active session key.
//          service- required; the name of the service provider
//          title- the title of the hierarchy browser
//          rootPath- the beginning of the tree in the hierarchy browser
//          logicalPath- path beyond the root path
//          multiselect- whether the browser has multiple selections
//          formBeanId- id of the form bean in the session to populate.
//          formBeanClass- class of the form bean in the session.
//          formBeanProperty- name of the form bean's property to populate with the selected id(s)
//          formAction- an alternate action that the hierarchybrowser will submit to.
//                      If the not specified, when a user selects OK, the hierarchybrowser
//                      will post to hierarchyBrowserClose.jsp
//          formObj - required if you want your form to retain dirty parameters. (If a user
//                    has changed any elements in the form, then need to add
//                    as parameters to the request.)
//          requestParamName - attribute name of the request parameter object optionally set in the list view.
//          refreshCmd - cmd to pass to the the window.opener.submitCmd(cmd) javascript method, if null will do
//                       normal window.opener.location.reload()
//          linkAssets - whether the leaf assets should be links.
//          displayAssets- whether leaf assets should be displayed
//          enableContainerSelectors- whether to allow the user to select container assets
//          enableAssetSelectors- whether to allow the user to select leaf assets.
//          displayPath- whether the list selectable drop-down path should be displayed at the top
//                       of the list view
//          listTitle- a sting representation of the list title for this instance of the tag
//
//Notes: -If the contextPath and service params are not provided, the function will
//        alert the user, and return back to the caller.
//
//See: hierarchyBrowser.jsp, hierarchyBrowserClose.jsp for further information.
function openHierarchyBrowser(contextPath, sessionKey, service, title, rootPath, logicalPath, multiselect, formBeanId, formBeanClass, formBeanProperty, formAction, formObj, requestParamName, refreshCmd, linkAssets, displayAssets, enableContainerSelectors, enableAssetSelectors, displayPath, listTitle) {

    var form = getHierarchyBrowserForm("hb_form", "/secure/common/hierarchyBrowser.jsp", contextPath, sessionKey, service, title, rootPath, logicalPath, multiselect, formBeanId, formBeanClass, formBeanProperty, formAction, formObj, requestParamName, refreshCmd, linkAssets, displayAssets, enableContainerSelectors, enableAssetSelectors, displayPath, listTitle);
    var win = Popwin(contextPath, '', sessionKey, 'hBrowser', '', '600', '600');

    win.document.write(getHtmlDoc(form));
    win.document.forms[0].submit();
}

//Purpose:  Opens the hierarchy browser and sets certain params on the request that
//          the browser may need. This is a simplified veneer over the openHierarchyBrowser function.
//			Defaults are provided for most of the parameters such that the displayed hiearchy browser
//			behaves as a simple asset picker.
//Params:   contextPath - required; the portion of the request's uri that denotes the context of the request.
//			sessionKey - required; the active session key.
//          service- required; the name of the service provider
//          title- the title of the hierarchy browser
//          rootPath- the beginning of the tree in the hierarchy browser
//          formBeanId- id of the form bean in the session to populate.
//          requestParamName - attribute name of the request parameter object optionally set in the list view.
//
//Notes: -If the contextPath and service params are not provided, the function will
//        alert the user, and return back to the caller.
//
//See: hierarchyBrowser.jsp, hierarchyBrowserClose.jsp for further information.
function showHierarchyBrowser(contextPath, sessionKey, service, title, rootPath, formBeanId, requestParamName) {
	openHierarchyBrowser(contextPath, sessionKey, service, title, rootPath, "/", 'false', formBeanId, "com.vignette.as.ui.common.widgets.HierarchyBrowserResult", "singleSelectValue", null, self.document.forms[0], requestParamName, "refresh", 'false', 'true', 'false', 'true', 'true', "");
}

//Purpose: To open the property pages for a content item.  If the user supplies
//         an empty contentID, the function will return false.
//Params: sessionKey - the unique session identifier
//        contentID - the content management id
//        checkDirtyOnParent - boolean value indicating whether to check
//          if any changes were made to the invoking window before it is refreshed.
//          (ie , if the subform peforms an OK or APPLY)
function openCMAViewer(sessionKey, contentID, checkDirtyOnParent) {
	if (isEmpty(contentID) && isBlank(contentID))
		return false;

    var cmaViewerURI =  '/secure/cmaViewer.do?spfAId='+contentID+'&propertiesClose=true';
    //Do we want the subform to check if parent window's fields are dirty upon submit.
    if (checkDirtyOnParent)
        cmaViewerURI = cmaViewerURI + '&checkDirtyOnParent='+checkDirtyOnParent;

	var win = Popwin('/AppConsole', cmaViewerURI, sessionKey, 'cmaBrowser', '', '700', '500');

	return true;
}

// Purpose: disables form elements
// Params: theForm- the form object (i.e. document.forms[0])
//         elementList - javascript Array object that consists of the names or indices of the elements to disable.
//
// Notes: If the element does not exist in the form, nothing is done.
function disableElements(theForm, elementList) {
    if (elementList == null || elementList == 'undefined' || theForm == null || theForm == 'undefined')
        return;
   	for (i=0; i < elementList.length; i++) {
        var elementToDisable = theForm.elements[elementList[i]];
        if (elementToDisable != null && elementToDisable != 'undefined')
            elementToDisable.disabled = true;
    }
    disabledElementList = elementList;
}

// Purpose: enables form elements
// Params: theForm- the form object (i.e. document.forms[0])
//         elementList - javascript Array object that consists of the names or indices of the elements to enable.
//
// Notes: If the element does not exist in the form, nothing is done.
function enableElements(theForm, elementList) {
    if (elementList == null || elementList == 'undefined' || theForm == null || theForm == 'undefined')
        return;
   	for (i=0; i < elementList.length; i++) {
        var elementToEnable = theForm.elements[elementList[i]];
        if (elementToEnable != null && elementToEnable != 'undefined')
            elementToEnable.disabled = false;
    }
}

// Purpose: determines if the string is empty. A blank string is anything containing only whitespaces, newlines, tabs, form feeds, and/or line feeds.
// Params: s- the string to test
//
// Notes: If the element does not exist in the form, nothing is done.
// Returns: a boolean value whether the string is blank or not.
function isBlank(s) {
    //set up the regular expression to test if the string contains whitespaces, newlines, tabs, form feeds or line feeds.
    var re = /^\s+$/;
    if (re.test(s))
        return true;
    return false;
}

//Determines if a string is null or empty.
function isEmpty(s) {
    return ((s == null) || (s == ""));
}

//Purpose: returns a string that has escaped forward slashes (to %2F);
//Param: s- the string to escape
//ReturnS: a string where all forward slashes are replaced with %2f
function escapeForwardSlash(s) {
    var re = /\/+/g;
    if (s != null) {
        s = s.replace(re, "%2F");
    }
    return s;
}

//Purpose: To check if an html radio or checkbox form element
//         is dirty.
//Params: select - an html select form element.
//Returns: a boolean value whether a checkbox or radio form element is dirty.
function checkRadioOrCheckbox( radio )
{
  return (radio.checked!=radio.defaultChecked)
}

//Purpose: To check if an html select form element
//         is dirty
//Params: select - an html select form element.
//Returns: a boolean value whether a select form element is dirty.
function checkSelect( select )
{
  var children=select.options
  for(var i=0;i!=children.length;i++)
  {
    if(children[i].selected != children[i].defaultSelected)
    {
      return true;
    }
  }
  return false;
}

//Purpose: To check if form element is dirty.
//Params: element- a form element that can have a "defaultValue" property
//Returns: a boolean value whether a form element is dirty.
function checkDefaultValue( element )
{
  return (element.defaultValue!=element.value)
}

//Purpose: To determine if a form element is dirty.  This method handles
//         text, password, textarea, file, reset, hidden, select (select-one or select-multiple),
//         checkbox, and radio form elements.  If the form element is passed in that
//         is not of one of the types listed above, returns false.
//Params:  element- a form element
//Returns: a boolean value whether a form element is dirty.
function isFrmElementDirty( element) {

    switch( element.type )
            {
                case "text":
                case "password":
                case "textarea":
                case "file":
                case "reset":
                case "hidden":
                return checkDefaultValue( element )
                break;

              case "select-one":
              case "select-multiple":
                 return checkSelect( element )
                 break;

              case "submit":
              case "button":
                 break

              case "checkbox":
              case "radio":
                 return checkRadioOrCheckbox( element )
                 break;

              default: return false;
            }
}


function PopHelp() {
   SimplePopwin('/help', 'newHelpWindow', 'location=no,menubar=yes,resizable=yes,scrollbars=yes,status=no,toolbar=yes', '700', '500');
   return false;
}

// removes all non-alphanumeric characters
// except underscore from the input value
function createBrowserSafeName(inputVal) {

    newString = "";

    for (i = 0; i < inputVal.length; i++) {
        ch = inputVal.substring(i, i+1);

        if ((ch >= "a" && ch <= "z") || (ch >= "A" && ch <= "Z") ||
            (ch >= "0" && ch <= "9") || ch == "_")  {
            newString += ch;
        }
    }

    // if the name is empty at this point, we may be dealing with a localized
    // set of characters in which case we default the name to something generic and single-byte
    if (newString == "") {
    	newString = "defaultVCMWindow";
    }

    return newString;
}

// get actual browser window position
function getLeft(oObject) {
	return (oObject.x) ? oObject.x : getPosition(oObject,"Left");
}

function getTop(oObject) {
	return (oObject.y) ? oObject.y : getPosition(oObject,"Top");
}

function getPosition(oObject,xyString) {
	inc = 0;
	var embeddedFlag = oObject.embedded;
	while (oObject != null) {
		if (isIE()) {
			if ((oObject.currentStyle.position == "absolute") &&  embeddedFlag) {
			   return inc;
			}
		}
		if (isNetscape()) {
			if (document.defaultView.getComputedStyle(oObject, null).getPropertyValue("position") == "absolute") {
			   return inc;
			}
		}
		inc = inc + oObject["offset" + xyString];
		oObject = oObject.offsetParent;
	}
	return inc;
}

/* Inserir lines dinamicamente nas respostas das enquetes */
var contador_enquetes = 0;
/* deletar dinamicas as lines das respostas das enquetes */
function deleteRow(r){
    	 /*if ( document.myForm.optionCounter.value == 1 ) {
				return false;
    	 }*/
		 var i=r.parentNode.parentNode.rowIndex;
         document.getElementById('table_controls_channels').deleteRow(i);
        /* if ( document.myForm.optionCounter.value != '' ) {
         	  document.myForm.optionCounter.value -= 1;
         	  }else{
			   document.myForm.optionCounter.value = 0;
         }*/
         //contador_enquetes--; 
}
/* fim */


var mainTable = document.getElementById('table_controls_respostas');
function swapRowUp(chosenRow){
		  if (chosenRow.rowIndex != 0) {
				moveRow(chosenRow, chosenRow.rowIndex-1);
		  }
}

function swapRowDown(chosenRow) {                                                
		 var mainTable = document.getElementById('table_controls_respostas');
		 if (chosenRow.rowIndex != mainTable.rows.length-1) {                           
			   moveRow(chosenRow, chosenRow.rowIndex+1); 
		 }                                                                              
}                                                                                

//moves the target row object to the input row index
function moveRow(targetRow, newIndex) { 
		 //since we are not actually swapping
		 //but simulating a swap, have to "skip over"
		 //the current index
		 if (newIndex > targetRow.rowIndex) {
		   newIndex++;
		 }
		
		 //establish proper reference to the table
		 var mainTable = document.getElementById('table_controls_respostas');
		
		 //insert a new row at the new row index
		 var theCopiedRow = mainTable.insertRow(newIndex);
		
		 //copy all the cells from the row to move
		 //into the new row
		 for (var i=0; i<targetRow.cells.length; i++) {
			   var oldCell = targetRow.cells[i];
			   var newCell = document.createElement("TD");
			   newCell.innerHTML = oldCell.innerHTML;
			   theCopiedRow.appendChild(newCell);
		 }
		
		 //delete the old row
		 mainTable.deleteRow(targetRow.rowIndex); 
}

function movimento(elemento, direcao) {
		var sel = document.getElementById(elemento);
		var len, i;
		if (!sel) {
			return;
		}
		if (direcao == 'passar' && arguments[2] == undefined) {
			return;
		} else if (direcao == 'passar') {
			var sel_pai = document.getElementById(arguments[2]);
			var selecionados = new Array();
			if (!sel_pai) {
				return;
			}
			len = sel_pai.options.length;
			for (i = 0; i < len; i++) {
				if (sel_pai.options[i].selected) {
					sel.options[sel.options.length] = new Option(sel_pai.options[i].text, sel_pai.options[i].value);
					selecionados.push(i);
				}
			}
			len = selecionados.length;
			for (i = len-1; i >= 0; i--) {
				sel_pai.options[selecionados[i]] = null;
			}
		} else if (direcao == 'cima' || direcao == 'baixo') {
			var selecionado = sel.selectedIndex;
			var comparacao = direcao == 'cima' ? selecionado - 1 : selecionado;
			var opts_values = new Array();
			var opts_texts = new Array();
			var tam = sel.options.length;
			var i;
			if (selecionado == -1) {
				return;
			}
			if (direcao == 'cima' && selecionado == 0) {
				return;
			}
			if (direcao == 'baixo' && selecionado == tam - 1) {
				return;
			}
			selecionado = direcao == 'cima' ? selecionado - 1 : selecionado + 1;
			for (i = 0; i < sel.options.length; i++) {
				if (i == comparacao) {
					opts_values.push(sel.options[i+1].value);
					opts_texts.push(sel.options[i+1].text);
					sel.options[i + 1] = null;
				}
				opts_values.push(sel.options[i].value);
				opts_texts.push(sel.options[i].text);
			}
			for (i = 0; i < tam; i++) {
				sel.options[i] = new Option(opts_texts[i], opts_values[i]);
			}
			sel.selectedIndex = selecionado;
		}
}

/* fim */

function countryExists( countries, country ){
		 var countryIndex="";
		 var x;
		 for ( x=0; x<countries.length; x++ ) {
			  if ( countries[x].indexOf(country) != -1 ){
				   countryIndex=x;
				   break;
			  }
		 }
		 return countryIndex.toString();
}

function productExists( products, product ){
		 var productIndex="";
		 if ( products.indexOf(product) != -1 ){
			  productIndex=1;
		 }
		 return productIndex.toString();
}

/* deletar dinamicamente os filtros dos produtos das enquetes */
function deleteRowFilters(r){
		 var i=r.parentNode.parentNode.rowIndex;
		 hashCountry="";
		 hashProducts="";
         document.getElementById(tableName).deleteRow(i);
		 availableSelected.splice(i,1);
		 fixLineStyles(tableName);
		 if ( document.myForm.filterCounter.value != '' ) {
		 	  document.myForm.filterCounter.value -= 1;
		 	  }else{
		 	   document.myForm.filterCounter.value = 0;
		 }
		 filterCounter--;
}
/* fim */

/* deletar dinamicamente os filtros dos produtos das enquetes recebendo o rowIndex da linha */
function deleteRowFiltersByIndex(r){
		 var i=r;
		 hashCountry="";
		 hashProducts="";
         document.getElementById(tableName).deleteRow(i);
		 availableSelected.splice(i,1);
		 fixLineStyles(tableName);
}
/* fim */

function fixLineStyles(id) {
		 var table = document.getElementById(id);   
	     var rows = table.getElementsByTagName("tr");   
		 var i;
	     for( i=0; i<rows.length; i++ ){           
			  if( (i%2) == 0 ){ 
				   rows[i].className = "even"; 
				   }else{ 
				    rows[i].className = "odd"; 
			  }       
		 }
}

function updateExpirationDate() {
		 var actualDay 		= document.myForm.day[document.myForm.day.selectedIndex].value;
		 var actualMonth 	= document.myForm.month[document.myForm.month.selectedIndex].value;
		 var actualYear 	= document.myForm.year[document.myForm.year.selectedIndex].value;
		 var actualHour 	= document.myForm.hour[document.myForm.hour.selectedIndex].value;
		 var actualMinute 	= document.myForm.minute[document.myForm.minute.selectedIndex].value;
		 document.myForm.dateExpireString.value = actualDay + "/" + actualMonth + "/" + actualYear + " " + actualHour + ":" + actualMinute; 
}

function updateExpirationDateFilter() {
		 var ieDay 		= document.myForm.ieday[document.myForm.ieday.selectedIndex].value;
		 var ieMonth 	= document.myForm.iemonth[document.myForm.iemonth.selectedIndex].value;
		 var ieYear 	= document.myForm.ieyear[document.myForm.ieyear.selectedIndex].value;
		 var feDay 		= document.myForm.feday[document.myForm.feday.selectedIndex].value;
		 var feMonth 	= document.myForm.femonth[document.myForm.femonth.selectedIndex].value;
		 var feYear 	= document.myForm.feyear[document.myForm.feyear.selectedIndex].value;
		 document.myForm.initialDateExpiryFilter.value = ieDay + "/" + ieMonth + "/" + ieYear; 
		 document.myForm.finalDateExpiryFilter.value = feDay + "/" + feMonth + "/" + feYear;
}

function updateCreationDateFilter() {
		 var icDay 		= document.myForm.icday[document.myForm.icday.selectedIndex].value;
		 var icMonth 	= document.myForm.icmonth[document.myForm.icmonth.selectedIndex].value;
		 var icYear 	= document.myForm.icyear[document.myForm.icyear.selectedIndex].value;
		 var fcDay 		= document.myForm.fcday[document.myForm.fcday.selectedIndex].value;
		 var fcMonth 	= document.myForm.fcmonth[document.myForm.fcmonth.selectedIndex].value;
		 var fcYear 	= document.myForm.fcyear[document.myForm.fcyear.selectedIndex].value;
		 document.myForm.initialDateCreateFilter.value = icDay + "/" + icMonth + "/" + icYear; 
		 document.myForm.finalDateCreateFilter.value = fcDay + "/" + fcMonth + "/" + fcYear;
}

function updateTypeDateFilter() {
		 for ( var i=0; i<document.myForm.typeDateFilterRadio.length; i++ ) {
		 		if ( document.myForm.typeDateFilterRadio[i].checked ) {
		 			 document.myForm.typeDateFilter.value = document.myForm.typeDateFilterRadio[i].value;
				 }
		 } 
}

function toggleRoleActionDiv(object){
        if (!document.getElementById)
            return
        if (object.style.display=="none")
            object.style.display=""
        else
            object.style.display="none"
}

function isNumber(e){
	    var t = (window.event) ? event.keyCode:e.which;	    
	    if((t > 47 && t < 58)) 
	    	return true;
	    else{
	    	if ( t != 8 && t != 0 ) 
	    		return false;
	    	else 
	    		return true;
	    }
}

function actAndSubmit( myform, act ) {
		eval('document.'+myform+'.act.value=\''+act+'\'');
		eval('document.'+myform+'.submit()');
}

function inverseCheck(field) {
		 if ( typeof(field.length) != "undefined"  ) {	
		 	for ( i = 0; i < field.length; i++ ) {
					if ( field[i].checked == false ) {
					 	field[i].checked = true;
					 	}else{
						  field[i].checked = false;
					}
	 	 	}
	 	 }else{
			if ( field.checked == false ) {
			 	field.checked = true;
			 	}else{
				  field.checked = false;
			}	 	 
	 	 }
	 	 
}

function vgnHomeActionsLink(url) {
	location = url;
}

function setFilter ( field, value, flag ) {
	     var actualField = field; 
	     var actualValue = value;
	     var actualFlag  = flag;
	     for ( i=0; i<actualField.length; i++ ) {
	     	   if ( actualFlag ) {
				   if ( actualField[i].value == actualValue ) {
						actualField[i].selected = actualFlag;
				   }
				   }else{
					actualField[i].selected = actualFlag;
			   }
		 }
}

function selectSurveyListSelected() {
	     for ( i=0; i<document.myForm.surveyListSelected.options.length; i++ ) {
				document.myForm.surveyListSelected.options[i].selected = true;
		 }
}


function setClone(type){
		if (type != "") {
			document.myForm.act.value = type;
		}
}

function clearSurveyForm(id){
		if ( id == "null" ) {
			var table = document.getElementById("table_controls_filters");   
		    var rows = table.getElementsByTagName("tr");   
			var i;
			if ( rows > 0 ) {
			    for( i=0; i<=rows.length; i++ ){
					 deleteRowFiltersByIndex(0);       
				}
			}
			}else{
			this.location.reload();
		}
		return true;
}
function windowOpenElement(t,i,ic){
	var page = "editElement.jsp?type="+t+"&index=" + i.rowIndex +"&indexc=" + ic ;
	var msg = open(page,"QST","width=500,height=300,scrollbars=no,resizable=no,toolbar=no,directories=no,menubar=no");
	
}
function windowOpen(type,ret){
	var page;
	if ( type == 1 ){
		page = "editSource.jsp";
	}else{
		page = "editSignature.jsp";
	}
	page += "?ret=" + ret ;
	var msg = open(page,"QST","width=500,height=150,scrollbars=no,resizable=no,toolbar=no,directories=no,menubar=no");
}
