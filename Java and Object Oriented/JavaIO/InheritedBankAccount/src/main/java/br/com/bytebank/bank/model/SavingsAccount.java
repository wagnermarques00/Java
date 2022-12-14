package br.com.bytebank.bank.model;

public class SavingsAccount extends Account {

	public SavingsAccount(int agency, int number) {
		super(agency, number);
	}

	@Override
	public void deposit(double amount) {
		super.balance += amount;
	}

	@Override
	public String toString() {
		return "Savings Account - " + super.toString();
	}

}
