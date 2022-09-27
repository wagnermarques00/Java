package br.com.bytebank.bank.test.util;

import br.com.bytebank.bank.model.Account;
import br.com.bytebank.bank.model.CheckingAccount;
import br.com.bytebank.bank.model.Customer;
import br.com.bytebank.bank.model.SavingsAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassTest {

	public static void main(String[] args) {
		Account cc1 = new CheckingAccount(22, 33);
		Customer cc1Customer = new Customer();
		cc1Customer.setName("Tenya Iida");
		cc1.setCustomer(cc1Customer);
		cc1.deposit(333.0);

		Account cc2 = new SavingsAccount(22, 44);
		Customer cc2Customer = new Customer();
		cc2Customer.setName("Katsuki Bakugo");
		cc2.setCustomer(cc2Customer);
		cc2.deposit(444.0);

		Account cc3 = new CheckingAccount(22, 11);
		Customer cc3Customer = new Customer();
		cc3Customer.setName("Ochaco Uraraka");
		cc3.setCustomer(cc3Customer);
		cc3.deposit(111.0);

		Account cc4 = new SavingsAccount(22, 22);
		Customer cc4Customer = new Customer();
		cc4Customer.setName("Izuku Midoriya");
		cc4.setCustomer(cc4Customer);
		cc4.deposit(222.0);

		List<Account> list = new ArrayList<>();
		list.add(cc1);
		list.add(cc2);
		list.add(cc3);
		list.add(cc4);

		System.out.println("Before numberComparator");
		for(Account account : list) {
			System.out.println(account + " customer -> " + account.getCustomer().getName());
			/*
			 * Checking Account - Agency: 22, Number: 33, Balance: 333.0 customer -> Tenya Iida
			 * Savings Account - Agency: 22, Number: 44, Balance: 444.0 customer -> Katsuki Bakugo
			 * Checking Account - Agency: 22, Number: 11, Balance: 111.0 customer -> Ochaco Uraraka
			 * Savings Account - Agency: 22, Number: 22, Balance: 222.0 customer -> Izuku Midoriya
			 */
		}

		list.sort(new Comparator<Account>() { // anonymous class
			@Override
			public int compare(Account a1, Account a2) {
				return Integer.compare(a1.getNumber(), a2.getNumber());
			}
		});

		System.out.println("---------------------");
		System.out.println("After numberComparator");
		for(Account account : list) {
			System.out.println(account + " customer -> " + account.getCustomer().getName());
			/*
			 * Checking Account - Agency: 22, Number: 11, Balance: 111.0 customer -> Ochaco Uraraka
			 * Savings Account - Agency: 22, Number: 22, Balance: 222.0 customer -> Izuku Midoriya
			 * Checking Account - Agency: 22, Number: 33, Balance: 333.0 customer -> Tenya Iida
			 * Savings Account - Agency: 22, Number: 44, Balance: 444.0 customer -> Katsuki Bakugo
			 */
		}

		Comparator<Account> comparator = new Comparator<Account>() {
			@Override
			public int compare(Account c1, Account c2) {
				String c1Name = c1.getCustomer().getName();
				String c2Name = c2.getCustomer().getName();
				return c1Name.compareTo(c2Name);
			}
		};

		list.sort(comparator);

		System.out.println("---------------------");
		System.out.println("After customerComparator(balance)");
		for(Account account : list) {
			System.out.println(account + " customer -> " + account.getCustomer().getName());
			/*
			 * Savings Account - Agency: 22, Number: 22, Balance: 222.0 customer -> Izuku Midoriya
			 * Savings Account - Agency: 22, Number: 44, Balance: 444.0 customer -> Katsuki Bakugo
			 * Checking Account - Agency: 22, Number: 11, Balance: 111.0 customer -> Ochaco Uraraka
			 * Checking Account - Agency: 22, Number: 33, Balance: 333.0 customer -> Tenya Iida
			 */
		}

		Collections.sort(list);
		System.out.println("---------------------");
		System.out.println("After Collections.sort");
		for(Account account : list) {
			System.out.println(account + " customer -> " + account.getCustomer().getName());
			/*
			 * Checking Account - Agency: 22, Number: 11 customer -> Ochaco Uraraka balance -> 111.0
			 * Savings Account - Agency: 22, Number: 22 customer -> Izuku Midoriya balance -> 222.0
			 * Checking Account - Agency: 22, Number: 33 customer -> Tenya Iida balance -> 333.0
			 * Savings Account - Agency: 22, Number: 44 customer -> Katsuki Bakugo balance -> 444.0
			 */
		}
	}

}
