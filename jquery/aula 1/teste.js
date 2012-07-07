function testar(){

var nome2 = document.getElementById('nome').value;

if (nome2.length >= 1 && nome2.length <= 3)
	alert('Menor que ou igual a 3');
else if(nome2.length == 0)
	alert('valor eh nulo');
else if (nome2 == " ")
	alert('igual a espaco');
}

function maior2(){
var num1 = prompt("numero 1");
var num2 = prompt("numero 2");
var num3 = prompt("numero 3");

var maior1 = num1;

if (maior1 < num2)
	maior1 = num2;
if (maior1 < num3)
	maior1 = num3;

alert("maior: " +maior1);
}

function maior(){
var num1 = prompt("numero 1");
var num2 = prompt("numero 2");

if (num1 > num2)
	alert("maior: " +num1);
else
	alert("maior: " +num2);

}
function maiortri(){

var num10 = 0;
var maiort = 0;
do {
	if(maiort < num10)
		maiort = num10;
	num10 = prompt("numero");   		
} while (num10 != "parar")

alert("maior: " +maiort);

}

function contrario(string){
	for(var a=string.length; a >= 0; a--){
		console.log(string[a]);
	}
}

window.onload=function()
{
var nome;
nome = prompt ("Qual e o seu nome?");
document.getElementById('nome').value = nome;
//testar();
//maior();
//maior2();
//maiortri();
contrario(nome);
}


