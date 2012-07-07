import java.io.*;
public class Arquivos2 {


	public static void main(String[] args) throws IOException {
		File f = new File("teste.txt");
		String s;
		BufferedReader inFile = new BufferedReader(new FileReader(f));
		while(( s = inFile.readLine()) != null){
			 System.out.println(s);
		}
	inFile.close();	
	}

}
