function teste()
{
//alert(document.forms['formulario'].nome.value);
//alert(document.getElementsByName('nome')[0].value);
//alert(document.getElementById('nome').value);
//document.getElementById('confirmacao').value = document.getElementById('nome').value;
//alert(document.getElementsByTagName('h1')[0]);
//var el = document.getElementById('relatorio');
//alert(el.getElementsByTagName('tr')[0].value);
//alert(document.forms['formulario'].sexo[1].value);
//alert(document.forms['formulario']['opcao'][0].checked);
//alert(document.forms['formulario'].selecione.value);

/*
var t=document.getElementById('relatorio');
var trs=t.getElementsByTagName('tr');
var total=0;
var valor=0;

for(var i=0; i< trs.length; i++)
{
alert(trs[i].getElementsByTagName('td')[1].innerHTML);
//valor=trs[i].getElementsByTagName('td')[1].innerHTML;
//total+=parseInt(valor);
}
alert(total);
*/
document.forms['formulario'].textoarea.value = 'asdfasdfasdf';
alert(document.forms['formulario'].textoarea.value);


}












/*function hora()
{

horario=prompt("Hora atual?");
if (isNaN(horario) == false)
{
if(horario <12)
	alert("Bom Dia");
if(horario > 18)
	alert("Boa Noite");
else
	alert("Boa Tarde");
}
else
hora();
}
hora();	

*/
/*
var x=null;
for(x in document)
{
document.write(x+': '+document[x]+'<br/>');
}
*/
/*with(document)
{
	bgColor = 'blue';
}
*/
