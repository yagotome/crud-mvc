package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionFactory {	
	public Connection getConnection() {
		try {
			Logger.getGlobal().info("Conexão aberta");
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection( "jdbc:mysql://localhost:3306/bd_pessoa", "development", "yagotome");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro de conexão.");
		}
	}
}
