package br.com.alura.store.tests;

import br.com.alura.store.dao.CategoryDAO;
import br.com.alura.store.dao.ProductDAO;
import br.com.alura.store.model.Category;
import br.com.alura.store.model.Product;
import br.com.alura.store.util.UtilJPA;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

public class CriteriaTest {
	public static void main(String[] args) {
		populateDatabase();
		EntityManager entityManager = UtilJPA.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		List<Product> products = productDAO.findByParametersWithCriteria(null, null, LocalDate.now());

		products.forEach(p -> System.out.println(p.getName()));
	}

	private static void populateDatabase() {
		Category cellphones = new Category("CELLPHONES");
		Category consoles = new Category("CONSOLES");
		Category computers = new Category("COMPUTERS");

		Product cellphone = new Product("Xiaomi Redmi", "Very nice", new BigDecimal("800"), cellphones);
		Product ps5 = new Product("PS5", "Playstation 5", new BigDecimal("8000"), consoles);
		Product macbook = new Product("Macbook", "Macbook pro retina", new BigDecimal("14000"), computers);

		EntityManager entityManager = UtilJPA.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);

		entityManager.getTransaction().begin();

		categoryDAO.create(cellphones);
		categoryDAO.create(consoles);
		categoryDAO.create(computers);

		productDAO.create(cellphone);
		productDAO.create(ps5);
		productDAO.create(macbook);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
