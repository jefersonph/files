import java.sql.*;
import java.util.*;

public class TestaPreparedStatementInsert {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://10.225.14.175/test";
	
	public static void main(String[] args) {
		
		Connection connection = null; // Gerencia a conexao
		PreparedStatement statement = null; // Instru??o SQL
		Scanner keyboard = new Scanner(System.in);
		
		// Busca os dados do usuario
		System.out.print("Nome:");
		String nome = keyboard.nextLine();
		System.out.print("Endere?o:");
		String endereco = keyboard.nextLine();
		System.out.print("Telefone:");
		String telefone = keyboard.nextLine();
		System.out.print("idade:");
		int idade = keyboard.nextInt();
		
		// Conecta ao banco de dados test
		try {
			// Carrega a classe de driver do banco de dados
			Class.forName( JDBC_DRIVER );
			
			// Estabelece a conexao com o banco de dados
			connection = DriverManager.getConnection( DATABASE_URL, "test", "test");
			System.out.println("Conectado: " + connection);

			// Cria PreparedStatement para insercao
			statement = connection.prepareStatement("insert into cliente (nome, endereco, telefone, idade) value (?, ?, ?, ?)");
			
			// Define o valor dos parametros
			statement.setString(1, nome);
			statement.setString(2, endereco);
			statement.setString(3, telefone);
			statement.setInt(4, idade);
			
			// Consulta o banco de dados
			statement.execute();
			
		} catch (ClassNotFoundException classNotFound){
			System.out.println("Driver nao foi encontrado");
			classNotFound.printStackTrace();
		} catch (SQLException sqlException) {
			System.out.println("Erro na conexao");
			sqlException.printStackTrace();
		}
		
		finally { // Assegura que a conexao ? fechada adequadamente
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
