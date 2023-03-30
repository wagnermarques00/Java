package org.example.store.dao;

import org.example.store.model.Category;
import org.example.store.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDAO {

	private EntityManager entityManager;

	public CategoryDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Category category) {
		this.entityManager.persist(category);
	}

	public void update(Category category) {
		this.entityManager.merge(category);
	}

	public void delete(Category category) {
		category = entityManager.merge(category);
		this.entityManager.remove(category);
	}

	public Category searchById(Long id) {
		return entityManager.find(Category.class, id);
	}

	public List<Category> listAll() {
		String selectStatement = "SELECT c FROM Category c"; // JPQL query

		return entityManager.createQuery(selectStatement, Category.class).getResultList();
	}
}
