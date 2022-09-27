package br.com.bytebank.bank.test.util;

import br.com.bytebank.bank.model.Account;
import br.com.bytebank.bank.model.CheckingAccount;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Account> accountsList = new ArrayList<Account>(); // <> Generics

		Account ca1 = new CheckingAccount(111, 222);
		Account ca2 = new CheckingAccount(333, 444);
		accountsList.add(ca1);
		accountsList.add(ca2);

		System.out.println("Size before: " + accountsList.size()); // 2

		Account ref = accountsList.get(0);
		System.out.println(ref.getNumber()); // 222

		accountsList.remove(0);
		System.out.println("Size after remove: " + accountsList.size()); // 1

		Account ca3 = new CheckingAccount(555, 666);
		Account ca4 = new CheckingAccount(777, 888);
		accountsList.add(ca3);
		accountsList.add(ca4);

		System.out.println("Size after add: " + accountsList.size()); // 3

		for(Account account : accountsList) {
			System.out.println(account);
			/*
			 * -> called the toString method
			 * Checking Account - Agency: 333, Number: 444, Balance: 0.0
			 * Checking Account - Agency: 555, Number: 666, Balance: 0.0
			 * Checking Account - Agency: 777, Number: 888, Balance: 0.0
			 */
		}
	}

}
