package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();

		connection.close();
	}
}
