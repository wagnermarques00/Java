package br.com.bytebank.bank.special;

import br.com.bytebank.bank.model.Account;

public class SpecialAccount extends Account {

	public SpecialAccount(int agency, int number) {
		super(agency, number);
	}

	@Override
	public void deposit(double amount) {
		super.balance += amount;
	}

}
