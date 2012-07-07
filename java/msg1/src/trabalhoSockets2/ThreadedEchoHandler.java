package trabalhoSockets2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

class ThreadedEchoHandler extends JFrame implements Runnable {
	private Socket incoming;
	private CubbyHole ch;
	private int conNumber;
    boolean done = false;
    OutputStream outStream;
    PrintWriter out;
   // private Cliente cliente;
    //criar privatte static para passa o valor

    public ThreadedEchoHandler(Socket i, CubbyHole c, int conexao) {
      incoming = i;
      ch = c;
      conNumber = conexao;
   //   cliente = new Cliente("Servidor");
  //    cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //    cliente.setSize(300,400);
 //     cliente.setVisible(true);
   }

   public void run() {
      try {
       
         try {
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
            }
         finally {
            incoming.close();
         }
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
}