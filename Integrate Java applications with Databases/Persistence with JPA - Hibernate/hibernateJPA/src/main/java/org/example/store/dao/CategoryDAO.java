package org.example.store.dao;

import org.example.store.model.Category;

import javax.persistence.EntityManager;

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
}
