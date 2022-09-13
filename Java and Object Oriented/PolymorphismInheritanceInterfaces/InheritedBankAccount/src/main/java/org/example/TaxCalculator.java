package org.example;

public class TaxCalculator {
	private double totalTax;

	public void register(Taxable taxable) {
		this.totalTax += taxable.calculateTaxAmount();
	};

	public double getTotalTax() {
		return totalTax;
	}

}
