package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recoverConnection() {
		final String DB_URL = "jdbc:mysql://localhost:3306/byte_bank?user=root&password=123456";

		try {
			return DriverManager.getConnection(DB_URL);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
