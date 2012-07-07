function validateAlphanumeric(inputVal) {
    for (i = 0; i < inputVal.length; i++) {
        ch = inputVal.substring(i, i+1);
        if (!(ch >= "a" && ch <= "z") && !(ch >= "A" && ch <= "Z") &&
        	!(ch >= "0" && ch <= "9")) {
            return false;
        }
    }
    return true;
}

function validateNumeric(inputVal) {
    for (i = 0; i < inputVal.length; i++) {
        ch = inputVal.substring(i, i+1);
        if (ch <= "0" && ch >= "9") {
            return false;
        }
    }
    return true;
}

function validateRange(inputVal, totalPages) {
	if (parseInt(inputVal) >= 1 && parseInt(inputVal) <= totalPages) {
		return true;
	}
    return false;
}

function queryPopwin(formObj, sessionKey) {
    win = Popwin('', '', sessionKey, 'searchResults', 'location=no,menubar=yes,resizable=yes,scrollbars=yes,status=yes,toolbar=no','900', '700', false, true);
    formObj.target = win.name;
    formObj.submit();
}

function removeSpecialCharacters(inputVal) {

    newString = "";

    for (i = 0; i < inputVal.length; i++) {
        ch = inputVal.substring(i, i+1);

        if ((ch >= "a" && ch <= "z") || (ch >= "A" && ch <= "Z") ||
            (ch >= "0" && ch <= "9")) {
            newString += ch;
        }
    }
    return newString;
}

///vignListControl_object.prototype.doAction = function( sActionId, sessionKey ) {
	// figure out which item if any is selected and store its assetButtonMap array
	// if nothing is selected, the container buttons array is loaded
///	var assetRef = null;
	// doAction is called from the toolbar object: the 'this'
///	var thisList = this.listViewRef;
	///formObj = thisList.formObject;

///	if (thisList.selectedAssetList) {
		// catches null list
///		if (thisList.selectedAssetList.objRef.actionMap[sActionId]) {
			// if there's a node for a selection, it is assumed to be an asset action //
			///assetRef = thisList.selectedAssetList.objRef;
///		} else {
			// it's a container action
			///assetRef = thisList.containerAsset;
///		}
	///} else {
		///assetRef = thisList.containerAsset;
///	}

///	actionMapNode = assetRef.actionMap[sActionId];
	///if (!actionMapNode) // unless we made a mistake...
		///alert('RenderTag: doAction - cannot get container or asset action.');

///	var confirmationMessage = actionMapNode.confirmationMessage;
///	var showConfirmation = actionMapNode.showConfirmation;
///	var frmAction = actionMapNode.actionURL;

///	if (!showConfirmation || confirm(confirmationMessage)) {
		// if we want to show a confirmation, but the message is blank, throw an alert and don't execute
		///if (showConfirmation && confirmationMessage == "") {
			///alert(ERR_JS_INVALID_CONFIRMATION_MSG);
///		} else {
			///if (assetRef.assetValue) {
				///var asset = getFormElement(formObj, PARAM_ASSET_ID);
///				asset.value = assetRef.assetValue;
			///}

			// override refers to the propertyPage command submit, if it is true, execute
///			var override = findOverrideAction(frmAction);
			///if (override != "" ) {
				///eval( override );
///			} else {

				// save original form values to reset them back after form is submitted
			///	var tmpAction = formObj.action
				///var tmpTarget = formObj.target
///				var tmpMethod = formObj.method

			///	var actionElement = getFormElement(formObj, PARAM_ACTION);
///				var contextElement = getFormElement(formObj, PARAM_CONTEXT);

				// save off original form values so that we can reset them once
				// we post the form.
			///	var tmpActionElement = actionElement.value;
///				var tmpContextElement = contextElement.value;

				// set action and context params to values of the asset map
				// so that we post to the right place
			///	actionElement.value = actionMapNode.actionURL;
///				contextElement.value = actionMapNode.context;

				// if target window is supplied, we go there.
			///	if (actionMapNode.isTargetWindow) {
					///targetName = createBrowserSafeName(actionMapNode.dialogName);
///					targetWidth = actionMapNode.dialogWidth;
			///		targetHeight = actionMapNode.dialogHeight;
					///var win = Popwin(contextElement.value, '', sessionKey, targetName, '', targetWidth, targetHeight);
///					formObj.target = win.name;
			///	}

				// If we find that our redirect URL is on a
				// different server, then we don't want to
				// go to the default redirector.  Instead, we
				// should assign the form to the actual URL
				// itself, as we are going to leave this app
				// context.
///				if (isExternalLink(actionElement.value)) {
			///		formObj.action = actionElement.value;
///				} else {
			///		formObj.action = buildActionURL(actionElement.value, contextElement.value);
///				}

				// from the toolbar, we want to reset the form type to post in order
				// to not encounter GET size restrictions when acting on > 30 items (est).
				// The form method is reset back to its previous state below.
///				formObj.method="POST"

			///	submitListView(formObj);

				// reset initial form values
