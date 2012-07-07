import java.awt.*;		
import java.awt.event.*;		
import javax.swing.*;		

public class CalculadoraTeste {		

public static void main(String[	] args)	{

CalculadoraFrame frame = new CalculadoraFrame();
frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
frame.setVisible( true );		
		}		
	
	}		

class CalculadoraFrame extends JFrame{	

public CalculadoraFrame(){		

	setTitle("Calculadora");		
	CalculadoraPanel panel = new CalculadoraPanel();
	add( panel );		
	pack();		
	}		
}		

class CalculadoraPanel extends JPanel{	

public CalculadoraPanel(){		

setLayout( new BorderLayout() );	

result = 0;
lastCommand = "=";		
start = true;		

display = new JButton("0");		
display.setEnabled( false );		
add( display, BorderLayout.NORTH );	

Action insertAction = new InsertAction();
Action commandAction = new CommandAction();

panel = new JPanel();		
panel.setLayout( new GridLayout( 5,	5 ));
addButton("7", insertAction);	
addButton("8", insertAction);
addButton("9", insertAction);
addButton("/", commandAction);

addButton("4", insertAction);
addButton("5", insertAction);
addButton("6", insertAction);
addButton("*", commandAction);

addButton("1", insertAction);
addButton("2", insertAction);
addButton("3", insertAction);
addButton("-", commandAction);

addButton("0", insertAction);
addButton(".", insertAction);
addButton("=", commandAction);	
addButton("+", commandAction);	
addButton("C", commandAction);	
addButton("%", commandAction);
addButton("R", commandAction);

add( panel, BorderLayout.CENTER );

	

InputMap imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT );

imap.put( KeyStroke.getKeyStroke('0'), "panel.0");
imap.put( KeyStroke.getKeyStroke('1'), "panel.0");
imap.put( KeyStroke.getKeyStroke('2'), "panel.2");
imap.put( KeyStroke.getKeyStroke('3'), "panel.3");
imap.put( KeyStroke.getKeyStroke('4'), "panel.4");
imap.put( KeyStroke.getKeyStroke('5'), "panel.5");
imap.put( KeyStroke.getKeyStroke('6'), "panel.6");
imap.put( KeyStroke.getKeyStroke('7'), "panel.7");
imap.put( KeyStroke.getKeyStroke('8'), "panel.8");
imap.put( KeyStroke.getKeyStroke('9'), "panel.9");
imap.put( KeyStroke.getKeyStroke('.'), "panel.ponto");
imap.put( KeyStroke.getKeyStroke('+'), "panel.somar");
imap.put( KeyStroke.getKeyStroke('-'), "panel.subtrair");
imap.put( KeyStroke.getKeyStroke('*'), "panel.multiplicar");
imap.put( KeyStroke.getKeyStroke('/'), "panel.dividir");
imap.put( KeyStroke.getKeyStroke('='), "panel.igual");
imap.put( KeyStroke.getKeyStroke('C'), "panel.C");

ActionMap amap = getActionMap();	

amap.put("panel.0", insertAction );	
amap.put("panel.1", insertAction );	
amap.put("panel.2", insertAction );	
amap.put("panel.3", insertAction );	
amap.put("panel.4", insertAction );	
amap.put("panel.5", insertAction );	
amap.put("panel.6", insertAction );	
amap.put("panel.7", insertAction );	
amap.put("panel.8", insertAction );	
amap.put("panel.9", insertAction );	
amap.put("panel.ponto", insertAction );
amap.put("panel.somar", commandAction );
amap.put("panel.subtrair", commandAction );
amap.put("panel.multiplicar", commandAction );
amap.put("panel.dividir", commandAction );
amap.put("panel.igual", commandAction );

}		

private void addButton( String	label,	ActionListener listener ){

JButton button = new JButton( label );
button.addActionListener( listener);
panel.add( button );		

}		

private class InsertAction extends AbstractAction{

	public void actionPerformed( ActionEvent event ){

		String input = event.getActionCommand();

		if( start )			
		{		
			display.setText("");		
			start = false;		
		}		

		display.setText( display.getText() + input );
	}		
}		

private class CommandAction extends AbstractAction{

	public void actionPerformed(ActionEvent event){

		String command = event.getActionCommand();

		if( start )		
		{		
			if( command.equals("-"))	
			{		
				display.setText(command);	
				start = false;		
			}		
			else		
			{		
				lastCommand = command;	
			}		
		}		
		else		
		{		
			calculate( Double.parseDouble(display.getText()));
			lastCommand = command;		
			start = true;		
			}			
		}		
	}		

public void calculate( double x	){	
	if ( lastCommand.equals("+")	) result += x;
	else if ( lastCommand.equals("-") )result -= x ;
	else if ( lastCommand.equals("C") )result = 0;
	else if ( lastCommand.equals("*") )result *= x ;
	else if ( lastCommand.equals("/") )result /= x ;
	else if ( lastCommand.equals("=") )result = x ;
	else if ( lastCommand.equals( KeyEvent.VK_ENTER ) ) result = x ;
	display.setText(" "+ result);	
}		

private JButton display;	
private JPanel panel;	
private double result;
private String lastCommand;
private boolean start;
}
