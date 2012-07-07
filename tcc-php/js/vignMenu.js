// Vignette Management Console dynamic HTML drop-down menus

// notes:
// 1) need to be able to key the width attribute off of another object's width
// 2) need to investigate positioning in general.  pixel coords aren't very flexible.
// 3) need to investigate impact of icon action menus


// Menu Constants

var menuDelay = null;
var theMenus = new Array();
var undefined;

// Variable Declarations
var consoleMenus;
var pathMenu = new Array();
var toolbarMenu = new Array();


var global_menuTimeOut = null;

// Global Functions
function clearAll() {
	if (global_menuTimeOut)
		document.getElementById(global_menuTimeOut + "Block").style.visibility = 'hidden';

}

function helpResize() {
	if (helpMenu[0]) {
		helpMenu[0].xcoord = 0;
		helpMenu[0].ycoord =0;
	}
}

// Menu Objects

function vignMenu_object (	sID, 				//    ID - Name of menu
							oKeyElement, 		//    keyElement - object which fires menu (not href; should be td or span)
							iXcoord, 			//    xcoord - top coord
							iYcoord, 			//    ycoord - left coord
							iWidth, 			//    width - menu width  (presently ignored)
							sClassName, 		//    className - className of menu
							iMenuType			//    iMenuType - 0-menubar 1-pathbar 2-toolbar
						) {
	this.ID = sID;
	this.keyElement = oKeyElement;
	this.xcoord = iXcoord;
	this.ycoord = iYcoord;
	this.width = iWidth;
	this.className = sClassName;
	this.menuItems= new Array();
	this.menuType = iMenuType;
	this.parentObject = null;
}


function vignMenuItem_object (sLabel, sUrl, sOverClassName, sDisabledClassName, sImgPath, itemID, iMenuItemCount) {

	this.label = sLabel;							// the display string
	this.url = sUrl;								// where to go & what to do
	this.overClassName = sOverClassName;			// over (for button menus)
	this.disabledClassName = sDisabledClassName;	// disabled (for button menus)
	this.imagePath = sImgPath;						// if there's an image
	this.ID = itemID;								// unique ID (button menus)
	this.itemIndex = iMenuItemCount;				// ordinal of menu item in list
	this.state = true;
	this.stateOverClass = new Array(2);					// changes on action state (for button menus)
	this.stateOverClass[true] = sOverClassName;
	this.stateOverClass[false] = sDisabledClassName;
	this.stateOutClass = new Array(2);
	this.stateOutClass[true] = "";
	this.stateOutClass[false] = sDisabledClassName;
	this.colorValue = new Array(2);
	this.colorValue[true] = "#000000";
	this.colorValue[false] = "#666666";
	this.parentObject = null;
}

vignMenu_object.prototype.menuItemOver = function (oObject,sClassName) {
	oObject.className = sClassName;
	if (this.menuType == 0) {
	//alert('keyelement.id child? ' + this.keyElement.firstChild.id);
		//this.keyElement.firstChild.className="vign-menuLinkMain1Roll";
	}
}


vignMenu_object.prototype.menuItemOut = function (oObject,sClassName) {
	oObject.className = sClassName;
	if (this.menuType == 0) {

		//this.keyElement.firstChild.className="vign-menuLinkMain1Roll";
	}
}

vignMenu_object.prototype.addMenuItem = function (sLabel, sUrl, sOverClassName, sDisabledClassName, sImgPath, itemID) {
	// object constructor for menu items
	var menuItemCount = this.menuItems.length;
	this.menuItems[menuItemCount] = new vignMenuItem_object (sLabel, sUrl, sOverClassName, sDisabledClassName, sImgPath, itemID, menuItemCount);
	this.menuItems[menuItemCount].parentObject = this;
	return this.menuItems[menuItemCount];
}

vignMenu_object.prototype.displacer = function(Left) {

	document.getElementById("div_displacer").style.left = Left;
	//alert(getLeft(document.getElementById("div_displacer")) + '  ' + Left);
}

