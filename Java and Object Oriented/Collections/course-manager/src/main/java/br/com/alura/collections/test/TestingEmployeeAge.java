package br.com.alura.collections.test;

import br.com.alura.collections.model.Employee;
import br.com.alura.collections.service.OrderByAge;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestingEmployeeAge {

	public static void main(String[] args) {
		Employee e1 = new Employee("Loly Aivirrne", 45);
		Employee e2 = new Employee("Luppi Antenor", 41);
		Employee e3 = new Employee("Emilou Apacci", 42);

		Set<Employee> employees = new TreeSet<>(new OrderByAge());
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);

		Iterator<Employee> iterator = employees.iterator();

		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName()); // Overriden Compare is using age
			/*
			 * Luppi Antenor
			 * Loly Aivirrne
			 * Emilou Apacci
			 */
		}
	}

}
