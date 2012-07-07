
public class ThreadRoda {

	 public static void main(String args[]) { 
        ThreadExemplo a = new ThreadExemplo("A");
        ThreadExemplo b = new ThreadExemplo("B");
        ThreadExemplo c = new ThreadExemplo("C");
        
        a.start(); 
        b.start(); 
        c.start(); 
	}


}
