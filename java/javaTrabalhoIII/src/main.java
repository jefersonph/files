import java.util.ArrayList;
import java.util.Scanner;

// JEFERSON PIZZOLATO HOMEM
// JOSE DIEGO FRAGA
public class main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList a = new ArrayList();
		String nome;
		int num;
		float valor;
		int op = 1;

		while(op != 0){
			System.out.println("Digite 0 para sair!");
			System.out.println("O que você deseja fazer?:" + '\n' + "1) Inserir:" + '\n' + "2) Listar:" + '\n' + "3) Procurar:" + '\n' + "4) Atualiazar:" + '\n' + "Opcao: ");
			op = sc.nextInt();

			if (op == 1){
				System.out.println("Digite numero:");
				num = sc.nextInt();
				System.out.println("Digite nome:");
				nome = sc.next();
				System.out.println("Digite valor:");
				valor = sc.nextFloat();
				TesteInsert ins = new TesteInsert(nome, num, valor);
			}
			else if(op == 2){
				TestaSelect sel = new TestaSelect();
			}
			else if(op == 3){
				System.out.println("Digite numero para procurar:");
				num = sc.nextInt();
				TestaSelect sel = new TestaSelect(num);
			}
			else if (op == 4){
				System.out.println("Digite numero da fatura:");
				num = sc.nextInt();
				TestaSelect sel = new TestaSelect(num);
				System.out.println("Digite o novo valor da fatura:");
				valor = sc.nextInt();
				atualizar at = new atualizar(num, valor);
			}
		}
	}
}
