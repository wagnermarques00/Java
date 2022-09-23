package br.com.bytebank.bank.test;

import br.com.bytebank.bank.model.Account;
import br.com.bytebank.bank.model.CheckingAccount;
import br.com.bytebank.bank.model.ReferencesKeeper;

public class ReferencesKeeperTest {

	public static void main(String[] args) {
		ReferencesKeeper keeper = new ReferencesKeeper();
		Account ca1 = new CheckingAccount(111, 222);
		Account ca2 = new CheckingAccount(555, 777);

		keeper.add(ca1);
		keeper.add(ca2);

		int size = keeper.getNumberElements();
		System.out.println(size); // 2

		Account ref = (Account) keeper.getReference(0);
		System.out.println(ref); // Checking Account - Agency: 111, Number: 222
		System.out.println(ref.getAgency()); // 111
	}

}
