public class DuasThreads {
	public static void main (String[] args) {
		new SimpleThread("Jamaica").start();
		new SimpleThread("Fiji").start();
		}
	}