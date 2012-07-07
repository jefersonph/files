import java.io.*;
public class exemplo6 {
	public static void main(String[] args) {
	   try {
		FileInputStream inFile = new FileInputStream("arqBinario1.dat");
		DataInputStream in = new DataInputStream(inFile);
		int inteiro;
		while (true){
		   inteiro = in.readInt();
		   System.out.println(inteiro);
		}
		//inFile.close(); - unreachable code
	   }
	   catch (FileNotFoundException exception){
			System.out.println("Arquivo nao encontrado.");
		   }
		   catch (EOFException exception){
			System.out.println("Fim normal do arquivo.");
		   }
		   catch (IOException exception){
			System.out.println("Erro de I/O: " + exception);
		   }
	   }
	}
