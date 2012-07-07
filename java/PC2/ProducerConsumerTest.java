public class ProducerConsumerTest {
	public static void main(String[] args) {
		CubbyHole2 c = new CubbyHole2();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 2);
		Producer p2 = new Producer(c, 1);
		Consumer c2 = new Consumer(c, 2);
		p1.start();
		c1.start();
		p2.start();
		c2.start();
	}
}
