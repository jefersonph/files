import java.sql.*;

public class TestaConexao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/test";
	
	public static void main(String[] args) {
		
		Connection connection = null; // Gerencia a conexao
		
		// Conecta ao banco de dados test
		try {
			// Carrega a classe de driver do banco de dados
			Class.forName( JDBC_DRIVER );
			
			// Estabelece a conexao com o banco de dados
			connection = DriverManager.getConnection("jdbc:mysql://10.1.0.237/test", "test", "test");
			
			System.out.println("Conectado: " + connection);
			
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
			}
			catch (Exception e){
				System.out.println("Erro durante fechamento da conexao");
				e.printStackTrace();
				System.exit(1);
			}
		}

	}

}
