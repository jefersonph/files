public class Time {

  public String nomeTime;
  public int fundacao;
  public int socios;
 
  public Time(String nomeT, int fund, int soc){
	  nomeTime= nomeT;
	  fundacao = fund;
	  socios = soc;
  }
public void mostrarDadosTime() {
	  System.out.println();
	  System.out.println("Nome:" + nomeTime);
	  System.out.println("Fundacao:" + fundacao);
	  System.out.println("Socios:" + socios);
  }
}