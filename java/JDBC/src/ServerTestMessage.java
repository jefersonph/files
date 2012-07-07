import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTestMessage {

	public static void main(String[] args )
	   {
		  CubbyHole c = new CubbyHole();
	      try
	      {
	         int i = 1;
	         ServerSocket s = new ServerSocket(10303);

	         while (true)
	         {
	            Socket incoming = s.accept();
	            System.out.println("Conexao " + i);
	            Runnable r = new ThreadedEchoHandler(incoming,c,i);
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
	
	
}
