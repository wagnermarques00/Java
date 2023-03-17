package org.example;

import org.example.factory.ConnectionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;


import static org.junit.Assert.assertNotNull;

public class TestConnection {
	private static final Logger LOGGER = Logger.getLogger(TestConnection.class.getName());

	@Test
	public void testConnection() throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();
		String message = "Successful connection.";

		assertNotNull(connection);
		LOGGER.info(String.format(message));

		connection.close();
	}
}
