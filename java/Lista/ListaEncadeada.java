public class ListaEncadeada {

	protected Item firstItem = null, currentItem = null, tempItem = null, showItem;
	
	public void incluir(String nome, int idade) {
		System.out.println("Incluir: " + Item.quant);
		tempItem = new Item();
		tempItem.adicionar(nome, idade);
		
		if (Item.quant == 0){
			currentItem = firstItem = tempItem;
		}
		else {
			currentItem.proximo = tempItem;
			currentItem = tempItem;
			currentItem.proximo = null;
		}
		currentItem.mostrar();
		Item.quant++;
	}

	/////////////////////////////////////////

	public void excluir (String nomeExc) {

	}

	/////////////////////////////////////////
	
	public void mostrar () {
		System.out.println("Mostrar");
		showItem = firstItem;
		while (showItem != null) {
			showItem.mostrar();
			showItem = showItem.proximo;
		}
	}
	
}

