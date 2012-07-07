
import javax.swing.JOptionPane;
import java.lang.*;

public class Item {
	public static int quant = 0; 
	private int idade;
	private String nome;
	public Item proximo;
	
	public Item () {}
	public void add () {
		nome = JOptionPane.showInputDialog("Digite o nome");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
	}
	
	public void Mostrar () {
		System.out.println("Nome: "+ nome);
		System.out.println("Idade: "+ idade);
	}
	
	public int getIdade () {
		return this.idade;
	}
	
	public int getTamanhoNome () {
		return this.nome.length();
	}
	
	public boolean comparanome(String nomeComp){
		if(nomeComp.compareToIgnoreCase(nome)==0){
			return true;
		}
		else{
			return false;
		}
	}
}