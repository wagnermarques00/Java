package br.com.bytebank.bank.test;

import br.com.bytebank.bank.model.Account;
import br.com.bytebank.bank.model.CheckingAccount;
import br.com.bytebank.bank.model.SavingsAccount;

public class ReferenceArrayTest {

	public static void main(String[] args) {
		CheckingAccount ca1 = new CheckingAccount(111, 222);
		CheckingAccount ca2 = new CheckingAccount(222, 333);
		CheckingAccount ca3 = new CheckingAccount(333, 444);
		CheckingAccount ca4 = new CheckingAccount(444, 555);
		SavingsAccount ca5 = new SavingsAccount(555, 666);

		Object[] references = { ca1, ca2, ca3, ca4, ca5 };

		System.out.println(references[0]); // Checking Account - Agency: 111, Number: 222
		System.out.println(references[1]); // Checking Account - Agency: 222, Number: 333
		System.out.println(references[2]); // Checking Account - Agency: 333, Number: 444
		System.out.println(references[3]); // Checking Account - Agency: 444, Number: 555
		System.out.println(references[4]); // Savings Account - Agency: 555, Number: 666

		CheckingAccount referenced = (CheckingAccount) references[0];
		System.out.println(referenced.getNumber()); // 222

		Account ref = (Account) references[2];
		System.out.println(ref.getAgency()); // 333
	}

}
