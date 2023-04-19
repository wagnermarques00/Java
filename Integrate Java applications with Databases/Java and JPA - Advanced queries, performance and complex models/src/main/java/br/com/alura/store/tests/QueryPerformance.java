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

public class QueryPerformance {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager entityManager = UtilJPA.getEntityManager();
		OrderDAO orderDao = new OrderDAO(entityManager);
		Order order = orderDao.findOrderByIdWithCustomer(1L);
		entityManager.close();
		System.out.println(order.getCustomer().getName());
	}

	private static void popularBancoDeDados() {
		Category cellphones = new Category("CELLPHONES");
		Category consoles = new Category("CONSOLES");
		Category computers = new Category("COMPUTERS");

		Product cellphone = new Product("Xiaomi Redmi", "Very nice", new BigDecimal("800"), cellphones);
		Product ps5 = new Product("PS5", "Playstation 5", new BigDecimal("8000"), consoles);
		Product macbook = new Product("Macbook", "Macbook pro retina", new BigDecimal("14000"), computers);

		Customer customer = new Customer("Rodrigo", "123456");

		Order order = new Order(customer);
		order.addProduct(new OrderProduct(10, order, cellphone));
		order.addProduct(new OrderProduct(40, order, ps5));

		Order order2 = new Order(customer);
		order2.addProduct(new OrderProduct(2, order, macbook));

		EntityManager entityManager = UtilJPA.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		CustomerDAO customerDAO = new CustomerDAO(entityManager);
		OrderDAO orderDAO = new OrderDAO(entityManager);

		entityManager.getTransaction().begin();

		categoryDAO.create(cellphones);
		categoryDAO.create(consoles);
		categoryDAO.create(computers);

		productDAO.create(cellphone);
		productDAO.create(ps5);
		productDAO.create(macbook);

		customerDAO.create(customer);

		orderDAO.create(order);
		orderDAO.create(order2);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
