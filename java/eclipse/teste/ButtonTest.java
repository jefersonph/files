import javax.swing.JFrame;

public class ButtonTest
{
   public static void main( String args[] )
   {
      button1 buttonFrame = new button1(); // create ButtonFrame
      buttonFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      buttonFrame.setSize( 275, 110 ); // set frame size
      buttonFrame.setVisible( true ); // display frame
   } // end main
} // end class ButtonTest
