package connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	private static String URL = "jdbc:mysql://localhost:3306/edios";
	private static String USUARIO = "root";
	private static String SENHA = "91336757";
	

	
public static Connection createConnectionMySQL() throws Exception{

	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
	
	return connection;
}

public static void main(String [] args) throws Exception {
	
	Connection con = createConnectionMySQL();
	
	if (con != null) {
		System.out.println(con + "\n\n ****  Conexao obtida com sucesso!  ****");
	}
}
}