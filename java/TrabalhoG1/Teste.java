public class Teste extends Jogador{
    public static void main(String[] args) {
		Jogador jogadores[] = new Jogador[5];
		jogadores[0] = new Jogador("Joao", 90, 32, 179, 2000, 12345);
		jogadores[1] = new Jogador("Joao", 91, 33, 180, 2001, 12346);
		jogadores[2] = new Jogador("Joao", 92, 34, 181, 2002, 12347);
		jogadores[3] = new Jogador("Joao", 93, 35, 182, 2003, 12348);
		jogadores[4] = new Jogador("Joao", 94, 36, 183, 2004, 12349);
			  
		
		for(int i=0 ; i < 5 ; i ++){
			  System.out.println();
			  System.out.println("Jogador " + i);
			  System.out.println("Nome:" + jogadores[i].nome);
			  System.out.println("Peso:" + jogadores[i].peso);
			  System.out.println("Idade:" + jogadores[i].idade);
			  System.out.println("Altura:" + jogadores[i].altura);
			  System.out.println("Salario:" + jogadores[i].salario);
			  System.out.println("CPF:" + jogadores[i].cpf);
	    }
		Time times = new Time("Gremio", 12345678, 322);
		times.mostrarDadosTime();
		
		Tecnico tecnicos = new Tecnico("Tite", 02345, 1567, "A");
		tecnicos.mostrarTecnico();
	    
		Jogos jogo = new Jogos("Sao Paulo", 1234 , "Olimpico");
		jogo.mostrarDadosJogos();
    
    
    
    }
}