public class TerceiraClasse {
	static private int var_static;
	private int var;
	private String nome;
	
	public TerceiraClasse (String nome) {
		this.nome = nome;
	}
	
	void incrementa (){
		int var_metodo = 0;
		
		var++;
		var_static++;
		var_metodo++;
		
		System.out.println(nome + " Terceira classe var: " + var);
		System.out.println(nome + " Terceira classe var_static: " + var_static);
		System.out.println(nome + " Terceira classe var_metodo: " + var_metodo);
		
	}
}
