//package trabalhoProdutorConsumidor;

public class CubbyHole1 {
	private static int contents = 0;
	private boolean available = false;

	public synchronized int get(int valor) {
		while (available == false) {
			try {
				//wait for Producer to put value
				wait();
			} catch (InterruptedException e) { }	
		}
		available = false;
		//notify Producer that value has been retrieved
		notifyAll();
		valor = contents - valor;
		setContents(valor);
		System.out.println(contents);
		return contents;
	}

	public synchronized void put(int value) {
		while (available == true) {
			try {
				//wait for Consumer to get value
				wait();
			} catch (InterruptedException e) { }
		}
		value = contents + value;
		setContents(value);
		available = true;
		System.out.println(contents);
		//notify Consumer that value has been set
		notifyAll();
	}
	
	public int getContents(){
		return contents;
	}
	
	public void setContents(int valor){
		contents = valor;
	}
}