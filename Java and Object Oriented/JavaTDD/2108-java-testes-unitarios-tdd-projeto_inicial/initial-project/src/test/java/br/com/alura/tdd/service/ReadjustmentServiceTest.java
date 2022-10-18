package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Employee;
import br.com.alura.tdd.model.Performance;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadjustmentServiceTest {

	@Test
	void readjustmentShouldBeThreePercentWhenPerformanceIsLacking() {
		ReadjustmentService readjustmentService = new ReadjustmentService();
		Employee employee = new Employee("Employee", LocalDate.now(), new BigDecimal("1000.00"));

		readjustmentService.grantReadjustment(employee, Performance.LACKING);

		assertEquals(new BigDecimal("1030.00"), employee.getSalary());
	}

	@Test
	void readjustmentShouldBeFifteenPercentWhenPerformanceIsGood() {
		ReadjustmentService readjustmentService = new ReadjustmentService();
		Employee employee = new Employee("Employee", LocalDate.now(), new BigDecimal("1000.00"));

		readjustmentService.grantReadjustment(employee, Performance.GOOD);

		assertEquals(new BigDecimal("1150.00"), employee.getSalary());
	}

	@Test
	void readjustmentShouldBeTwentyPercentWhenPerformanceIsExcellent() {
		ReadjustmentService readjustmentService = new ReadjustmentService();
		Employee employee = new Employee("Employee", LocalDate.now(), new BigDecimal("1000.00"));

		readjustmentService.grantReadjustment(employee, Performance.EXCELLENT);

		assertEquals(new BigDecimal("1200.00"), employee.getSalary());
	}

}
