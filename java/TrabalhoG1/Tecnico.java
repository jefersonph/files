public class Tecnico extends Pessoa {

  public String categoria;
   
  public Tecnico(String nome1, int cpf1, int salarioTec, String categoriaTec){
	  nome = nome1;
	  cpf = cpf1;
	  salario = salarioTec;
	  categoria = categoriaTec;
  }
  public Tecnico(){
	  nome = " ";
	  cpf = 0;
	  salario = 0;
	  categoria = " ";
  }
  public void mostrarTecnico() {
	  System.out.println();
	  System.out.println("Nome:" + nome);
	  System.out.println("CPF:" + cpf);
	  System.out.println("Salario:" + salario);
	  System.out.println("Categoria:" + categoria);
  }
}