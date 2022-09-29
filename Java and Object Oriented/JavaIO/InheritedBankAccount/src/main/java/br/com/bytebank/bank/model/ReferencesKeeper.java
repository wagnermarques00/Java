package br.com.bytebank.bank.model;

public class ReferencesKeeper {
	private  Object[] references;
	private int freePosition;

	public ReferencesKeeper() {
		this.references = new Object[10];
		this.freePosition = 0;
	}

	public void add(Object account) {
		this.references[this.freePosition] = account;
		this.freePosition++;
	}

	public int getNumberElements() {
		return this.freePosition;
	}

	public Object getReference(int position) {
		return this.references[position];
	}

}
