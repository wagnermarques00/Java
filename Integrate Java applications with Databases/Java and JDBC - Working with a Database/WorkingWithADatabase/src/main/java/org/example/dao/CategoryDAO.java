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

	private final Connection connection;

	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Category> list() throws SQLException {
		String selectAllCategories = "SELECT id, name FROM category";
		PreparedStatement preparedStatement = connection.prepareStatement(selectAllCategories);
		List<Category> categories = new ArrayList<>();

		try(preparedStatement) {
			preparedStatement.execute();

			ResultSet resultSet = preparedStatement.getResultSet();

			try(resultSet) {
				while(resultSet.next()) {
					Integer currentId = resultSet.getInt(1);
					String currentName = resultSet.getString(2);

					Category category = new Category(currentId, currentName);
					categories.add(category);
				}
			}
		}
		return categories;
	}

	public List<Category> listCategoriesWithProducts() throws SQLException {
		String selectAllCategories = "SELECT C.id, C.name, P.id, P.name, P.description FROM category C INNER JOIN product P ON C.id = P.category_id";
		PreparedStatement preparedStatement = connection.prepareStatement(selectAllCategories);
		List<Category> categories = new ArrayList<>();
		Category lastCategory = null;

		try(preparedStatement) {
			preparedStatement.execute();

			ResultSet resultSet = preparedStatement.getResultSet();

			try(resultSet) {
				while(resultSet.next()) {
					Integer categoryId = resultSet.getInt(1);
					String categoryName = resultSet.getString(2);
					Integer productId = resultSet.getInt(3);
					String productName = resultSet.getString(4);
					String productDescription = resultSet.getString(5);

					if(lastCategory == null || !lastCategory.getName().equals(categoryName)) {
						Category category = new Category(categoryId, categoryName);
						lastCategory = category;
						categories.add(category);
					}

					Product product = new Product(productId, productName, productDescription);
					lastCategory.addProduct(product);
				}
			}
		}
		return categories;
	}
}
