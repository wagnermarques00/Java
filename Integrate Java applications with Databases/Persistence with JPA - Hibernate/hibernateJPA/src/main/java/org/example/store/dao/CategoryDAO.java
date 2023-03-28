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
}
