import java.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Teste {

	public static void main(String[] args) {
		String nome;
		int nota=0;
		int qtd=0;
		int media=0;
		double soma=0;
		double por =0;
		
		Scanner sc = new Scanner(System.in);
		ArrayList a = new ArrayList();
		System.out.println("Digite a qtd de alunos:");
		qtd = sc.nextInt();
		System.out.println("Digite a media de aprovacao:");
		media = sc.nextInt();
		
		for(int i=0; i < qtd; i++){
			System.out.println("nome");
			nome = sc.next();
			System.out.println("nota");
			nota = sc.nextInt();
			Aluno dados= new Aluno(nome, nota);
			a.add(dados);
		}
		System.out.println("");
		System.out.println("Dados dos Alunos Aprovados");
		for (int i=0; i < a.size(); i++ ){
		    Aluno a1 = (Aluno)a.get(i);
		    if(a1.notaAluno >= media){
		    System.out.println("Nome: " + a1.nomeAluno );
		    System.out.println("Nota: " + a1.notaAluno );
		    }
		}
		System.out.println("");
		System.out.println("Dados dos Alunos Reprovados");
		for (int i=0; i < a.size(); i++ ){
		    Aluno r1 = (Aluno)a.get(i);
		    if(r1.notaAluno < media){
		    System.out.println("Nome: " + r1.nomeAluno );
		    System.out.println("Nota: " + r1.notaAluno );
		    }
		}
		//
		System.out.println("");
		System.out.println("Media dos Alunos");
		for (int i=0; i < a.size(); i++){
			 Aluno m1 = (Aluno)a.get(i);
			 soma = soma + m1.notaAluno;
		}
		System.out.println("Media: " + soma/qtd);
		
		System.out.println("");
		System.out.println("Media dos Alunos");
		for (int i=0; i < a.size(); i++){
			 Aluno po1 = (Aluno)a.get(i);
			 if(po1.notaAluno >= media){
				 por ++;
			 }
		}
		System.out.println("Porcentagem de Aprovados: " + por / qtd *100);
		
	}

}
