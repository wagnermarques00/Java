package org.example;

public class CheckingAccount extends Account implements Taxable{

	public CheckingAccount(int agency, int number) {
		super(agency, number);
	}

	@Override
	public void deposit(double amount) {
		super.balance += amount;
	}

	@Override
	public boolean withdraw(double amount) {
		double amountWithdraw = amount + 0.2; // means that for every withdrawal there is a fee of 0.2
		return super.withdraw(amountWithdraw);
	}

	@Override
	public double calculateTaxAmount() {
		return super.balance * 0.01; // 1% of the balance
	}
}
