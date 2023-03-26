package org.example.controller;

import org.example.dao.ProductDAO;
import org.example.factory.ConnectionFactory;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductController {

	private ProductDAO productDAO;

	public ProductController() throws SQLException {
		Connection connection = new ConnectionFactory().recoverConnection();
		this.productDAO = new ProductDAO(connection);
	}

	public void delete(Integer id) {
		System.out.println("Deleting product");
	}

	public void save(Product product) {
		System.out.println("Saving product");
	}

	public List<Product> list() throws SQLException {
		return this.productDAO.list();
	}

	public void change(String name, String description, Integer id) {
		System.out.println("Changing product");
	}
}
