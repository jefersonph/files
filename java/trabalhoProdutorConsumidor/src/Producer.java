//package trabalhoProdutorConsumidor;
public class Producer extends Thread {
	private CubbyHole1 cubbyhole;
	private int number;
	private String nome;
	
	public Producer(CubbyHole1 c, int number, String nome) {
		cubbyhole = c;
		this.number = number;
		this.nome = nome;
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
		cubbyhole.put(number);
		//System.out.println("Producer #" + this.number + " put: " + number);
		try {
			sleep(100);
		} catch (InterruptedException e) { }
	}
}
