package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost/virtual_store?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "123456";
		String message = "Successful connection, {user: %s, password: %s}. Closing connection...";

		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.printf(message, user, password);

		connection.close();
	}
}
