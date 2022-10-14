package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Employee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

	@Test
	void bonusShouldBeZeroIfSalaryIsTooHigh() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calculateBonus(new Employee("Sōsuke Aizen", LocalDate.now(), new BigDecimal("255000")));

		assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), bonus);
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