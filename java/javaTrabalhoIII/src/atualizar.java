import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JEFERSON PIZZOLATO HOMEM
//JOSE DIEGO FRAGA
public class atualizar {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/test";	    

	public atualizar(int num_ , float valor_){
		int num = num_;
		float valor = valor_;
		Connection connection = null; 
		Statement statement = null; 

		try {
			Class.forName( JDBC_DRIVER );
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			System.out.println("Conectado: " + connection);
			statement = connection.createStatement();
			statement.executeUpdate("update fatura set valor=" +valor_+ "where numero=" + num_);

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
