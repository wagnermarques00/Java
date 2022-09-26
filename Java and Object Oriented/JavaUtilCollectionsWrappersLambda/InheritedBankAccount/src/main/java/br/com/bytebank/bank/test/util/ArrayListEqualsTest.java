package br.com.bytebank.bank.test.util;

import br.com.bytebank.bank.model.Account;
import br.com.bytebank.bank.model.CheckingAccount;

import java.util.ArrayList;

public class ArrayListEqualsTest {

	public static void main(String[] args) {
		ArrayList<Account> accountsList = new ArrayList<Account>(); // <> Generics

		Account ca1 = new CheckingAccount(111, 222);
		Account ca2 = new CheckingAccount(333, 444);
		Account ca3 = new CheckingAccount(333, 444); // same values of ca2 for equals test
		accountsList.add(ca1);
		accountsList.add(ca2);

		boolean thereIsAccount = accountsList.contains(ca1);
		boolean thereIsAccount2 = accountsList.contains(ca3);
		boolean equals = ca2.equals(ca3); // equals with override
		System.out.println("ca1 exists in accountsList: " + thereIsAccount);        // true
		System.out.println("ca3 exists in accountsList: " + thereIsAccount2);        // true(false if equals is not overridden)
		System.out.println("ca2 has the same agency and number as ca3: " + equals);    // true

		for(Account account : accountsList) {
			System.out.println(account);
			/*
			 * -> called the toString method
			 * Checking Account - Agency: 111, Number: 222
			 * Checking Account - Agency: 333, Number: 444
			 */
		}
	}

}
