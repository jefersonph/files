var ch= "|";
window.onload=function()
{
	var tam = document.getElementsByTagName('input').length;
	var tam2 = parseInt(tam);
	tam2--;
	document.getElementsByTagName('input')[tam2].onclick=function(event){
		var ret= '';
		for(var i =0; i < tam2; i++){
			//console.log(document.getElementsByTagName('input')[i].value);
			ret+= document.getElementsByTagName('input')[i].value + ch;
		}
		console.log(ret);
	}
}