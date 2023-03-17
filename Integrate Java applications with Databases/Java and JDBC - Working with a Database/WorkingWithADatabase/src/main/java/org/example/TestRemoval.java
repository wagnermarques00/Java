package org.example;

import org.example.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestRemoval {

	public static void main(String[] args) throws SQLException {
		String deleteProduct = "DELETE FROM product WHERE id > ?";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();

		PreparedStatement statement = connection.prepareStatement(deleteProduct);
		statement.setInt(1, 1);
		statement.execute();

		Integer modifiedRows = statement.getUpdateCount();
		System.out.println("Number of rows modified: " + modifiedRows);

		connection.close();
	}
}
