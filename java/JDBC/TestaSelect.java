import java.sql.*;

public class TestaSelect {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://10.1.0.237/test";
	
	public static void main(String[] args) {
		
		Connection connection = null; // Gerencia a conexao
		Statement statement = null; // instrucao SQL
		
		// Conecta ao banco de dados test
		try {
			// Carrega a classe de driver do banco de dados
			Class.forName( JDBC_DRIVER );
			
			// Estabelece a conexao com o banco de dados
			connection = DriverManager.getConnection("jdbc:mysql://10.1.0.237/test", "test", "test");
			System.out.println("Conectado: " + connection);

			// Cria statement para Consulta
			statement = connection.createStatement();
			
			// Consulta o banco de dados
			ResultSet resultSet = statement.executeQuery("select * from fatura");
			
			// Imprime as colunas
			while (resultSet.next()){
				System.out.println("Numero: "+resultSet.getInt("numero"));
				System.out.println("Nome: "+resultSet.getString("nome"));
				System.out.println("Valor: "+resultSet.getInt("valor"));
				System.out.println();
			}
			
			
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
