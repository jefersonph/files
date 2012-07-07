//package trabalhoProdutorConsumidor;
import java.util.concurrent.locks.*;
public class CubbyHole {
	private int contents;
	private boolean available = false;
	private Lock aLock = new ReentrantLock();
	private Condition condVar = aLock.newCondition();

	public int get(int who) {
		aLock.lock();
		try {
			while (available == false) {
				try {
						condVar.await();
				} catch (InterruptedException e) { }
			}
			available = false;
			System.out.println("Consumer " + who + " got: " + contents);
			condVar.signalAll();
		} finally {
			aLock.unlock();	
			return contents;
		}
	}

	public void put(int who, int value) {
		aLock.lock();
		try {
			while (available == true) {
				try {
						condVar.await();
				} catch (InterruptedException e) { }
			}
			contents = value;
			available = true;
			System.out.println("Producer " + who + " put: " + contents);
			condVar.signalAll();
		} finally {
			aLock.unlock();
		}
	}
}
