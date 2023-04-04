package br.com.alura.store.tests;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.store.dao.CategoryDAO;
import br.com.alura.store.dao.ProductDAO;
import br.com.alura.store.model.Category;
import br.com.alura.store.model.Product;
import br.com.alura.store.util.UtilJPA;

public class ProductRegistration {
	
	public static void main(String[] args) {
		createProduct();
		EntityManager entityManager = UtilJPA.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		
		Product product = productDAO.findById(1L);
		System.out.println(product.getPrice());
		
		List<Product> products = productDAO.findByCategoryName("Cellphones");
		products.forEach(p -> System.out.println(p.getName()));
	
		BigDecimal productPrice = productDAO.findProductPriceByName("Xiaomi Redmi");
		System.out.println("Product price: " + productPrice);
	}

	private static void createProduct() {
		Category cellphones = new Category("Cellphones");
		Product cellphone = new Product("Xiaomi Redmi", "Very nice", new BigDecimal("800"), cellphones);
		
		EntityManager entityManager = UtilJPA.getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		
		entityManager.getTransaction().begin();
		
		categoryDAO.create(cellphones);
		productDAO.create(cellphone);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
