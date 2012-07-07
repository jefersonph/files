import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

import com.mysql.jdbc.exceptions.jdbc4.*;

//JEFERSON PIZZOLATO HOMEM
//JOSE DIEGO FRAGA

public class TesteInsert {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/test";	    

	public TesteInsert(String nome_, int num_ , float valor_){
		String nome = nome_;
		int num = num_;
		float valor = valor_;
		Connection connection = null; // Gerencia a conexao
		Statement statement = null; // instrucao SQL

		// Conecta ao banco de dados test
		try {

			// Carrega a classe de driver do banco de dados
			Class.forName( JDBC_DRIVER );

			// Estabelece a conexao com o banco de dados
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
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
