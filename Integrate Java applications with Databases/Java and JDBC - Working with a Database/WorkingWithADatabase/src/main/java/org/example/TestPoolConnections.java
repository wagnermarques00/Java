package org.example;

import org.example.factory.ConnectionFactory;

import java.sql.SQLException;

public class TestPoolConnections {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		for(int i = 0; i < 20; i++) {
			connectionFactory.recoverConnection();
			System.out.println("Connection number: " + (i + 1));
		}
	}
}
