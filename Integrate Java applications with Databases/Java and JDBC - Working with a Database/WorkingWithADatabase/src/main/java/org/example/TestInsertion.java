package org.example;

import org.example.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertion {
	public static void main(String[] args) throws SQLException {
		String name = "Mouse";
		String description = "Wireless Mouse";
		String insertProduct = "INSERT INTO product(name, description) VALUES('" + name + "', '" + description + "')";
		System.out.println(insertProduct);

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();

		Statement statement = connection.createStatement();
		statement.execute(insertProduct, Statement.RETURN_GENERATED_KEYS);

		ResultSet resultSet = statement.getGeneratedKeys();
		while(resultSet.next()) {
			Integer id = resultSet.getInt(1);
			System.out.println("The id created in the product table was: " + id);
		}

		connection.close();
	}
}
