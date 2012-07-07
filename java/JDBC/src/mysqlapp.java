import java.sql.*;
import javax.swing.*;    

class mysqlapp
{
public static void main(String[] args)
{
try{

System.out.println("2: Registrando o driver JDBC…");
Class.forName("com.mysql.jdbc.Driver").newInstance();

System.out.println("3: Conectando ao banco de dados…");
String jdbcUrl = "jdbc:mysql://localhost:3306/aula";
String usuario = "root";
String senha = "";
Connection conn = DriverManager.getConnection(jdbcUrl, usuario, senha);

do {
	String opcaoStr = JOptionPane.showInputDialog("O que voce quer fazer:\n1 - Incluir\n2 - Excluir\n3 - Mostrar\n9 - Sair");
	
	int opcao = Integer.parseInt(opcaoStr);
		if (opcao == 1) {
			String nome = JOptionPane.showInputDialog("Digite o nome");
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
			Statement stExec = conn.createStatement();
			stExec.executeUpdate("insert into dados(nome,idade) values('"+nome+"' , '"+idade+"')");
			stExec.close();
		}
		else if (opcao == 2) {
			String nomeExc = JOptionPane.showInputDialog("Digite o nome a ser excluido!");
			Statement stExec = conn.createStatement();
			stExec.executeUpdate("DELETE FROM dados WHERE nome = '"+nomeExc+"'");
			stExec.close();
		}
		else if (opcao == 3) {
			String opcaoStr1 = JOptionPane.showInputDialog("O que voce quer fazer:\n1 - Decrescente\n2 - Crescente\n9 - Sair");
			int opcao1 = Integer.parseInt(opcaoStr1);
			if (opcao1 == 1){
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select nome, idade from dados ORDER BY nome DESC ");
				while (rs.next()){
					System.out.println("Usuário: " + rs.getString("nome"));
					System.out.println("Idade: " + rs.getInt("idade"));
				}
			}
			else if (opcao1 == 2) {
		        Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select nome, idade from dados ORDER BY nome ASC ");
				while (rs.next()){
					System.out.println("Usuário: " + rs.getString("nome"));
					System.out.println("Idade: " + rs.getInt("idade"));
				}
			}
			else{
				System.exit(0);
			}
		}
		else {
			System.exit(0);
		}
} while(true);
		
} catch(Exception ex){
ex.printStackTrace();
}
  }
}