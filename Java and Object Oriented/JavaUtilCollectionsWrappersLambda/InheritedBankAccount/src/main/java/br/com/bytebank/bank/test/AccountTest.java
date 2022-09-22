package br.com.bytebank.bank.test;

import br.com.bytebank.bank.model.CheckingAccount;
import br.com.bytebank.bank.model.InsufficientBalanceException;
import br.com.bytebank.bank.model.SavingsAccount;

public class AccountTest {

	public static void main(String[] args) throws InsufficientBalanceException {
		CheckingAccount checkingAccount = new CheckingAccount(111, 111);
		checkingAccount.deposit(500);

		SavingsAccount savingsAccount = new SavingsAccount(111, 222);
		savingsAccount.deposit(1000);


		checkingAccount.transfer(10.0, savingsAccount);
		System.out.println("CA: " + checkingAccount.getBalance()); // 489.8 (after transfer and fee calculation)
		System.out.println("SA: " + savingsAccount.getBalance()); // 1010.0 (after transfer)
	}

}
