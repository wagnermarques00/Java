package br.com.alura.collections.model;

public class Student {
	private String name;
	private Integer registrationNumber;

	public Student(String name, Integer registrationNumber) {
		this.name = name;
		this.registrationNumber = registrationNumber;
	}

	public String getName() {
		return name;
	}

	public Integer getRegistrationNumber() {
		return registrationNumber;
	}

	@Override
	public String toString() {
		return "{Student: " + name + ", id: " + registrationNumber + "}";
	}
}
