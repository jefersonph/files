import java.io.*;
public class exemplo2 {
	public static void main(String[] args) {
	   try {
	      File file = new File("arqTexto.txt");
	      BufferedReader inFile = new BufferedReader(new FileReader(file));
	      int c;
	      while ((c=inFile.read()) != -1){
		   System.out.println((char)c + " - " + c);
		 }
		 inFile.close();
	   }
	   catch (FileNotFoundException exception){
		System.out.println("Arquivo nao encontrado.");
	   }
	   catch (IOException exception){
		System.out.println("Erro de I/O: " + exception);
	   }		
	}
}
