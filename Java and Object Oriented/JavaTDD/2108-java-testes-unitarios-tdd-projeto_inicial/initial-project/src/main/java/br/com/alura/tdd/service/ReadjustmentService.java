package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Employee;
import br.com.alura.tdd.model.Performance;

import java.math.BigDecimal;

public class ReadjustmentService {

	public void grantReadjustment(Employee employee, Performance performance) {
		BigDecimal percentage = performance.readjustmentPercentage();
		BigDecimal readjustment = employee.getSalary()
										  .multiply(percentage);
		employee.readjustSalary(readjustment);
	}
}
