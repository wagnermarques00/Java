package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recoverConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/virtual_store?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "123456";

		return DriverManager.getConnection(url, user, password);
	}
}
