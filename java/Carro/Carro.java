
public class Carro {

  private int marca;
  private int  placa;
  private String chassi;
  private String ano;
  private String cor;
  private int potencia;
  



public void Carro(){
	  marca = 0;
	  placa = 0;
  }
  
  public void Carro(int newMarca, int newPlaca){
	  marca = newMarca;
	  placa = newPlaca;
  }
  
  public int mostrarMarca() {
	  return (marca);
  }

  public void alterarMarca(int newMarca) {
	  marca = newMarca;
  }

  public int mostrarPlaca() {
	  return (placa);
  }

  public void alterarPlaca(int newPlaca) {
	  placa = newPlaca;
  }

  public String mostrarChassi() {
	  return (chassi);
  }

  public void alterarChassi(String newChassi) {
	  chassi = newChassi;
  }

  public String mostarCor() {
	  return (cor);
  }
  
  public void alterarAno(String newAno) {
	  ano = newAno;
  }

  public String mostarAno() {
	  return (ano);
  }
  public void alterarCor(String newCor) {
	  cor = newCor;
  }

  public int mostrarPotencia() {
	  return (potencia);
  }

  public void alterarPotencia(int newPotencia) {
	  potencia = newPotencia;
  }
}
