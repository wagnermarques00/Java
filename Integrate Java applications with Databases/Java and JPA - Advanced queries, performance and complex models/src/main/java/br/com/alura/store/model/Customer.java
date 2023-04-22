package br.com.alura.store.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private PersonalData personalData;

	public Customer() {
	}

	public Customer(String name, String cpf) {
		this.personalData = new PersonalData(name, cpf);
	}

	public String getName() {
		return this.personalData.getName();
	}

	public String getCpf() {
		return this.personalData.getCpf();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonalData getPersonalData() {
		return personalData;
	}
}
