import java.io.*;
import java.net.*;
import java.util.*;
public class EchoServer
{
   public static void main(String[] args )
   {
      try
      {
	ServerSocket s = new ServerSocket(8189);
		 while(true){
         // wait for client connection
         Socket incoming = s.accept( );
         try
         {
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

            out.println( "Hello! Enter BYE to exit." );

            // echo client input
            boolean done = false;
            while (!done && in.hasNextLine())
            {
               String line = in.nextLine();
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
      }
      catch (IOException e)
      { e.printStackTrace();
      } 
    } 
   }

