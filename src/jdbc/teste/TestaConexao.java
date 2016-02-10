package jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		Connection cn = ConnectionFactory.getConnection();
		System.out.println("Conex�o aberta.");
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Conex�o fechada.");
	}

}
