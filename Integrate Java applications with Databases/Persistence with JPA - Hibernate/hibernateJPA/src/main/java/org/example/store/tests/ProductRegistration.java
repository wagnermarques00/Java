package org.example.store.tests;

import org.example.store.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductRegistration {

	public static void main(String[] args) {
		Product phone = new Product();
		phone.setName("Xiaomi Redmi");
		phone.setDescription("Very nice");
		phone.setPrice(new BigDecimal("800"));

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(phone);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
