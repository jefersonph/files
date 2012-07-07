import java.util.concurrent.locks.*;

public class CubbyHole {

private String contents;
private int conNumber;
private boolean available = false;
private Lock aLock = new ReentrantLock();
private Condition condVar = aLock.newCondition();
 
	public String get(int conexao) {
		aLock.lock();
		try {
			while (available == false || conexao == conNumber){
				try {
						condVar.await();
				} catch (InterruptedException e) { }
			}
			available = false;
			condVar.signalAll();
		} 
		finally {
			aLock.unlock();	
			return contents;
		}
	}
	public void put(String value, int conexao) {
		aLock.lock();
		try {
			while (available == true) {
				try {
						condVar.await();
				} catch (InterruptedException e) { }
			}
			conNumber = conexao;
			contents = value;
			available = true;
			condVar.signalAll();
		} finally {
			aLock.unlock();
		}
	}
}



