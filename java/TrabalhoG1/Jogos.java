public class Jogos {

  public String adversario;
  public int data;
  public String local;
  
  public Jogos(String ad, int dat, String loc){
	  adversario = ad;
	  data = dat;
	  local = loc;
  }
  public Jogos(){
	  adversario = " ";
	  data = 0;
	  local = " ";
  }
  public void mostrarDadosJogos() {
	  System.out.println();
	  System.out.println("Adversario:" + adversario);
	  System.out.println("Data:" + data);
	  System.out.println("Local:" + local);
	  
  }
}