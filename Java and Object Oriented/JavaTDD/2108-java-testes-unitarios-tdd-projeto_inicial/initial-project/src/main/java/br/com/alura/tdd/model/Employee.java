package br.com.alura.tdd.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Employee {

	private final String name;
	private final LocalDate admissionDate;
	private BigDecimal salary;

	public Employee(String name, LocalDate admissionDate, BigDecimal salary) {
		this.name = name;
		this.admissionDate = admissionDate;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void readjustSalary(BigDecimal readjustment) {
		this.salary = this.salary.add(readjustment);
		roundUpSalary();
	}

	private void roundUpSalary() { // you cannot test this method
		this.salary = this.salary.setScale(2, RoundingMode.HALF_UP);
	}
}
