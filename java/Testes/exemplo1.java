import java.io.*;
	public class exemplo1 {
	   public static void main(String[] args) {
		try {
		   File file = new File("arqTexto.txt");
		   BufferedReader inFile = new BufferedReader(new FileReader(file));
		   String inputLine;
		   String[] vetor;
		   while ((inputLine=inFile.readLine()) != null){
		      vetor= inputLine.split(",");
			  System.out.println(vetor[0]);
			  System.out.println(vetor[1]);
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
