
public class Aluno {
	String nomeAluno;
	int notaAluno;
	public Aluno(String nome, int nota){
		this.nomeAluno=nome;
		this.notaAluno=nota;
		
	}
	public Aluno(){
		
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public int getNotaAluno() {
		return notaAluno;
	}
	public void setNotaAluno(int notaAluno) {
		this.notaAluno = notaAluno;
	}

}

