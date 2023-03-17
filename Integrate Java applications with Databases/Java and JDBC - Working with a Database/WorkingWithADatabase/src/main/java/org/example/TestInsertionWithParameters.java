package org.example;

import org.example.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertionWithParameters {

	public static void main(String[] args) throws SQLException {
		String insertProduct = "INSERT INTO product(name, description) VALUES(?, ?)";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();
		connection.setAutoCommit(false);

		try(connection) {
			PreparedStatement statement = connection.prepareStatement(insertProduct, Statement.RETURN_GENERATED_KEYS);

			try(statement) {
				addVariable("SmartTv", "45 inches television", statement);
				addVariable("Smartphone", "Smartphone Samsung", statement);

				connection.commit();
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Rollback executed");

				connection.rollback();
			}
		}
	}

	private static void addVariable(String name, String description, PreparedStatement statement) throws SQLException {
		statement.setString(1, name);
		statement.setString(2, description);

		statement.execute();

		ResultSet resultSet = statement.getGeneratedKeys();

		try(resultSet) {
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				System.out.println("The id created in the product table was: " + id);
			}
		}
	}
}
