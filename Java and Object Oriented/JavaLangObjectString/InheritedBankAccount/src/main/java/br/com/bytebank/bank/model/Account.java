package br.com.bytebank.bank.model;

public abstract class Account {
	private static int totalAccounts;
	protected double balance;
	private int agency;
	private int number;
	private Customer customer;

	public Account(int agency, int number) {
		this.agency = agency;
		this.number = number;
		Account.totalAccounts++;
	}

	public static int getTotalAccounts() {
		return Account.totalAccounts;
	}

	public abstract void deposit(double amount);

	public void withdraw(double amount) throws InsufficientBalanceException {

		if (this.balance < amount) {
			throw new InsufficientBalanceException("Balance: " + this.balance + " is insufficient to withdraw " + amount);
		}
		this.balance -= amount;
	}

	public void transfer(double amount, Account destinationAccount) throws InsufficientBalanceException {
		this.withdraw(amount);
		destinationAccount.deposit(amount);
	}

	public double getBalance() {
		return this.balance;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		if (number <= 0) {
			System.out.println("Invalid number");
			return;
		}
		this.number = number;
	}

	public int getAgency() {
		return this.agency;
	}

	public void setAgency(int agency) {
		if (agency <= 0) {
			System.out.println("Agency must be greater than zero");
			return;
		}
		this.agency = agency;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
