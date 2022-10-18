package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Employee;
import br.com.alura.tdd.model.Performance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadjustmentServiceTest {

	private ReadjustmentService readjustmentService;
	private Employee employee;

	@BeforeEach // runs this method before each test in this class, @AfterEach is the opposite
	public void exampleEmployee() {
		this.readjustmentService = new ReadjustmentService();
		this.employee = new Employee("Employee", LocalDate.now(), new BigDecimal("1000.00"));
	}

	@BeforeAll // runs this method before all methods in this class, @AfterEach is the opposite
	public static void beforeAll() {
		System.out.println("@BeforeAll");
	}

	@Test
	void readjustmentShouldBeThreePercentWhenPerformanceIsLacking() {
		readjustmentService.grantReadjustment(employee, Performance.LACKING);

		assertEquals(new BigDecimal("1030.00"), employee.getSalary());
	}

	@Test
	void readjustmentShouldBeFifteenPercentWhenPerformanceIsGood() {
		readjustmentService.grantReadjustment(employee, Performance.GOOD);

		assertEquals(new BigDecimal("1150.00"), employee.getSalary());
	}

	@Test
	void readjustmentShouldBeTwentyPercentWhenPerformanceIsExcellent() {
		readjustmentService.grantReadjustment(employee, Performance.EXCELLENT);

		assertEquals(new BigDecimal("1200.00"), employee.getSalary());
	}

}
