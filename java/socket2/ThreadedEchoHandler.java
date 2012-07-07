import java.awt.Color;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;        


class ThreadedEchoHandler implements Runnable
{
	private Socket incoming;
	private JFrame frame;
	private int conNumber;

   public ThreadedEchoHandler(Socket i, int conNumber)
   {
      incoming = i;
      this.conNumber = conNumber; 
   }

   
   private void StartFrame (){
	   frame = new JFrame("Conexao " + conNumber);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(300,300);
       frame.setVisible(true);
   }
   
   private void SetColorFrame (int color) {
	   System.out.println(color);
	   
	   switch (color) {
	   case 1:
		   frame.getContentPane().setBackground(Color.RED);
		   break;
	   case 2:
		   frame.getContentPane().setBackground(Color.BLUE);
		   break;
	   case 3:
		   frame.getContentPane().setBackground(Color.BLACK);
		   break;
	   }
	   
   }
   
   public void run()
   {
	   StartFrame();
       
      try
      {
         try
         {
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

            out.println( "Hello! Enter BYE to exit or type a number to choose the color (RED, BLUE, BLACK)." );

            // echo client input
            boolean done = false;
            while (!done && in.hasNextLine())
            {
               String line = in.nextLine();
               out.println("Echo: " + line);
               if (line.trim().equals("BYE"))
                  done = true;
               else if (line.trim().equals("RED"))
            	   SetColorFrame(1);
               else if (line.trim().equals("BLUE"))
            	   SetColorFrame(2);
               else if (line.trim().equals("BLACK"))
            	   SetColorFrame(3);
            }
         }
         finally
         {
            incoming.close();
         }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

}