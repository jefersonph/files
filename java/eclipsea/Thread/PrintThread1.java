public class PrintThread1 extends Thread { 
    String name; 
    public PrintThread1(String name) { 
        this.name = name; 
    } 
    public void run() {
        for (int i=1; i<500 ; i++) { 
            try { 
                sleep((long)(Math.random() * 100)); 
            } catch (InterruptedException ie) { } 	
            System.out.print(name); 
        } 
        }

    public static void main(String args[]) { 
       new PrintThread1("*").start();
       
	}
}

