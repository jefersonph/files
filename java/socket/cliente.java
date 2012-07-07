import java.io.*;
import java.net.*;
import java.util.*;

public class cliente
{
   public static void main(String[] args)
   {
      try
      {
         Socket s = new Socket("localhost", 8000);
         try
         {
           OutputStream outStream = s.getOutputStream();
           PrintWriter out = new PrintWriter(outStream, true);
           
           out.println("BLACK");
         
         
         }
         finally
         {
            s.close();
         }
      }
      catch (IOException e)
      { e.printStackTrace(); } } }
