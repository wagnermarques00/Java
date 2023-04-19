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
import br.com.alura.store.vo.SalesReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderRegistration {

	public static void main(String[] args) {
		populateTestData();
		createOrder();
		printTotalSalesValue();
		printSalesReportByProduct();
	}

	private static void populateTestData() {
		EntityManager entityManager = UtilJPA.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		CustomerDAO customerDAO = new CustomerDAO(entityManager);

		Category cellphones = new Category("Cellphones");
		Category gamingConsoles = new Category("Gaming consoles");
		Category computers = new Category("Computers");
		Product cellphone = new Product("Xiaomi Redmi", "Very nice", new BigDecimal("800"), cellphones);
		Product ps5 = new Product("PS5", "Playstation 5", new BigDecimal("3500"), gamingConsoles);
		Product macbook = new Product("Macbook", "Macbook pro retina", new BigDecimal("8000"), computers);
		Customer customer = new Customer("Joseph", "123456");

		entityManager.getTransaction().begin();

		categoryDAO.create(cellphones);
		categoryDAO.create(gamingConsoles);
		categoryDAO.create(computers);
		productDAO.create(cellphone);
		productDAO.create(ps5);
		productDAO.create(macbook);
		customerDAO.create(customer);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	private static void createOrder() {
		EntityManager entityManager = UtilJPA.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		OrderDAO orderDAO = new OrderDAO(entityManager);
		CustomerDAO customerDAO = new CustomerDAO(entityManager);

		Product cellphone = productDAO.findById(1L);
		Product ps5 = productDAO.findById(2L);
		Product macbook = productDAO.findById(3L);
		Customer customer = customerDAO.findById(1L);

		entityManager.getTransaction().begin();

		Order order1 = new Order(customer);
		order1.addProduct(new OrderProduct(10, order1, cellphone));
		order1.addProduct(new OrderProduct(40, order1, ps5));

		Order order2 = new Order(customer);
		order2.addProduct(new OrderProduct(2, order2, macbook));

		orderDAO.create(order1);
		orderDAO.create(order2);
		entityManager.getTransaction().commit();
	}

	private static void printTotalSalesValue() {
		EntityManager entityManager = UtilJPA.getEntityManager();
		OrderDAO orderDAO = new OrderDAO(entityManager);

		BigDecimal totalSalesValue = orderDAO.calculateTotalSalesValue();
		System.out.println("Total sales value: " + totalSalesValue);
	}

	private static void printSalesReportByProduct() {
		EntityManager entityManager = UtilJPA.getEntityManager();
		OrderDAO orderDAO = new OrderDAO(entityManager);

		List<SalesReportVo> report = orderDAO.salesReport();
		report.forEach(System.out::println);
	}
}
