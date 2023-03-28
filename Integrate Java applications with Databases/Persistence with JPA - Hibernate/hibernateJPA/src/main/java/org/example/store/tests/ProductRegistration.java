package org.example.store.tests;

import org.example.store.dao.CategoryDAO;
import org.example.store.dao.ProductDAO;
import org.example.store.model.Category;
import org.example.store.model.Product;
import org.example.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistration {

	public static void main(String[] args) {
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
