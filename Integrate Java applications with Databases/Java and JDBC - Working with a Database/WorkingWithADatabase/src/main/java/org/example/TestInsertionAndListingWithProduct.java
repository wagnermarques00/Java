package org.example;

import org.example.dao.ProductDAO;
import org.example.factory.ConnectionFactory;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestInsertionAndListingWithProduct {

	public static void main(String[] args) throws SQLException {
		Product dresser = new Product("Dresser", "Vertical Dresser");
		Connection connection = new ConnectionFactory().recoverConnection();

		try(connection) {
			ProductDAO productDAO = new ProductDAO(connection);
			productDAO.save(dresser);

			List<Product> productsList = productDAO.list();
			productsList.stream()
						.forEach(pl -> System.out.println(pl));
		}
	}
}
