import java.io.*;
public class exemplo4 {
	public static void main(String[] args) {
	   try {
	      File file = new File("arqTextS2.txt");
	      PrintWriter outFile = new PrintWriter(new FileWriter(file));
	      outFile.println("Escrever no arquivo:");
	      outFile.println("Disciplina de Linguagem de Programação OO I");
	      outFile.println("ULBRA");
	      outFile.close();
	   }
	   catch (FileNotFoundException exception){
	      System.out.println("Arquivo nao encontrado.");
	   }
	   catch (IOException exception){
	      System.out.println("Erro de I/O: " + exception);
	   }
   }
}
