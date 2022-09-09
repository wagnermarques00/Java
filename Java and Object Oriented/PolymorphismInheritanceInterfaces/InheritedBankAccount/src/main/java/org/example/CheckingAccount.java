package org.example;

public class CheckingAccount extends Account{

	public CheckingAccount(int agency, int number) {
		super(agency, number);
	}

	@Override
	public boolean withdraw(double amount) {
		double amountWithdraw = amount + 0.2; // means that for every withdrawal there is a fee of 0.2
		return super.withdraw(amountWithdraw);
	}
}
