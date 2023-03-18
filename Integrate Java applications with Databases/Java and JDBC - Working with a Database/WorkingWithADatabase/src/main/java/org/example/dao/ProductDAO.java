package org.example.dao;


import org.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	private final Connection connection;

	public ProductDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Product product) throws SQLException {
		String insertProductStatement = "INSERT INTO product (name, description) VALUES (?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertProductStatement, Statement.RETURN_GENERATED_KEYS);

		try(preparedStatement) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());

			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			try(resultSet) {
				while(resultSet.next()) {
					product.setId(resultSet.getInt(1));
				}
			}
		}
	}

	public List<Product> list() throws SQLException {
		List<Product> products = new ArrayList<Product>();
		String selectStatement = "SELECT id, name, description FROM product";

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
		try(preparedStatement) {
			preparedStatement.execute();

			ResultSet resultSet = preparedStatement.getResultSet();
			try(resultSet) {
				while(resultSet.next()) {
					Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

					products.add(product);
				}
			}
		}
		return products;
	}
}
