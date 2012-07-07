public class Jogador extends Pessoa{

  public int peso;
  public int idade;
  public int altura;
      
 public Jogador(){
	  nome = " ";
	  peso = 0;
	  idade = 0;
	  altura = 0;
	  salario = 0;
	  cpf = 0;
  }
  public Jogador( String nome1, int peso1, int idade1, int altura1, int sal1, int cpf1){
	  this.nome = nome1;
	  this.peso = peso1;
	  this.idade = idade1;
	  this.altura = altura1;
	  this.salario = sal1;
	  this.cpf= cpf1;
  }

  public void mostrarJogador() {
	  System.out.println("Nome:" + this.nome);
	  System.out.println("Peso:" + this.peso);
	  System.out.println("Idade:" + this.idade);
	  System.out.println("Altura:" + this.altura);
	  System.out.println("Salario:" + this.salario);
	  System.out.println("CPF:" + this.cpf);
  }
  
}