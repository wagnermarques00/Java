package br.com.bytebank.bank.test.util;

import br.com.bytebank.bank.model.Account;

import java.util.Comparator;

public class CustomerComparatorTest implements Comparator<Account> {

	@Override
	public int compare(Account c1, Account c2) {
		String c1Name = c1.getCustomer().getName();
		String c2Name = c2.getCustomer().getName();
		return c1Name.compareTo(c2Name);
	}

}
