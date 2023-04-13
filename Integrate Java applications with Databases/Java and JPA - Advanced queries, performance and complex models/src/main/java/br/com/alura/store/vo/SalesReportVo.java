package br.com.alura.store.vo;

import java.time.LocalDate;

public class SalesReportVo {

	private String productName;
	private Long soldQuantity;
	private LocalDate lastSaleDate;

	public SalesReportVo(String productName, Long soldQuantity, LocalDate lastSaleDate) {
		this.productName = productName;
		this.soldQuantity = soldQuantity;
		this.lastSaleDate = lastSaleDate;
	}

	@Override
	public String toString() {
		return "SalesReportVo{" + "productName='" + productName + '\'' + ", soldQuantity=" + soldQuantity + ", lastSaleDate=" + lastSaleDate + '}';
	}

	public String getProductName() {
		return productName;
	}

	public Long getSoldQuantity() {
		return soldQuantity;
	}

	public LocalDate getLastSaleDate() {
		return lastSaleDate;
	}
}
