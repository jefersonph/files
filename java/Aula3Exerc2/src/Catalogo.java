import javax.swing.JOptionPane;

public class Catalogo {

	public static void main(String[] args) {
		ListaDuplamenteEncadeada Lista = new ListaDuplamenteEncadeada();
		Header header = new Header();
		String opcaoStr, nomeExc, nome;
		int opcao;
		
		do {
			try{
				opcaoStr = JOptionPane.showInputDialog("O que voce quer fazer:\n1 - Incluir\n2 - Excluir\n3 - Mostrar\n4 - Ordem Alfabetica\n9 - Sair");
				
				opcao = Integer.parseInt(opcaoStr);
					if (opcao == 1) {
						nome = JOptionPane.showInputDialog("Digite o nome");
						int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
						Lista.incluir(nome, idade, header);
					}
					else if (opcao == 2) {
						nomeExc = JOptionPane.showInputDialog("Digite o nome a ser excluido");
						if(nomeExc == null){
							nomeExc ="";
						}
						else
							Lista.excluir(nomeExc, header);
					}
					else if (opcao == 3) {
						Lista.mostrar(header);
					}
					else if (opcao == 4) {
						Lista.mostrar(header);
					}
					else {
						throw new NumberFormatException();			
					}
			}
			catch (NumberFormatException event){
				JOptionPane.showMessageDialog(null,"FIM!!!!!!","Atenção", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		} while(true);
	}
}
