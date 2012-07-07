
function removeRow(tableRef,selectionBoxes,listFrameObject) {
// this function takes a reference to the table, a reference
// to the selection checkboxes, and a reference to the
// iframe, which is assumed to contain a routine called
// renameFormElements
	deleteArray = getSelectedBoxes(selectionBoxes);
		for (i=deleteArray.length-1;i>=0;i--) {
			tableRef.deleteRow(deleteArray[i]);
		}
	listFrameObject.renameFormElements(tableRef);
}

function copyRow(originalRow,destinationRow) {
	for (i=0;i<originalRow.cells.length;i++) {
		 destinationRow.cells(i).innerHTML = originalRow.cells(i).innerHTML;
		 destinationRow.className=originalRow.className;
	}
}

function swapRow(tableRef,row_a,row_b) {
	tempRow = tableRef.insertRow();
	for (i=0;i<row_a.cells.length;i++) {
		newCell = tempRow.insertCell();
	}
	copyRow(row_b,tempRow);
	copyRow(row_a,row_b);
	copyRow(tempRow,row_a);
	tableRef.deleteRow(tableRef.rows.length - 1);
}

function moveUp(tableRef,selectionBoxes) {
	var upArray = getSelectedBoxes(selectionBoxes);
	if (upArray.length > 0) {
		var iIndex, prevIndex;
		for (var i = 0; i < upArray.length; i++) {
			iIndex = upArray[i];
			if (iIndex)	{
				prevIndex = iIndex - 1;
				if (!selectionBoxes[prevIndex].checked) {
					swapRow(tableRef,tableRef.rows(iIndex),tableRef.rows(prevIndex));
				}
			}
		}
	} // if upArray
}

function moveDown(tableRef,selectionBoxes) {
	var downArray = getSelectedBoxes(selectionBoxes);
	if (downArray.length > 0) {
		var iIndex, nextIndex;
		var maxLength = tableRef.rows.length - 2;
		var i = downArray.length - 1;
		while (i >=0) {
			iIndex = downArray[i];
			i--;
			if (iIndex < maxLength) {
				nextIndex = iIndex + 1;
				if (!selectionBoxes[nextIndex].checked) {
					swapRow(tableRef,tableRef.rows(iIndex),tableRef.rows(nextIndex));
				}
			}
		}	
	}
}


function getSelectedBoxes(form_boxRef) {
	var i;
	var returnArray = new Array();
	if (form_boxRef) {
		if (form_boxRef.length != undefined) {
			for (i=0; i < form_boxRef.length;i++) {
				if (form_boxRef[i].checked) {
					returnArray[returnArray.length] = i;
				}
			}
		} else {
			if (form_boxRef.checked) {
				returnArray[0] = 0;
			}
		}
	}
	return returnArray;
}



function WStoggleBoxes(theState,formRef) {
	// this routine handles toggling all the selection checkboxes
	// in the Workspace Iframe.  Assumes a global state handler for the list
	// that gets passed in as theState.  This version of toggleBoxes looks
	// for form elements ending in "_selected" to find the selection checkboxes
	
	for (i=0;i<formRef.length;i++) {
		if (formRef.elements[i].name.lastIndexOf('_selected') == formRef.elements[i].name.length - 9) {
			formRef.elements[i].checked = !theState;
		}
	}
	return !theState;
}


function testForEmpty(theState,selectionBoxes,toggleControl) {
	// if there are no more items in the list, the toggle checkbox
	// is disabled.  The global state variable should be set to 
	// the results of this function
	if (selectionBoxes) {
		toggleControl.disabled = false;
		toggleControl.checked = false;
		return false;
	} else {
		toggleControl.disabled = true;
		toggleControl.checked = false;
		return false;
	}
}


function extractFunctionName(oFunction) {
	// takes a function object and returns its name as a string
	var tempString = oFunction.toString();
	return tempString.substring(tempString.indexOf(" ") + 1,tempString.indexOf("("));
}


