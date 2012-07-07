public class Item {

	public static int quant = 0; 
	
	private int idade;
	private String nome;
	
	public Item proximo, anterior;
	
	public void adicionar (String nome, int idade) {
			this.nome = nome;
			this.idade = idade;
	}
	
	public void mostrar () {
		System.out.println("Nome: " + nome + "\nIdade: " + idade);
	}
	
	public boolean comparaNome (String nomeComp) {
		if (nomeComp.compareToIgnoreCase(nome) == 0)
			return true;
		else
			return false;
	}
	
	public int getIdade () {
		return idade;
	}
	
	public String getNome () {
		return nome;		
	}
	
}
