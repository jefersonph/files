import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class TesteInsert {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://10.1.0.237/test";

	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 ArrayList a = new ArrayList();
		 String nome;
		 int num;
		 float valor;
		
		Connection connection = null; // Gerencia a conexao
		Statement statement = null; // instrucao SQL
	
		// Conecta ao banco de dados test
		try {
			
			System.out.println("Digite numero:");
			num = sc.nextInt();
			System.out.println("Digite nome:");
			nome = sc.next();
			System.out.println("Digite valor:");
			valor = sc.nextFloat();
			
			// Carrega a classe de driver do banco de dados
			Class.forName( JDBC_DRIVER );
			
			// Estabelece a conexao com o banco de dados
			connection = DriverManager.getConnection("jdbc:mysql://10.1.0.237/test", "test", "test");
			System.out.println("Conectado: " + connection);

			// Cria statement para inclusao
			statement = connection.createStatement();
			
			// Realiza a inclus?o //\"Tales\"
			statement.executeUpdate("insert into fatura (numero, nome, valor) values ( "+num+",\""+nome+"\","+valor+")");
			
			
			
		} catch (ClassNotFoundException classNotFound){
			System.out.println("Driver nao foi encontrado");
			classNotFound.printStackTrace();
		} catch (SQLException sqlException) {
			System.out.println("Erro na conexao");
			sqlException.printStackTrace();
		}
		
		finally { // Assegura que a conexao  fechada adequadamente
			try {
				connection.close();
				statement.close();
			}
			catch (Exception e){
				System.out.println("Erro durante fechamento da conexao");
				e.printStackTrace();
				System.exit(1);
			}
		}

	}

}
