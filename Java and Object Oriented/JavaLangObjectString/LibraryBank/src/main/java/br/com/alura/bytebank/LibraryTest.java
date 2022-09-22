package br.com.alura.bytebank;

import br.com.bytebank.bank.model.CheckingAccount;

public class LibraryTest {

	public static void main(String[] args) {
		CheckingAccount account = new CheckingAccount(123, 456);
		account.deposit(500);

		System.out.println(account.getBalance());

	}
}
