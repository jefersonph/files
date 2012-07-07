import java.io.*;
import java.net.*;
import java.util.*;

class ThreadedEchoHandler implements Runnable
{
	private Socket incoming;
	private CubbyHole ch;
	private int conNumber;
    boolean done = false;
    OutputStream outStream;
    PrintWriter out;

   public ThreadedEchoHandler(Socket i, CubbyHole c, int conexao)
   {
      incoming = i;
      ch = c;
      conNumber = conexao;
   }

   public void run()
   {
      try
      {
         try
         {
            InputStream inStream = incoming.getInputStream();
            outStream = incoming.getOutputStream();

            Scanner in = new Scanner(inStream);
            out = new PrintWriter(outStream, true /* autoFlush */);

            out.println( "Hello! Enter BYE to exit." );

            Thread t = new Thread(
            		new Runnable(){
            			public void run() {
            	            while (!done) {
            	            	String msg = ch.get(conNumber);
            	                out.println("Mensagem: " + msg);
            	            }
            			}
            		}
            );
            t.start();
            
            while (!done && in.hasNextLine())
            {
               String line = in.nextLine();
               ch.put(line,conNumber);
               out.println("Echo: " + line);
               
               if (line.trim().equals("BYE"))
                  done = true;
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