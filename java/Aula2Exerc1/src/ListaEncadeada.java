
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
					tempItem = new Item();
					tempItem.add();
					if(tempItem.getIdade()>=15 && tempItem.getTamanhoNome()<21){
						if(firstItem == null){
							currentItem = firstItem = tempItem;
							tempItem.proximo = null;
						}
						else {
							currentItem = firstItem;
							tempItem.proximo = currentItem.proximo;
							currentItem.proximo = tempItem;
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"Idade < 15 e nome > 20 não serão cadastrados.","Atenção",
							    JOptionPane.WARNING_MESSAGE);
					}
				}
				else if (opcao == 2) {
					try{
						nomeExc = JOptionPane.showInputDialog("Nome:");
						showItem = null;
						currentItem = firstItem;
						while((currentItem != null) && !(currentItem.comparanome(nomeExc))){
							showItem = currentItem;
							currentItem = currentItem.proximo;
						}
						if(showItem == null){
							firstItem = currentItem.proximo;
						}
						else{
							JOptionPane.showMessageDialog(null,nomeExc+"excluido", "ok", JOptionPane.INFORMATION_MESSAGE);
							showItem.proximo = currentItem.proximo;
						}
						//mudar (item.quant == 0) na inclusão
						}
					catch (NullPointerException event){
						JOptionPane.showMessageDialog(null,"Não Foi excluido","Cuidado",
							    JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if (opcao == 3) {
					if(firstItem == null){
						JOptionPane.showMessageDialog(null,"Lista Vazia","Cuidado",
							    JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						System.out.println("Mostrar");
						showItem = firstItem;
						while(showItem != null){
							showItem.Mostrar();
							showItem = showItem.proximo;
						}
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