import java.sql.*;
//JEFERSON PIZZOLATO HOMEM
//JOSE DIEGO FRAGA

public class TestaSelect {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/test";
	public TestaSelect(int num_){
		Connection connection = null; 
		Statement statement = null; 
		int numero = num_;
		try {

			Class.forName( JDBC_DRIVER );
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			System.out.println("Conectado: " + connection);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from fatura where numero=" + numero);
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
		finally {
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
	public TestaSelect(){

		Connection connection = null; 
		Statement statement = null; 
		try {

			Class.forName( JDBC_DRIVER );
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			System.out.println("Conectado: " + connection);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from fatura");
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
		finally {
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
