package br.com.alura.store.dao;

import br.com.alura.store.model.Order;

import javax.persistence.EntityManager;

public class OrderDAO {

	private EntityManager entityManager;

	public OrderDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Order order) {
		this.entityManager.persist(order);
	}

	public Order findById(Long id) {
		return entityManager.find(Order.class, id);
	}

}
