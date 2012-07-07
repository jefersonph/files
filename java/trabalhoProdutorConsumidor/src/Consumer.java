//package trabalhoProdutorConsumidor;
public class Consumer extends Thread {
	private CubbyHole1 cubbyhole;
	private int number;
	private String nome;
	private String nomeProducer;
	
	public Consumer(CubbyHole1 c, int number, String nome) {
		cubbyhole   = c;
		this.number = number;
		this.nome   = nome;
		this.nomeProducer = "";
	}
	
	public int getNumber(){
		return this.number;
	}

	public String getNome(){
		return this.nome;
	}
	
	public String toString(int number){
		return new Integer(number).toString();
	}

	public void run() {
		cubbyhole.get(number);
		System.out.println("Consumer " + this.nome  + " consumiu: " + this.number);
		try {
			sleep(100);
		} catch (InterruptedException e) { }
	}
}
