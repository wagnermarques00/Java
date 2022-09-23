package br.com.bytebank.bank.model;

public class AccountsKeeper {
	private final Account[] references;
	private int freePosition;

	public AccountsKeeper() {
		this.references = new Account[10];
		this.freePosition = 0;
	}

	public void add(Account account) {
		this.references[this.freePosition] = account;
		this.freePosition++;
	}

	public int getNumberElements() {
		return this.freePosition;
	}

	public Account getReference(int position) {
		return this.references[position];
	}

}
