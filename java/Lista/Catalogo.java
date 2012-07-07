import javax.swing.JOptionPane;

public class Catalogo {

	public static void main(String[] args) {
		ListaDuplamenteEncadeada Lista = new ListaDuplamenteEncadeada();
		String opcaoStr, nomeExc, nome;
		int opcao;
		
		do {
			opcaoStr = JOptionPane.showInputDialog("O que voce quer fazer:\n1 - Incluir\n2 - Excluir\n3 - Mostrar\n9 - Sair");
			
			opcao = Integer.parseInt(opcaoStr);
				if (opcao == 1) {
					nome = JOptionPane.showInputDialog("Digite o nome");
					int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
					Lista.incluir(nome, idade);
				}
				else if (opcao == 2) {
					nomeExc = JOptionPane.showInputDialog("Digite o nome a ser excluido");
					Lista.excluir(nomeExc);
				}
				else if (opcao == 3) {
					Lista.mostrar();
				}
				else {
					System.out.println("Sair");
					System.exit(0);
				}
			

		} while(true);

	}
}
