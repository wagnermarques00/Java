package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private final Integer id;
	private final String name;
	private final List<Product> products = new ArrayList<>();

	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
