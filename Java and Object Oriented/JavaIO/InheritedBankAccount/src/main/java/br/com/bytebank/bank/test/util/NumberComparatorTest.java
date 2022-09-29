package br.com.bytebank.bank.test.util;

import br.com.bytebank.bank.model.Account;

import java.util.Comparator;

public class NumberComparatorTest implements Comparator<Account> {

	@Override
	public int compare(Account a1, Account a2) {
		return Integer.compare(a1.getNumber(), a2.getNumber());
	}

}
