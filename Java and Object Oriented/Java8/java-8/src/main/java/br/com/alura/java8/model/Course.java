package br.com.alura.java8.model;

public class Course {
	private final String name;
	private final Integer students;

	public Course(String name, Integer students) {
		this.name = name;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public Integer getStudents() {
		return students;
	}

}
