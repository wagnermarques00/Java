package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

	public BigDecimal calculateBonus(Employee employee) {
		BigDecimal value = employee.getSalary()
				.multiply(new BigDecimal("0.1"));
		if(value.compareTo(new BigDecimal("1000")) > 0) {
			value = BigDecimal.ZERO;
		}
		return value.setScale(2, RoundingMode.HALF_UP);
	}

}
