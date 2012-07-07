import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

import javax.swing.JFrame;

public class ClienteCores
{
	private JButton conectaServer, closeServer, corRed, corBlue, corBlack;
	private JFrame frame;
	private Socket s;
	private JTextField textField1, textField2;    
	private OutputStream outStream;
    private PrintWriter out;

	
	private void constroiFrame () {
			frame = new JFrame("Cliente");
	        frame.setLayout( new FlowLayout() ); // set frame layout

	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setSize(300,300);
	       
			textField1 = new JTextField( 30 );    
			textField2 = new JTextField( 10 );    
			conectaServer = new JButton( "Conecta no servidor" );
			closeServer = new JButton( "Desconecta" );
			corRed = new JButton( "Red" );
			corBlue = new JButton( "Blue" );
			corBlack = new JButton( "Black" );

			frame.add( textField1 );
			frame.add( textField2 );
			frame.add( conectaServer );
			frame.add( closeServer );
			frame.add( corRed );
			frame.add( corBlue );
			frame.add( corBlack );

			frame.setVisible(true);
			
			ButtonColorHandler handler = new ButtonColorHandler();         
			corBlue.addActionListener( handler );
			corRed.addActionListener( handler );
			corBlack.addActionListener( handler );

			ButtonConHandler handlerCon = new ButtonConHandler();         
			conectaServer.addActionListener( handlerCon );
	}
	
	public static void main(String[] args)
   {
		ClienteCores STest = new ClienteCores(); 
		STest.constroiFrame();

   }

	private class ButtonColorHandler implements ActionListener
	   {
	      public void actionPerformed( ActionEvent event )
	      {
	    	  if (event.getSource() == corBlue) {
                 out.println("BLUE");
	    	  }
	    	  else if (event.getSource() == corRed) {
	                 out.println("RED");
		    	  }
	    	  else if (event.getSource() == corBlack) {
	                 out.println("BLACK");
		    	  }
	      } 
	   } 
   
	private class ButtonConHandler implements ActionListener
	   {
	      public void actionPerformed( ActionEvent event )
	      {
	          try {
	    	  if (event.getSource() == conectaServer) {

	        	  String nome = textField1.getText();
	        	  int porta = Integer.parseInt(textField2.getText());	            	 
	        	  s = new Socket(nome, porta);
	        	  outStream = s.getOutputStream();
	              out = new PrintWriter(outStream, true);
	                 
	    	  }
	    	  
	    	  else {
	    		  s.close();
	    	  }
	          }
	          catch (IOException e)
	          {
	             e.printStackTrace();
	          }
	      } 
	     } 



}
