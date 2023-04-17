package br.com.alura.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_products")
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	public OrderProduct() {
	}

	public OrderProduct(int quantity, Order order, Product product) {
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = product.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getItemTotalValue() {
		return unitPrice.multiply(new BigDecimal(quantity));
	}
}
