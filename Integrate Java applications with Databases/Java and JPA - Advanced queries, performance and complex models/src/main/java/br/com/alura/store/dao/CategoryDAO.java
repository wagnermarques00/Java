package br.com.alura.store.dao;

import javax.persistence.EntityManager;

import br.com.alura.store.model.Category;

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
