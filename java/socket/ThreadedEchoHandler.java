import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;        
import java.awt.Color;

public class ThreadedEchoHandler implements Runnable{
		private Socket incoming;
		static int i = 0;
		
		ThreadedEchoHandler(Socket inc){
			incoming = inc;
		}
		
		public static void main(String[] args){
			try
			{
				
				ServerSocket s = new ServerSocket(8000);
				while (true){
					Socket incoming = s.accept();
					Runnable r = new ThreadedEchoHandler(incoming);
					Thread t = new Thread(r);
					t.start();
					i++;
				}	
			}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		}

	public void run (){
		
		 try
         {
			InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true);
            out.println( "Hello! Enter BYE to exit." );
            
            JFrame frame = new JFrame("Conexao " + i );
            frame.setSize(300,300);
            frame.setVisible(true);
            boolean done = false;
            while (!done && in.hasNextLine())
            {
               String line = in.nextLine();
               out.println("Echo: " + line);
               if (line.trim().equals("BYE"))
            	   done = true;
               
               else if (line.trim().equals("BLUE"))
            	    frame.getContentPane().setBackground(Color.BLUE);
                
               else if (line.trim().equals("BLACK"))
           	    frame.getContentPane().setBackground(Color.BLACK);
               
               else if (line.trim().equals("RED"))
           	    frame.getContentPane().setBackground(Color.RED);
               
                
            }
         
            
         }
		 
		 catch (IOException e) 
		 {
			e.printStackTrace();
		 }
       
		 finally
         {
           try {
			incoming.close();
		} 
           catch (IOException e) 
		{
			e.printStackTrace();
		}
       
         }
        
     }
	public void cor(){
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLUE);
	}
}
