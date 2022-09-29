package br.com.bytebank.bank.model;

import java.io.Serializable;

public class CheckingAccount extends Account implements Taxable, Serializable {
	private static final long serialVersionUID = -5486010432399284887L;

	public CheckingAccount(int agency, int number) {
		super(agency, number);
	}

	@Override
	public void deposit(double amount) {
		super.balance += amount;
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		double amountWithdraw = amount + 0.2;
		super.withdraw(amountWithdraw);
	}

	@Override
	public double calculateTaxAmount() {
		return super.balance * 0.01;
	}

	@Override
	public String toString() {
		return "Checking Account - " + super.toString();
	}
}