///				formObj.method = tmpMethod;
///				formObj.action = tmpAction;
///				formObj.target = tmpTarget;
///				actionElement.value= tmpActionElement;
///				contextElement.value= tmpContextElement;
			///}
///		}
	///}
///}

function buildActionURL(actionURL, actionContext) {
	var newURL = actionContext + actionURL;
	return newURL;
}

function isExternalLink(link) {
    // if the link starts with "http:" or "https:", it's external, return true
    if (link.substring(0,5) == "http:" || link.substring(0,6) == "https:") {
        return true;
    } else {
        return false;
    }
}

function getFormElement(formObj, paramName) {
	return eval('document.' + formObj.name + '.' + paramName);
}


// returns an array of the currently selected checkbox form elements
// in the list view
function getSelectedObjects(formObj) {

	var selectedObjects = getFormElement(formObj,INPUT_SELECTED_OBJECTS);
	var selectedObjectsArray = new Array();
	var arrayIndex = 0;

	if (formObj && selectedObjects)  {
		if (selectedObjects.length > 0 ) {
			for (i=0; i<=selectedObjects.length; i++) {
				if (selectedObjects[i] && selectedObjects[i].checked == true) {
					selectedObjectsArray[arrayIndex] = selectedObjects[i];
					arrayIndex++;
				}
			}
		} else if (selectedObjects.checked) {
				selectedObjectsArray[arrayIndex] = selectedObjects;
		}
	}

	return selectedObjectsArray;
}


// returns an array of the currently selected checkbox Ids in the list view
function getSelectedIds(formObj) {

	var selectedIdArray = new Array();

	// get the array of currently selected form element objects
	var selectedObjectsArray = getSelectedObjects(formObj);

	// for each array element, grab the "value" field and put it in the
	// array of ids to be returned
	if (selectedObjectsArray.length > 0) {
		for (i=0; i<selectedObjectsArray.length; i++) {
			selectedIdArray[i] = selectedObjectsArray[i].value;
		}
	}

	return selectedIdArray;
}



function findOverrideAction(newUrl) {
    var prefix = "javascript:";
    var a = "";
    var b = "";
    if( newUrl != "" && newUrl.length > prefix.length ) {
	a = newUrl.substring( 0, prefix.length );
	if( a == prefix ) {
	    b = newUrl.substring( prefix.length, newUrl.length );
	}
    }
    return b;
}


function pageRedirect(formObj, op, inputVal, totalPages) {

	if (totalPages != 1) {

		var currentPage = getFormElement(formObj, PARAM_CURRENT_PAGE);

		// will return a new page number or -1 for invalid input
		var newPage = getPageNumber(currentPage.value, op, "",inputVal, totalPages)

		if( getSelectedObjects(formObj).length > 0 ) {
		    // ask user to confirm page change
		    if( confirm(ERR_JS_SELECTED_ITEMS_WILL_BE_LOST)) {
		        if (newPage != -1) {
			        currentPage.value = newPage

			        // this is a navigational action
			        navigationAction = true;
			        submitListView(formObj);
		        }
		    }
		}
		else if (newPage != -1) {
			currentPage.value = newPage

			// this is a navigational action
			navigationAction = true;

			submitListView(formObj);
		} else {
				alert(ERR_JS_INVALID_PAGE_INPUT + " " +totalPages);
		}
	} else {
		alert(ERR_JS_ALL_ITEMS_DISPLAYED);
	}
}

function submitListView(formObj) {

	// We need to get the action of the form object and if it contains a query string,
	// add each key/value pair as a hidden input that will get submitted with the form
	var queryStringParameters = getQueryStringParameters(formObj.action);
	addFormInputs(formObj, queryStringParameters);

	// if this is a navigation action, we go to our internal action
	if (navigationAction) {

		var tmpAction = formObj.action;

		var actionForward = getFormElement(formObj, PARAM_ACTION_FORWARD);
		actionForward.value = formObj.action;

		formObj.action = navigationActionUrl

	}

	formObj.submit();

	// if this is a navigation action, reset to original action and
	// reset navigation flag
	if (navigationAction) {
		formObj.action = tmpAction;

		// reset navigation action
		navigationAction = false;
	}
}

function getPageNumber (currentPage, op, formObj, inputVal, totalPages) {
	switch(op) {
		case "next":  {
			return parseInt(currentPage) + 1;
		} break;
		case "previous":	{
				return parseInt(currentPage)-1;
		} break;
		case "first":	{
			return (0);
		} break;
		case "last":	{
			return parseInt(totalPages)-1;	;
		} break;
		case "input":	{
			if (validateNumeric(inputVal) && validateRange(inputVal,totalPages)) {
				return parseInt(inputVal) - 1;
			} else {
				// error condition, invalid input
				return "-1"
			}
		} break;
	}
}

