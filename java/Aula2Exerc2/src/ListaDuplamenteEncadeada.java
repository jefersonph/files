
import javax.swing.JOptionPane;

public class ListaDuplamenteEncadeada extends ListaEncadeada {

	private Item retornaItem (int idade){
		Item searchItem = firstItem;
		
		while ( (searchItem.proximo != null) && (idade > searchItem.proximo.getIdade() ) ) 
			searchItem = searchItem.proximo;
		
		System.out.println("Nome e idade " + searchItem.getNome() + "  " + searchItem.getIdade());
		
		return searchItem;
	}
	
	private void mostrarDec(){
		Item searchItem = firstItem;

		System.out.println("-------------------------");
		
		// Existe uma maneira mais inteligente de se fazer isto
		while (searchItem.proximo != null)
			searchItem = searchItem.proximo;

		//System.out.println("Nome e idade " + searchItem.getNome() + "  " + searchItem.getIdade());

		while (searchItem != null) {
			searchItem.mostrar();
			searchItem = searchItem.anterior;
		}
	}
	
	public void mostrar () {
		String opcaoStr = JOptionPane.showInputDialog("Em ordem:\n1 - Crescente\n2 - Decrescente\n");
		int opcao = Integer.parseInt(opcaoStr);
		
		if (opcao == 1)
			super.mostrar();
		else
			mostrarDec();
		
	}
	
	public void incluir(String nome, int idade) {
		System.out.println("Incluir: " + Item.quant);
		tempItem = new Item();
		tempItem.adicionar(nome, idade);
		
		if (Item.quant == 0){
			currentItem = firstItem = tempItem;
			currentItem.anterior = null;
			currentItem.proximo = null;
		}
		else if (firstItem.getIdade() > tempItem.getIdade() ) { // Significa que a idade é menor que o primeiro item
			tempItem.anterior = null;
			tempItem.proximo = firstItem;
			firstItem.anterior = tempItem;
			firstItem = tempItem;
			System.out.println("aqui");
		}
		else { // Procura onde colocar a idade
			currentItem = retornaItem(idade);
			
			tempItem.anterior = currentItem;
			tempItem.proximo = currentItem.proximo;
			currentItem.proximo = tempItem;
			if (tempItem.proximo != null)//responder para que serve este if 
										 //quando entregar o trablaho
				tempItem.proximo.anterior = tempItem;
			
		}
		tempItem.mostrar();
		Item.quant++;
	}

}
