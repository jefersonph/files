public class ThreadExemplo extends Thread { 
	static private int var_static;
	private int var;
	private String nome;
	
	public ThreadExemplo (String nome) {
		this.nome = nome;
	}
	
	
	public void run() {
        TerceiraClasse ex = new TerceiraClasse(nome); 
		
		for (int i=0; i<5 ; i++) { 
           	var_static++;
           	var++;
           	ex.incrementa();
        } 
		
		System.out.println(nome + " Thread classe var: " + var);
		System.out.println(nome + " Thread classe var_static: " + var_static);
        
	}

}
