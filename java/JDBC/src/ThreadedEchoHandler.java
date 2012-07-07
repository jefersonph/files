import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ThreadedEchoHandler extends JFrame implements Runnable
{
	private Socket incoming;
	private CubbyHole ch;
	private int conNumber;
    boolean done = false;
    OutputStream outStream;
    PrintWriter out;
    private JFrame frame;
    private Container cont;
    private JPanel panelNum;
    private JTextField textField1;
    private JButton buttons[]; // Botoes 1-9

    
   public ThreadedEchoHandler(Socket i, CubbyHole c, int conexao)
   {
      incoming = i;
      ch = c;
      conNumber = conexao;
   }
   

   class StartFrame implements ActionListener {
       
	  public void actionPerformed( ActionEvent event )
	  { 
		  
    /*
      frame = new JFrame("servidor " + conNumber);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300,300);
      frame.setVisible(true);
    */
	  }
	  public void teste(){
		 /* buttons = new JButton[ 10 ]; // set size of array
		    
	      	cont = getContentPane();   
	      	cont.setLayout(new BorderLayout());
	      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        cont.setSize(300,400);
	        cont.setVisible(true);
	        
	      	panelNum = new JPanel(new GridLayout(4,1,2,2)); 
		
		    for ( int count = 1 ; count < 10; count++ )
		    {
		    	buttons[ count ] = new JButton( new Integer(count).toString() );
		    	buttons[ count ].addActionListener( this );
		    	panelNum.add(buttons[ count ]);
		    }
		    
		    panelNum.setBackground(Color.BLACK);
		    
		    cont.add(panelNum, BorderLayout.CENTER); 
		    */
	      frame = new JFrame("servidor " + conNumber);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setSize(300,300);
	      frame.setVisible(true);
		     
	  }
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
      try
      {
    	  
    	  StartFrame teste = new StartFrame();
    	  teste.teste();
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