function sortRedirect(formObj, sortColumn) {

	var sortColumnElement = getFormElement(formObj, PARAM_SORT_COLUMN);
    var sortOrderElement = getFormElement(formObj, PARAM_SORT_ORDER);

	if (sortColumn == sortColumnElement.value && sortOrderElement.value == SORT_ORDER_ASCENDING) {
		sortOrderElement.value = SORT_ORDER_DESCENDING;
	} else {
		sortOrderElement.value = SORT_ORDER_ASCENDING;
	}

	sortColumnElement.value = sortColumn;

	// this is a navigational action
	navigationAction = true;

	submitListView(formObj);
}

function containerRedirect(formObj, logicalPath, logicalLabelPath) {
	var logicalPathElement = getFormElement(formObj, PARAM_LOGICAL_PATH);
	logicalPathElement.value = logicalPath;

	var logicalLabelPathElement = getFormElement(formObj, PARAM_LOGICAL_LABEL_PATH);
	logicalLabelPathElement.value = logicalLabelPath;

	// when we navigate down into the container, we want to make sure that the resulting
	// listViewTag starts on page 1 of 1.. setting this var tells
	// ListViewNavigation to do the right thing.
	resetPagination(formObj);

	// this is a navigational action
	navigationAction = true;

	submitListView(formObj);
}

function assetRedirect(formObj, assetId, defaultActionURI) {

	// get handle to formElements
	var actionElement = getFormElement(formObj, PARAM_ACTION);
	var contextElement = getFormElement(formObj, PARAM_CONTEXT);
	var assetElement = getFormElement(formObj, PARAM_ASSET_ID);

	// save tmp values for action, rtAction, and rtContext
	var tmpAction = formObj.action;
	var tmpRtAction = actionElement.value;
	var tmpContext = contextElement.value;

	// set the original form values to the appropriate redirect values
	assetElement.value = assetId;
	actionElement.value = defaultActionURI;
	contextElement.value = redirectContext;

    	formObj.action = defaultActionURI;
	formObj.target = SimplePopwin('', removeSpecialCharacters(assetId),'',700,500);
	formObj.target = removeSpecialCharacters(assetId);

	// submit the form
	submitListView(formObj);

	// reset original form values
    formObj.action = tmpAction;
	contextElement.value = tmpContext;
	actionElement.value = tmpRtAction;
	formObj.target = '';
	assetElement.value = '';
}

function parentRedirect(formObj, logicalPath, logicalLabelPath) {
	var logicalPathElement = getFormElement(formObj, PARAM_LOGICAL_PATH);
	logicalPathElement.value = logicalPath;

	var logicalLabelPathElement = getFormElement(formObj, PARAM_LOGICAL_LABEL_PATH);
	logicalLabelPathElement.value = logicalLabelPath;

	// when we navigate up to the parent,  we want to make sure that the resulting
	// listViewTag starts on page 1 of 1.. setting this var tells
	// ListViewNavigation to do the right thing.
	resetPagination(formObj);

	// this is a navigational action
	navigationAction = true;

	submitListView(formObj);
}

// in situations where we want the resulting listView to start over at page 1,
// we pass in this parameter and the ListViewNavi
function resetPagination(formObj) {
	var resetPaginationElement = getFormElement(formObj, PARAM_RESET_PAGINATION);
	resetPaginationElement.value = true;
}

function getQueryStringParameters(action) {
    var parameters = new Array();

    var parametersIndex = 0;
    // Find the "?", if any
    var i = action.indexOf('?');
    if (i == -1) {
        // No ?, so no query string
        return parameters;
    }

    // Ok, we found a ?, now take the rest of the string. This is the query string
    var queryString = action.slice(i + 1, action.length);

    // Split the query string into key/value pairs.  Each one will look like 'foo=bar'.
    var keyValuePairs = queryString.split('&');

    // Loop through each key value pair and break out the key and the value
    for (var j = 0; j < keyValuePairs.length; j++) {

        // Split the key/value pair
        var keyValues = keyValuePairs[j].split('=');

        // Set the key into the parameters array
        parameters[parametersIndex] = keyValues[0];

        // Increment the parameters index
        parametersIndex++;

        // If there is a value, set it into the parameters array.  If not, set an empty string.
        if (keyValues[1]) {
            parameters[parametersIndex] = keyValues[1];
        } else {
            parameters[parametersIndex] = "";
        }
        // Increment the parameters index.
        parametersIndex++;
    }

    return parameters;
}

function addFormInputs(formObj, parameterList) {

	for (var i = 0; i < parameterList.length; i = i + 2) {

		if (eval('formObj.' + parameterList[i])) {
			eval(formObj.name + '.' + parameterList[i] + '.value="' + parameterList[i + 1] + '"')
		} else {
			if (isIE) {
				var newHiddenInput = document.createElement("<input type='hidden' name='" + parameterList[i] + "' value= '" + parameterList[i + 1] + "'/>");
			} else {
				var newHiddenInput = document.createElement('input');
				newHiddenInput.type = "hidden";
				newHiddenInput.name = parameterList[i];
				newHiddenInput.value = parameterList[i + 1];
			}

			formObj.appendChild(newHiddenInput);

		}
	}

}
