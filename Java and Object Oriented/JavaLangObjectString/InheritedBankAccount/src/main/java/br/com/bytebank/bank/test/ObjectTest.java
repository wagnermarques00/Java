package br.com.bytebank.bank.test;

import br.com.bytebank.bank.model.CheckingAccount;
import br.com.bytebank.bank.model.Customer;
import br.com.bytebank.bank.model.SavingsAccount;

public class ObjectTest {

	public static void main(String[] args) {
		System.out.println('x');
		System.out.println(3);
		System.out.println(true);

		Object checkingAccount = new CheckingAccount(111, 222);
		Object savingsAccount = new SavingsAccount(333, 444);
		Object customer = new Customer();

		System.out.println(checkingAccount); // toString -> Checking Account - Agency: 111, Number: 222
		System.out.println(savingsAccount);  // toString -> Savings Account - Agency: 333, Number: 444
		System.out.println(customer);        // toString -> Customer - name: null, clientId: null, profession: null
	}

}
