
import javax.swing.JOptionPane;

public class ListaEncadeada {

	public static void main(String[] args) {
		Item firstItem = null, currentItem = null, tempItem = null, showItem;
		String opcaoStr, nomeExc;
		int opcao;
		try{
		do {
			opcaoStr = JOptionPane.showInputDialog("O que voce quer fazer: \n1 - Incluir\n2 - Excluir\n3 - Mostrar\n9 - Sair");
			opcao = Integer.parseInt(opcaoStr);
		
			if (opcao == 1) {
				System.out.println("Incluir: " + Item.quant);
				tempItem = new Item();
				tempItem.add();
				if(tempItem.getIdade()>=18 && tempItem.getTamanhoNome()<31){
					if(Item.quant == 0){
						currentItem = firstItem = tempItem;
						tempItem.proximo = null;
					}
					else {
						currentItem.proximo = tempItem;
						currentItem = tempItem;
						currentItem.proximo = null;
					}
					Item.quant++;
				}
				else{
					JOptionPane.showMessageDialog(null,"Idade < 18 e nome > 30 não serão cadastrados.","Atenção",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
			else if (opcao == 2) {
				nomeExc = JOptionPane.showInputDialog("Nome para exclusão:");
				showItem = null;
				currentItem = firstItem;
				while((currentItem != null) && !(currentItem.comparanome(nomeExc))){
					showItem = currentItem;
					currentItem = currentItem.proximo;
				}
				if(currentItem == null){
					JOptionPane.showMessageDialog(null,"Nada foi excluido","Atenção",
						    JOptionPane.WARNING_MESSAGE);
				}
				if(showItem == null){
					firstItem = currentItem.proximo;
				}
				else{
					JOptionPane.showMessageDialog(null,nomeExc+" foi excluido", "parabens", JOptionPane.INFORMATION_MESSAGE);
					showItem.proximo = currentItem.proximo;
				}
				//usar o mesmo loop do mostrar
				//cuidar o primeiro item
				//fazer controle de idade
				//cadastrar maior ou igual que 18
				//fazer controle de nome (maximo 30 caracteres)
				//mudar (item.quant == 0) na inclusão
			}
			else if (opcao == 3) {
				System.out.println("Mostrar");
				showItem = firstItem;
				while(showItem != null){
					showItem.Mostrar();
					showItem = showItem.proximo;
				}
			}
			else {
				System.out.println("Sair");
				System.exit(0);
			}

		} while(true);
		}
		catch (NumberFormatException event){
				JOptionPane.showMessageDialog(null,"FIM!!!!!!","Atenção", JOptionPane.WARNING_MESSAGE);
			}
	}
}