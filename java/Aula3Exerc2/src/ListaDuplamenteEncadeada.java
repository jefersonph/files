
import javax.swing.JOptionPane;

public class ListaDuplamenteEncadeada extends ListaEncadeada {
		private Item retornaItem (int idade, Header header){
			Item searchItem = header.inicio;
			while ((searchItem.proximo != null) && (idade > searchItem.proximo.getIdade())) 
				searchItem = searchItem.proximo;
			return searchItem;
		}
		
		private void mostrarDec(Header header){
			Item searchItem = header.fim;
			System.out.println("-------------------------");
			while (searchItem != null) {
				searchItem.mostrar();
				searchItem = searchItem.anterior;
			}
		}
		
		public void mostrar (Header header) {
			String opcaoStr = JOptionPane.showInputDialog("Em ordem:\n1 - Crescente\n2 - Decrescente\n");
			int opcao = Integer.parseInt(opcaoStr);
			
			if (opcao == 1)
				super.mostrar(header);
			else
				mostrarDec(header);
		}
		
		public void incluir(String nome, int idade, Header header) {
			tempItem = new Item();
			tempItem.adicionar(nome, idade);
			/*lista vazia*/
			if (header.fim == null && header.inicio == null){
				tempItem.anterior = null;
				tempItem.proximo = null;
				header.inicio = tempItem;
				header.fim = tempItem;
			}
			else{
				firstItem = header.inicio;
				/*somente 1 elemento na lista*/
				if(firstItem.anterior == null && firstItem.proximo == null){
					if ((firstItem.getIdade() > tempItem.getIdade())){
						tempItem.anterior = null;
						tempItem.proximo = firstItem;
						firstItem.anterior = tempItem;
						firstItem.proximo = null;
						header.inicio = tempItem;
						header.fim = firstItem;
					}
					else{
						tempItem.anterior = firstItem;
						tempItem.proximo = null;
						firstItem.proximo = tempItem;
						header.inicio = firstItem;
						header.fim = tempItem;
					}
				}
				else {
					currentItem = retornaItem(idade, header);
					tempItem.anterior = currentItem;
					tempItem.proximo = currentItem.proximo;
					currentItem.proximo = tempItem;
					if (tempItem.proximo != null){
						tempItem.proximo.anterior = tempItem;
					}
					else{
						header.fim = tempItem;
					}
				}
			}
		}
		
		public void excluir(String nome, Header header) {
			try{
				currentItem = buscaNome(nome, header);
				if(currentItem == null)
					throw new NullPointerException();

				if((currentItem != null) && currentItem.comparaNome(nome)){
					if((currentItem.proximo == null) && (currentItem.anterior == null)){
						header.inicio = null;
						header.fim = null;
					}
					else if((currentItem.proximo == null) && (currentItem.anterior != null)){
						header.fim = currentItem.anterior;
						header.fim.proximo = null;
						currentItem.anterior = null;
						currentItem.proximo  = null;
					}
					else if((currentItem.anterior == null) && (currentItem.proximo != null)){
						header.inicio = currentItem.proximo;
						header.inicio.anterior = null;
						currentItem.anterior = null;
						currentItem.proximo  = null;
					}
					else{
						currentItem.proximo.anterior = currentItem.anterior;
						currentItem.anterior.proximo = currentItem.proximo;
						currentItem.anterior = null;
						currentItem.proximo  = null;
					}
				}
			}catch(NullPointerException event){
				JOptionPane.showMessageDialog(null, nome+"\nNÃO ESTA NA LISTA","Atenção",
					    JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		private Item buscaNome(String nome, Header header){
			Item searchItem = header.inicio;
			while ((searchItem != null) && !(searchItem.comparaNome(nome))) {
				searchItem = searchItem.proximo;
			}
			if(searchItem.comparaNome(nome)){
				return searchItem;
			}else{
				return null;
			}
		}
}
