package br.com.alura.store.model;

import javax.persistence.Entity;

@Entity
public class Informatics extends Product{

	private String brand;
	private String model;

	public Informatics() {
	}

	public Informatics(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
