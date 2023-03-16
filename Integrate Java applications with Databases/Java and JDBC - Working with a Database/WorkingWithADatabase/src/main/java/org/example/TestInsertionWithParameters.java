package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertionWithParameters {

	public static void main(String[] args) throws SQLException {
		String name = "Mouse'"; // Simulating a possible error without treatment
		String description = "Wireless Mouse";
		String insertProduct = "INSERT INTO product(name, description) VALUES(?, ?)";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();

		PreparedStatement statement = connection.prepareStatement(insertProduct, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, name);
		statement.setString(2, description);

		statement.execute();

		ResultSet resultSet = statement.getGeneratedKeys();
		while(resultSet.next()) {
			Integer id = resultSet.getInt(1);
			System.out.println("The id created in the product table was: " + id);
		}

		connection.close();
	}
}
