package br.com.alura.store.dao;

import br.com.alura.store.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDAO {

	private EntityManager entityManager;

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

	public List<Product> findAll() {
		String JPQL_SELECT_STATEMENT = "SELECT p FROM Product p";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, Product.class).getResultList();
	}

	public List<Product> findByCategoryName(String name) {
		String JPQL_SELECT_STATEMENT = "SELECT p FROM Product p WHERE p.category.name = :name";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, Product.class)
							.setParameter("name", name)
							.getResultList();
	}

	public Product findById(Long id) {
		return entityManager.find(Product.class, id);
	}

	public List<Product> findByName(String name) {
		String JPQL_SELECT_STATEMENT = "SELECT p FROM Product p WHERE p.name = :name";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, Product.class)
							.setParameter("name", name)
							.getResultList();
	}

	public BigDecimal findProductPriceByName(String name) {
		String JPQL_SELECT_STATEMENT = "SELECT p.price FROM Product p WHERE p.name = :name";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, BigDecimal.class)
							.setParameter("name", name)
							.getSingleResult();
	}
}
