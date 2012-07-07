import java.util.concurrent.*;
import java.math.*;

public class DuasThreads2 implements Runnable{
	
	DuasThreads2() {
		new Thread(this).start();
	}
	
	public static void main (String[] args) {
		new DuasThreads2();
		new DuasThreads2();
		
	}

	public void run () {

		for (int i = 0; i < 10; i++)
			System.out.println(i);
	}}
