package org.example.controller;

import org.example.dao.CategoryDAO;
import org.example.factory.ConnectionFactory;
import org.example.model.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryController {

	private CategoryDAO categoryDAO;

	public CategoryController() throws SQLException, SQLException {
		Connection connection = new ConnectionFactory().recoverConnection();
		this.categoryDAO = new CategoryDAO(connection);
	}

	public List<Category> list() throws SQLException {
		return this.categoryDAO.list();
	}
}
