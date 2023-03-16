package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestRemoval {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();

		Statement statement = connection.createStatement();
		String deleteProduct = "DELETE FROM product WHERE id > 1";
		statement.execute(deleteProduct);

		Integer modifiedRows = statement.getUpdateCount();
		System.out.println("Number of rows modified: " + modifiedRows);

		connection.close();
	}
}
