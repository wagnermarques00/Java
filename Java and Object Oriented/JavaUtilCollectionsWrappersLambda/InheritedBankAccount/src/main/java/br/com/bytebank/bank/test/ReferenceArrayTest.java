package br.com.bytebank.bank.test;

import br.com.bytebank.bank.model.CheckingAccount;

public class ReferenceArrayTest {

	public static void main(String[] args) {
		CheckingAccount ca1 = new CheckingAccount(111, 222);
		CheckingAccount ca2 = new CheckingAccount(222, 333);
		CheckingAccount ca3 = new CheckingAccount(333, 444);
		CheckingAccount ca4 = new CheckingAccount(444, 555);
		CheckingAccount ca5 = new CheckingAccount(555, 666);

		CheckingAccount[] checkingAccounts = { ca1, ca2, ca3, ca4, ca5 };

		System.out.println(checkingAccounts[0]); // Checking Account - Agency: 111, Number: 222
		System.out.println(checkingAccounts[1]); // Checking Account - Agency: 222, Number: 333
		System.out.println(checkingAccounts[2]); // Checking Account - Agency: 333, Number: 444
		System.out.println(checkingAccounts[3]); // Checking Account - Agency: 444, Number: 555
		System.out.println(checkingAccounts[4]); // Checking Account - Agency: 555, Number: 666

		System.out.println(checkingAccounts[0].getNumber()); // 222

		CheckingAccount ref = checkingAccounts[2];
		System.out.println(ref.getAgency()); // 333
	}

}
