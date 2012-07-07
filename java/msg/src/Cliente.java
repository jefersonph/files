
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Cliente extends JFrame implements ActionListener {
	
	private Container cont; 
	private JButton conectaServer, closeServer;
	private JPanel panelOp, panelNum;
	private Socket s;
	private JTextField textField1, textField2;
	private OutputStream outStream;
    private PrintWriter out;
    private static JButton buttons[];

	protected Cliente (String nome) {
			super (nome); 
	      	cont = getContentPane();   
	      	cont.setLayout(new BorderLayout());
	      	
	      	panelNum = new JPanel(new GridLayout(4,1,2,2)); 
	      	panelOp = new JPanel(new GridLayout(6,1,1,1));
	      	
			textField1 = new JTextField( 30 );
			textField1.setText("localhost");
			textField2 = new JTextField( 10 );
			textField2.setText("10303");
			conectaServer = new JButton("Conecta no servidor");
			closeServer = new JButton("Desconecta");
		    buttons = new JButton[ 10 ]; 
		    panelOp.add( textField1 );
			panelOp.add( textField2 );
			panelOp.add( conectaServer );
			panelOp.add( closeServer );
		        
			conectaServer.addActionListener( this );
			
		    for ( int count = 1 ; count < 10; count++ ) {
		    	buttons[ count ] = new JButton( new Integer(count).toString() );
		    	buttons[ count ].addActionListener( this );
		    	panelNum.add(buttons[ count ]);
		    }
		    
		    panelNum.setBackground(Color.BLACK);
		    cont.add(panelNum, BorderLayout.CENTER);    
		    cont.add(panelOp, BorderLayout.NORTH);
	}
	
	public void actionPerformed( ActionEvent e ) {
			try{
	    	   	 for ( int count = 1 ; count < 10; count++ ) {
	        		 	if (e.getSource() == buttons[ count ]){
	        		 		buttons[ count ].setText("X");
	        		 		buttons[count].setEnabled(false);
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
	    	         JOptionPane.showMessageDialog(null, "Servidor Desconectado");
	    	         System.out.println(exception); 
	       	}
	 }
	public void a(){
		
	}
	public static void main(String[] args) {
		Cliente servidor = new Cliente("Servidor"); 
		servidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		servidor.setSize(300,400);
		servidor.setVisible(true);

    }
}