package br.com.alura.store.dao;

import br.com.alura.store.model.Customer;

import javax.persistence.EntityManager;

public class CustomerDAO {

	private EntityManager entityManager;

	public CustomerDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Customer customer) {
		this.entityManager.persist(customer);
	}

	public Customer findById(Long id) {
		return entityManager.find(Customer.class, id);
	}

}
