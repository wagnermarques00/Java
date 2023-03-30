package org.example.store.dao;

import org.example.store.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDAO {

	private final EntityManager entityManager;

	public ProductDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Product product) {
		this.entityManager.persist(product);
	}

	public void update(Product product) {
		this.entityManager.merge(product);
	}

	public void delete(Product product) {
		product = entityManager.merge(product);
		this.entityManager.remove(product);
	}

	public Product searchById(Long id) {
		return entityManager.find(Product.class, id);
	}

	public List<Product> listAll() {
		String selectStatement = "SELECT p FROM Product p"; // JPQL query

		return entityManager.createQuery(selectStatement, Product.class)
							.getResultList();
	}

	public List<Product> listByName(String name) {
		String selectStatement = "SELECT p FROM Product p WHERE p.name = :name"; // JPQL query

		return entityManager.createQuery(selectStatement, Product.class)
							.setParameter("name", name)
							.getResultList();
	}

	public List<Product> listByDescription(String description) {
		String selectStatement = "SELECT p FROM Product p WHERE p.description = ?1"; // JPQL query

		return entityManager.createQuery(selectStatement, Product.class)
							.setParameter(1, description)
							.getResultList();
	}

	public List<Product> listByCategoryName(String name) {
		String selectStatement = "SELECT p FROM Product p WHERE p.category.name = :name"; // JPQL query

		return entityManager.createQuery(selectStatement, Product.class)
							.setParameter("name", name)
							.getResultList();
	}

	public BigDecimal searchPriceByProductName(String name) {
		String selectStatement = "SELECT p.price FROM Product p WHERE p.name = :name"; // JPQL query

		return entityManager.createQuery(selectStatement, BigDecimal.class)
							.setParameter("name", name)
							.getSingleResult();
	}
}
