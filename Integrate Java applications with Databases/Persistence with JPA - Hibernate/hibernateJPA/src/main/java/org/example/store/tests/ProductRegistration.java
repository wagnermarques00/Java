package org.example.store.tests;

import org.example.store.dao.CategoryDAO;
import org.example.store.dao.ProductDAO;
import org.example.store.model.Category;
import org.example.store.model.Product;
import org.example.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductRegistration {

	public static void main(String[] args) {
		registerProduct();

		Long id = 1L;
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);

		Product product = productDAO.searchById(id);
		System.out.println("search by id: " + product.getPrice());

		List<Product> allProducts = productDAO.listAll();
		allProducts.forEach(p -> System.out.println("list all products: " + p.getName()));

		List<Product> productXiaomi = productDAO.listByName("Xiaomi Redmi");
		productXiaomi.forEach(p -> System.out.println("list by name: " + p.getName()));

		List<Product> descriptionVeryNice = productDAO.listByDescription("Very nice");
		descriptionVeryNice.forEach(d -> System.out.println("list by description: " + d.getName()));

		List<Product> productCategory = productDAO.listByCategoryName("Cellphones");
		productCategory.forEach(p -> System.out.println("list by category: " + p.getName()));

		BigDecimal productPrice = productDAO.searchPriceByProductName("Xiaomi Redmi");
		System.out.println("Search price by product name: " + productPrice);

		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		List<Category> allCategories = categoryDAO.listAll();
		allCategories.forEach(c -> System.out.println("list all categories: " + c.getName()));
	}

	private static void registerProduct() {
		Category cellphones = new Category("Cellphones");
		Product phone = new Product("Xiaomi Redmi","Very nice", new BigDecimal("800"), cellphones);

		EntityManager entityManager = JPAUtil.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);

		entityManager.getTransaction().begin();

		categoryDAO.create(cellphones);
		productDAO.create(phone);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
