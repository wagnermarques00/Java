package org.example;

import org.example.dao.CategoryDAO;
import org.example.factory.ConnectionFactory;
import org.example.model.Category;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestListingCategory {

	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().recoverConnection();

		try(connection) {
			CategoryDAO categoryDAO = new CategoryDAO(connection);
			List<Category> categoriesList = categoryDAO.listCategoriesWithProducts();

			categoriesList.stream()
						  .forEach(category -> {
							  System.out.println(category.getName());
							  for(Product product : category.getProducts()) {
								  System.out.println(category.getName() + " - " + product.getName() + " - " + product.getDescription());
							  }
						  });
		}
	}
}
