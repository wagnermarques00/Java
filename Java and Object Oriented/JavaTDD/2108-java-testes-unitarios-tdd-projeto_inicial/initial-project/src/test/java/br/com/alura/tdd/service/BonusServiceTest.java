package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

	@Test
	void bonusShouldBeZeroIfSalaryIsTooHigh() { // Testing with an exception
		BonusService bonusService = new BonusService();
		// first way to work with an exception
//		assertThrows(IllegalArgumentException.class, () -> bonusService.calculateBonus(new Employee("Sōsuke Aizen", LocalDate.now(), new BigDecimal("255000"))));

		// second way to work with an exception
		try {
			bonusService.calculateBonus(new Employee("Sōsuke Aizen", LocalDate.now(), new BigDecimal("255000")));
			 fail("Exception did not occur");
		} catch(Exception e) {
			assertEquals("Employee salary is higher than allowed for bonus", e.getMessage()); // optional, only use if you want the specific message. You can leave the line empty which will also work for exception
		}
	}

	@Test
	void bonusShouldBeTenPerCentOfSalary() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calculateBonus(new Employee("Sōsuke Aizen", LocalDate.now(), new BigDecimal("100")));

		assertEquals(new BigDecimal("10.00"), bonus);
	}

	@Test
	void bonusShouldBeTenPerCentFor10000Salary() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calculateBonus(new Employee("Sōsuke Aizen", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}