import java.sql.*;

public class TestaPreparedStatementSelect {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://10.225.14.175/test";
	
	public static void main(String[] args) {
		
		Connection connection = null; // Gerencia a conexao
		PreparedStatement statement = null; // Instru??o SQL
		
		// Conecta ao banco de dados test
		try {
			// Carrega a classe de driver do banco de dados
			Class.forName( JDBC_DRIVER );
			
			// Estabelece a conexao com o banco de dados
			connection = DriverManager.getConnection( DATABASE_URL, "test", "test");
			System.out.println("Conectado: " + connection);

			// Cria PreparedStatement para consulta
			statement = connection.prepareStatement("select * from cliente where nome = ?");
			
			// Define o valor do primeiro ? para "Tales"
			statement.setString(1, "Tales");
			
			// Consulta o banco de dados
			ResultSet resultSet = statement.executeQuery();
			
			// Imprime as colunas
			while (resultSet.next()){
				System.out.println("Nome: "+resultSet.getString("nome"));
				System.out.println("Endereco: "+resultSet.getString("endereco"));
				System.out.println("Telefone: "+resultSet.getString("telefone"));
				System.out.println("Idade: "+resultSet.getInt("idade"));
				System.out.println();
			}
			
			
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
