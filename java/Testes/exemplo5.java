import java.io.*;
public class exemplo5 {
	public static void main(String[] args) {
	   try {
		FileOutputStream outFile = new FileOutputStream("arqBinario1.dat");
		DataOutputStream out = new DataOutputStream(outFile);
		for(int i=0;i<10;i++){
		   out.writeInt(i);
		}
		outFile.close();
	   }
	   catch (IOException exception){
		System.out.println("Erro de I/O: " + exception);
	   }
   }
}
