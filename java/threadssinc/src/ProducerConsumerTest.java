public class ProducerConsumerTest {
public static void main(String[] args) {
CubbyHole1 c = new CubbyHole1();
Producer p1 = new Producer(c, 1);
Consumer c1 = new Consumer(c, 1);

c1.start();
p1.start();
}
}
