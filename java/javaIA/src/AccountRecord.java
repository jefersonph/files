
public class AccountRecord
{
   private double x1, x2, x3, x4;
   private String planta;
   
   public AccountRecord() 
   {
      this( 0.0, 0.0, 0.0, 0.0, " "); 
   } 
   public AccountRecord( double x1, double x2, double x3, double x4, String planta )
   {
      setx1( x1 );
      setx2( x2 );
      setx3( x3 );
      setx4( x4 );
      setplanta( planta );
   } 
  
   public void setx1( double ix1 )
   {
      x1  = ix1;
   } 

   public double getx1() 
   { 
      return x1; 
   } 
   
   public void setx2( double ix2 )
   {
      x2 = ix2;
   } 

  
   public double getx2() 
   { 
      return x2; 
   } 
   
   public void setx3( double ix3 )
   {
      x3 = ix3;
   } 

   public double getx3() 
   {
      return x3; 
   } 
   
   public void setx4( double ix4 )
   {
      x4  = ix4;
   } 

   public double getx4() 
   { 
      return x4; 
   } 
   
   public void setplanta (String iplanta)
   {
	   planta = iplanta;
   }
   
   public String getplanta() 
   { 
      return planta; 
   } 
} 

