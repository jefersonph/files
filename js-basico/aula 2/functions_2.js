window.onload=function()
{
	document.getElementsByTagName('input')[1].onclick=function(event){
		  this.parentNode.style.backgroundColor = this.previousSibling.value;
	}
}