vignMenu_object.prototype.showMenu = function() {
	// turn on the menu

	if (arguments.length > 0) var embedded = arguments[0];
	if (menuDelay) clearTimeout(menuDelay);
	clearAll();

	theBlock = document.getElementById(this.ID + "Block");
	switch (this.menuType) {
	// positioning modifiers based on menuType
			case 0: {
				// menubar
				if (this.xcoord == 0) this.xcoord = getLeft(this.keyElement);
				if (this.ycoord == 0) this.ycoord = getTop(this.keyElement) + this.keyElement.offsetHeight;
				theBlock.style.top = this.ycoord + 0;
				theBlock.style.left = this.xcoord - 0;
				theBlock.style.zIndex = 1003;
				//this.keyElement.firstChild.className="vign-menuLinkMain1Roll";
			} break;
			case 1: {
				// pathbar
				if (this.xcoord == 0) this.xcoord = getLeft(this.keyElement);
				if (this.ycoord == 0) this.ycoord = getTop(this.keyElement) + this.keyElement.offsetHeight;
				theBlock.style.top = this.ycoord;
				theBlock.style.left = this.xcoord;
				theBlock.style.zIndex = 1001;
				theBlock.style.width = this.keyElement.offsetWidth;
			} break;
			case 2: {
				// toolbar
				NNyMod = 0;
				NNxMod = 0;
				if (NN) {
					NNyMod = 3;
					NNxMod = 2;
				}
				this.keyElement.embedded = embedded;
				this.xcoord = getLeft(this.keyElement);
				this.ycoord = getTop(this.keyElement) + this.keyElement.offsetHeight;
				theBlock.style.top =   this.ycoord - 1 + NNyMod;
				theBlock.style.left =  this.xcoord + 0 + NNxMod;
				theBlock.style.zIndex = 10002;
				this.keyElement.className = "vign-toolbarSpanOver";
			} break;
			case 3: {
				// helpmenu, right-aligned
				if (this.xcoord == 0) this.xcoord = getLeft(this.keyElement);
				if (this.ycoord == 0) this.ycoord = getTop(this.keyElement) + this.keyElement.offsetHeight;
				theBlock.style.top = this.ycoord + 1;
				theBlock.style.left = this.xcoord + this.keyElement.offsetWidth - theBlock.offsetWidth;
				theBlock.style.zIndex = 1004;
				appendToHandler("onresize",";helpResize();");
			} break;
	}
	if (theBlock.offsetWidth > 10) theBlock.style.visibility = 'visible';
}

function clearTopMenu (sTopMenu,sClassName) {
	//document.getElementById(sTopMenu).className = sClassName;
	//this.keyElement.firstChild.className="vign-menuLinkMain1";
}

vignMenu_object.prototype.clearMenu = function () {
	document.getElementById(this.ID + "Block").style.visibility = 'hidden';
}

vignMenu_object.prototype.hideMenu = function() {
	// turn off all menus
	global_menuTimeOut = this.ID;
	if (arguments.length > 0) {
		menuDelay = setTimeout("clearAll()", arguments[0]);
	} else {
		menuDelay = setTimeout("clearAll()", 300);
	}
	if (this.menuType == 0) {
		//this.keyElement.firstChild.className="vign-menuLinkMain1";
	}
}

vignMenu_object.prototype.buildMenu = function(sThisMenu,iIndex,offClass,overClass) {
	// draw the <span> & table which comprise the menu

	if (this.width == 0) this.width = this.keyElement.offsetWidth;
	MenuStr = sThisMenu + "[" + iIndex + "]"
	document.write("<span class='" + this.className + "' id='" + this.ID + "Block' style='position:absolute; visibility:hidden; z-index:-1001; top:" + this.xcoord + "px ;left:" + this.ycoord + "px;'  onMouseOut='" + MenuStr + ".hideMenu()' onMouseOver='clearTimeout(menuDelay)'>");
	document.write("<table id='table_menu" + this.ID );
	document.write("' cellpadding='3' cellspacing='0' border='0'>");
	for (i=0;i<this.menuItems.length;i++) {
		theMenuItem=this.menuItems[i];
		if (theMenuItem.ID == undefined) {
			// create unique names for the items if they weren't passed in
			theMenuItem.ID = sThisMenu + iIndex + i;
		}
		theMenuItem.stateOutClass[true] = offClass;
		//alert('buildMenu:   td_' + theMenuItem.ID);

		if (isIE()) {
			document.write("<tr><td nowrap='nowrap' class='" + offClass + "' id='td_" + theMenuItem.ID + "' onClick='this.childNodes(1).click(); " + MenuStr + ".hideMenu(0)' onMouseOut='" + sThisMenu + "[" + iIndex + "].menuItemOut(this,\"" + offClass + "\")' onMouseOver='" + sThisMenu + "[" + iIndex + "].menuItemOver(this,\""  + overClass + "\")'>&nbsp;");
		} else {
			document.write("<tr><td nowrap='nowrap' class='" + offClass + "' id='td_" + theMenuItem.ID + "' onClick='" + MenuStr + ".hideMenu(0)' onMouseOut='" + sThisMenu + "[" + iIndex + "].menuItemOut(this,\"" + offClass + "\")' onMouseOver='" + sThisMenu + "[" + iIndex + "].menuItemOver(this,\""  + overClass + "\")'>&nbsp;");
		}

		if (this.menuType == 1) {
			for (j=0;j<i;j++) {
				document.write("&nbsp;&nbsp;");
			}
		}
		if (theMenuItem.imagePath != "") {
			imageString = "<img src='" + theMenuItem.imagePath + "' border='0' align='absmiddle'>&nbsp;";
		} else {
			imageString = "";
		}
		document.write("<a id='href_" + this.menuItems[i].ID + "' style='text-decoration:none;color:#000000' href='" + theMenuItem.url + "'>" + imageString + theMenuItem.label + "</a>&nbsp;</td></tr>");
	}
	document.write("</table>");
	document.write("</span>");
}

vignMenu_object.prototype.fixPathWidth = function() {
	this.width = this.keyElement.offsetWidth;
	document.getElementById("table_menu" + this.ID).style.width = this.width;
}

function doClickMenu(menuObj,visFlagString) {
	visFlag = eval(visFlagString);
	if (visFlag) {
		menuObj.hideMenu();
	} else {
		menuObj.showMenu();
	}
	eval(visFlagString + "= !visFlag");
}




