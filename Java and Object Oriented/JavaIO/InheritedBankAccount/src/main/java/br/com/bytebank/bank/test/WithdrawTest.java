package br.com.bytebank.bank.test;

import br.com.bytebank.bank.model.CheckingAccount;
import br.com.bytebank.bank.model.InsufficientBalanceException;

public class WithdrawTest {

	public static void main(String[] args) throws InsufficientBalanceException {
		CheckingAccount checkingAccount = new CheckingAccount(111, 222);
		checkingAccount.deposit(200.0);

		checkingAccount.withdraw(190.0);

		try {
			checkingAccount.withdraw(10.0);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(checkingAccount.getBalance());
	}
}
