package org.example;

public class AccountTest {

	public static void main(String[] args) {
		CheckingAccount checkingAccount = new CheckingAccount(111, 111);
		checkingAccount.deposit(500);

		SavingsAccount savingsAccount = new SavingsAccount(111, 222);
		savingsAccount.deposit(1000);

		checkingAccount.transfer(10.0, savingsAccount);
		System.out.println("CA: " + checkingAccount.getBalance()); // 489.8 (after transfer and fee calculation)
		System.out.println("SA: " + savingsAccount.getBalance()); // 1010.0 (after transfer)
	}

}
