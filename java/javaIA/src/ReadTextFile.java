import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ReadTextFile
{
   private Scanner input;

   
   public void openFile()
   {
      try
      {
         input = new Scanner( new File( "iris-dados.data" ) );
      } 
      catch ( FileNotFoundException fileNotFoundException )
      {
         System.err.println( "Error opening file." );
         System.exit( 1 );
      } 
   } 

  
   public void readRecords()
   {
    
      AccountRecord record = new AccountRecord();

      System.out.printf( "%-10s%-10s%-10s%-10s%-20s\n", "X1","X2", "X3", "X4", "PLANTA" );

      try 
      {
         while (input.hasNext())
         {
            record.setx1( input.nextDouble() );
            record.setx2( input.nextDouble() );
            record.setx3( input.nextDouble() );
            record.setx4( input.nextDouble() );
            record.setplanta( input.next() );

            //System.out.printf( "%-1.1f%-1.1f%-1.1f%-1.1f%10s\n", record.getx1(), record.getx2(), record.getx3(), record.getx4(), record.getplanta() );
         } 
      } 
      catch ( NoSuchElementException elementException )
      {
         System.err.println( "File improperly formed." );
         input.close();
         System.exit( 1 );
      } 
      catch ( IllegalStateException stateException )
      {
         System.err.println( "Error reading from file." );
         System.exit( 1 );
      } 
   } 

   public void closeFile()
   {
      if ( input != null )
         input.close(); 
   } 
} 


