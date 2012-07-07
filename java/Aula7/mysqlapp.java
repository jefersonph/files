 //1: Importar o package
import java.sql.*;


class mysqlapp
{
public static void main(String[] args)
{
System.out.println("JDBC-MySQL Conexão");


try{
//2: Registrar o driver JDBC
System.out.println("2: Registrando o driver JDBC…");
Class.forName("com.mysql.jdbc.Driver").newInstance();


//3: Estabelecer uma conexão
System.out.println("3: Conectando ao banco de dados…");
String jdbcUrl = "jdbc:mysql://caconote:3306/exemplo";
String usuario = "root";
String senha = "root";
Connection conn = DriverManager.getConnection(jdbcUrl, usuario, senha);


//4: Fazendo uma consulta
System.out.println("4: Fazendo a consulta ao banco de dados…");
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("select nome, idade from pessoas");


//5: Exibindo os dados do ResultSet
System.out.println("5: Exibindo os registros da consulta…");
while (rs.next()){
System.out.println("——————————–");
System.out.println("Usuário: " + rs.getString("nome"));
System.out.println("Idade: " + rs.getInt("idade"));
}
System.out.println("——————————–");

Statement stExec = conn.createStatement();
stExec.executeUpdate("insert into pessoas(nome,idade) values('Gilberto', 30)");
stExec.close();

System.out.println("4: Fazendo a consulta ao banco de dados…");
rs = st.executeQuery("select nome, idade from pessoas");

System.out.println("5: Exibindo os registros da consulta NOVAMENTE");
while (rs.next()){
System.out.println("——————————–");
System.out.println("Usuário: " + rs.getString("nome"));
System.out.println("Idade: " + rs.getInt("idade"));
}
System.out.println("——————————–");


//6: Limpando o ambiente criado
System.out.println("6: Limpando o ambiente criado…");
rs.close();
st.close();
conn.close();
} catch(Exception ex){
ex.printStackTrace();
//handle error
}
}
}

