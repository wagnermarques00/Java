package org.example.dao;

import org.example.model.Category;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

	private Connection connection;

	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Category> list() throws SQLException {
		String selectStatement = "SELECT id, name FROM category";
		List<Category> categories = new ArrayList<>();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
		try (preparedStatement) {
			preparedStatement.execute();

			ResultSet resultSet = preparedStatement.getResultSet();
			try (resultSet) {
				while (resultSet.next()) {
					Integer id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					Category category = new Category(id, name);

					categories.add(category);
				}
			}
		}
		return categories;
	}

	public List<Category> listWithProducts() throws SQLException {
		String selectStatement = "SELECT C.id, C.name, P.id, P.name, P.description FROM category C INNER JOIN product P ON C.id = P.category_id";
		Category lastCategory = null;
		List<Category> categories = new ArrayList<>();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
		try (preparedStatement) {
			preparedStatement.execute();

			ResultSet resultSet = preparedStatement.getResultSet();
			try (resultSet) {
				while (resultSet.next()) {
					if (lastCategory == null || !lastCategory.getName().equals(resultSet.getString(2))) {
						Integer categoryId = resultSet.getInt(1);
						String categoryName = resultSet.getString(2);
						Category category = new Category(categoryId, categoryName);

						categories.add(category);
						lastCategory = category;
					}
					Integer productId = resultSet.getInt(3);
					String productName = resultSet.getString(4);
					String productDescription = resultSet.getString(5);
					Product product = new Product(productId, productName, productDescription);

					lastCategory.addProduct(product);
				}
			}
			return categories;
		}
	}
}
