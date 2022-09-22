package br.com.bytebank.bank.model;

public interface Taxable {

	double calculateTaxAmount(); // since this is a interface method, there is no need to call "public abstract"

}
