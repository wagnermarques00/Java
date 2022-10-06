package br.com.alura.collections.service;

import br.com.alura.collections.model.Employee;

import java.util.Comparator;

public class OrderByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee employee, Employee anotherEmployee) {
		return employee.getAge().compareTo(anotherEmployee.getAge());
	}

}
