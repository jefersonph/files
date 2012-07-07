import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

import javax.swing.JFrame;

public class cliente extends JFrame implements ActionListener
{
	private Container cont; 
	private JButton conectaServer, closeServer;
	private JPanel panelOp;
	private JPanel panelNum;
	private Socket s;
	private JTextField textField1, textField2;
	private OutputStream outStream;
    private PrintWriter out;
    private JButton buttons[]; // Botoes 1-9

	private cliente ()  {
			super ("Cliente"); 
	      	cont = getContentPane();   
	      	cont.setLayout(new BorderLayout());
	      	
	      	panelNum = new JPanel(new GridLayout(4,1,2,2)); 
	      	panelOp = new JPanel(new GridLayout(6,1,1,1));
	      
			textField1 = new JTextField( 30 );    
			textField2 = new JTextField( 10 ); 
			conectaServer = new JButton("Conecta no servidor");
			closeServer = new JButton("Desconecta");
		    buttons = new JButton[ 10 ]; // set size of array
		    
			panelOp.add( textField1 );
			panelOp.add( textField2 );
			panelOp.add( conectaServer );
			panelOp.add( closeServer );
		        
			conectaServer.addActionListener( this );
			
		    for ( int count = 1 ; count < 10; count++ )
		    {
		    	buttons[ count ] = new JButton( new Integer(count).toString() );
		    	buttons[ count ].addActionListener( this );
		    	panelNum.add(buttons[ count ]);
		    }
		    
		    panelNum.setBackground(Color.BLACK);
		    
		    cont.add(panelNum, BorderLayout.CENTER);    
		    cont.add(panelOp, BorderLayout.NORTH);
	}
	
	public void actionPerformed( ActionEvent e )
	{
			try{
	    	   	 for ( int count = 1 ; count < 10; count++ )
	        	 {
	        		 	if (e.getSource() == buttons[ count ]){
	        		 		buttons[ count ].setText("X"); 
	        		 	}
	      	    	  if (e.getSource() == buttons[ 9 ])  {
	                      out.println("BLUE");
	     	    	  }
	        	 }
	        	  if (e.getSource() == conectaServer) {

	        		  String nome = textField1.getText();
	        		  int porta = Integer.parseInt(textField2.getText());	            	 
	        		  s = new Socket(nome, porta);
	        		  outStream = s.getOutputStream();
	        		  out = new PrintWriter(outStream, true);
	        	  }
	        	  else 
	    		 	s.close();
	   		}
	    	catch (Exception exception) {   
	    	         JOptionPane.showMessageDialog(null, "ERRO - Uso incorreto");
	    	         System.out.println(exception); 
	       	}
	 }
	
	public static void main(String[] args)
    {
		cliente teste = new cliente(); 
        teste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teste.setSize(300,400);
        teste.setVisible(true);

    }
}