window.onload=function()
{
		document.getElementById('corDigitada').onkeyup=function(event){
		if(event.keyCode == 13){
			this.parentNode.style.backgroundColor = this.value;
		}
		}
}