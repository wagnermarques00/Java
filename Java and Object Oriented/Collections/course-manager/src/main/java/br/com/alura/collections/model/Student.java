package br.com.alura.collections.model;

public class Student {
	private String name;
	private Integer registrationNumber;

	public Student(String name, Integer registrationNumber) {
		if(name == null || registrationNumber == null) {
			throw new NullPointerException("Please provide a name and registration");
		}
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
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + registrationNumber.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Student)) return false;

		Student student = (Student) o;

		if(!name.equals(student.name)) return false;
		return registrationNumber.equals(student.registrationNumber);
	}

	@Override
	public String toString() {
		return "{Student: " + name + ", id: " + registrationNumber + "}";
	}
}
