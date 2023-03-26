package org.example.dao;

import org.example.model.Category;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	private Connection connection;

	public ProductDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Product product) throws SQLException {
		String insertStatement = "INSERT INTO product (name, description) VALUES (?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

		try(preparedStatement) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());

			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			try(resultSet) {
				while(resultSet.next()) {
					Integer productId = resultSet.getInt(1);
					product.setId(productId);
				}
			}
		}
	}

	public void saveWithCategory(Product product) throws SQLException {
		String insertStatement = "INSERT INTO product (name, description, category_id) VALUES (?, ?, ?)";
		PreparedStatement prepareStatement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

		try(prepareStatement) {
			prepareStatement.setString(1, product.getName());
			prepareStatement.setString(2, product.getDescription());
			prepareStatement.setInt(3, product.getCategoryId());

			prepareStatement.execute();
			ResultSet resultSet = prepareStatement.getGeneratedKeys();

			try(resultSet) {
				while(resultSet.next()) {
					product.setId(resultSet.getInt(1));
				}
			}
		}
	}

	public List<Product> list() throws SQLException {
		List<Product> products = new ArrayList<>();
		String selectStatement = "SELECT id, name, description FROM product";

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

		try(preparedStatement) {
			preparedStatement.execute();

			transformResultSetInProduct(products, preparedStatement);
		}
		return products;
	}

	public List<Product> searchByCategory(Category category) throws SQLException {
		String selectStatement = "SELECT id, name, description FROM product WHERE category_id = ?";
		List<Product> products = new ArrayList<>();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

		try(preparedStatement) {
			preparedStatement.setInt(1, category.getId());
			preparedStatement.execute();

			transformResultSetInProduct(products, preparedStatement);
		}
		return products;
	}

	public void delete(Integer id) throws SQLException {
		String deleteStatement = "DELETE FROM product WHERE id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);

		try(preparedStatement) {
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		}
	}

	public void change(String name, String description, Integer id) throws SQLException {
		String updateStatement = "UPDATE product P SET P.name = ?, P.description = ? WHERE id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
		try(preparedStatement) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, description);
			preparedStatement.setInt(3, id);

			preparedStatement.execute();
		}
	}

	private void transformResultSetInProduct(List<Product> products, PreparedStatement preparedStatement) throws SQLException {
		ResultSet resultSet = preparedStatement.getResultSet();

		try(resultSet) {
			while(resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String description = resultSet.getString(3);
				Product product = new Product(id, name, description);

				products.add(product);
			}
		}
	}
}
