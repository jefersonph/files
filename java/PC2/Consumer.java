public class Consumer extends Thread { 
	private CubbyHole2 cubbyhole;
	private int number;

public Consumer(CubbyHole2 c, int number) {
	cubbyhole = c;
	this.number = number;
}

public void run() {
	int value = 0;
	for (int i = 0; i < 10; i++) {
		value = cubbyhole.get(i);
		System.out.println("Consumer #" + this.number + " got: " + value);
	} 
  }
}
