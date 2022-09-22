package br.com.bytebank.bank.test;

import br.com.bytebank.bank.model.CheckingAccount;
import br.com.bytebank.bank.model.LifeInsurance;
import br.com.bytebank.bank.model.TaxCalculator;

public class TaxableTest {

	public static void main(String[] args) {
		CheckingAccount checkingAccount = new CheckingAccount(111, 222);
		checkingAccount.deposit(100.0);

		LifeInsurance lifeInsurance = new LifeInsurance();

		TaxCalculator calculator = new TaxCalculator();
		calculator.register(lifeInsurance);
		calculator.register(checkingAccount);

		System.out.println(calculator.getTotalTax()); // 43.0 (42 -> br.com.bytebank.bank.model.LifeInsurance + 1 (1% of deposit)

	}

}
