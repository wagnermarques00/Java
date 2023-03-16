package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestListing {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();

		Statement statement = connection.createStatement();
		statement.execute("SELECT id, name, description FROM product");

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
