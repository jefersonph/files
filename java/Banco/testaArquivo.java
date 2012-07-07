import java.io.*;
public class testaArquivo {

	public static void main(String[] args) {
		File f1 = new File("dados.txt");
			if(f1.exists()){
				System.out.println(f1.getName());
				System.out.println(f1.getAbsolutePath());
				System.out.println(f1.canWrite());
				System.out.println(f1.canRead());
				f1.setReadOnly();
				System.out.println(f1.canWrite());
				System.out.println(f1.canRead());
				System.out.println(f1.length());
				
			}
			else{
				System.out.println("Arquivo nao existe");
				try{
					f1.createNewFile();
					}
				catch(IOException ep){
					System.out.println("Falhou");
				}
			}
			
	}

}
