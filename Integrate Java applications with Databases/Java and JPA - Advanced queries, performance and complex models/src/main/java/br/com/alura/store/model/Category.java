package br.com.alura.store.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "categories")
public class Category {

	@EmbeddedId
	private CategoryId id;

	public Category() {
	}

	public Category(String name) {
		this.id = new CategoryId(name, "Example type");
	}

	public String getName() {
		return this.id.getName();
	}
}
