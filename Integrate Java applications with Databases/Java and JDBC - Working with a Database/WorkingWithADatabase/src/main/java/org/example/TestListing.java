package org.example;

import org.example.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestListing {

	public static void main(String[] args) throws SQLException {
		String selectAllProducts = "SELECT id, name, description FROM product";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();

		PreparedStatement statement = connection.prepareStatement(selectAllProducts);
		statement.execute();

		ResultSet resultSet = statement.getResultSet();

		while(resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");
			System.out.println(id + " " + name + " " + description);
		}

		connection.close();
	}
}
