import java.io.*;
public class lerObjeto {

			public static void main(String[] args) {
		   try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("objeto.txt"));
			Aluno alunos;
			alunos = (Aluno) in.readObject();
			alunos.mostrarAluno();
			alunos = (Aluno) in.readObject();
			alunos.mostrarAluno();
			in.close();
		   }


		   catch (ClassNotFoundException exception){
				System.out.println("Classe nao encontrada: " + exception);
			  }
		   catch (IOException exception){
				System.out.println("Erro de I/O: " + exception);
			  }
			}	
			
}