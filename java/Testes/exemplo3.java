import java.io.*;
public class exemplo3 {
	   public static void main(String[] args) {
		try {
		   File file = new File("arqTextS1.txt");
		   BufferedWriter outFile = new BufferedWriter(new FileWriter(file));
		   outFile.write("Escrever no arquivo:");
		   outFile.newLine();
		   outFile.write("Disciplina de Linguagem de Programação OO I");
		   outFile.newLine();
		   outFile.write("ULBRA");
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
