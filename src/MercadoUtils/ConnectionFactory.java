package MercadoUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3307/bdmercado?autoReconnect=true&useSSL=false";
			String login = "root";
			String senha = "";
			return DriverManager.getConnection(url, login, senha);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}