package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static final String url = "jdbc:mysql://localhost:3306/edios?verifyServerCertificate=false&useSSL=true";
	private static final String usuario = "root";
	private static final String senha = "Agcap@2022";

	
	public static Connection createConnectionToMySQL() throws Exception{
		Connection connection = DriverManager.getConnection(url, usuario, senha);
		return  connection;
	}
}