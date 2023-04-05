package br.com.alura.store.tests;

import br.com.alura.store.dao.CategoryDAO;
import br.com.alura.store.dao.CustomerDAO;
import br.com.alura.store.dao.OrderDAO;
import br.com.alura.store.dao.ProductDAO;
import br.com.alura.store.model.Category;
import br.com.alura.store.model.Customer;
import br.com.alura.store.model.Order;
import br.com.alura.store.model.OrderProduct;
import br.com.alura.store.model.Product;
import br.com.alura.store.util.UtilJPA;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class OrderRegistration {

	public static void main(String[] args) {
		populateTestData();
		createOrder();
	}

	private static void populateTestData() {
		EntityManager entityManager = UtilJPA.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		CustomerDAO customerDAO = new CustomerDAO(entityManager);

		Category cellphones = new Category("Cellphones");
		Product cellphone = new Product("Xiaomi Redmi", "Very nice", new BigDecimal("800"), cellphones);
		Customer customer = new Customer("Joseph", "123456");

		entityManager.getTransaction().begin();

		categoryDAO.create(cellphones);
		productDAO.create(cellphone);
		customerDAO.create(customer);

		entityManager.getTransaction().commit();
		entityManager.close();
	}


	private static void createOrder() {
		EntityManager entityManager = UtilJPA.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		OrderDAO orderDAO = new OrderDAO(entityManager);
		CustomerDAO customerDAO = new CustomerDAO(entityManager);

		Product product = productDAO.findById(1L);
		Customer customer = customerDAO.findById(1L);

		entityManager.getTransaction().begin();

		Order order = new  Order(customer);
		order.addProduct(new OrderProduct(10, order, product));

		orderDAO.create(order);
		entityManager.getTransaction().commit();
	}
}
