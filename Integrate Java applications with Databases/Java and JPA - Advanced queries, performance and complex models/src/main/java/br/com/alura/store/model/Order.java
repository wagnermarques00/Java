package br.com.alura.store.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "registration_date")
	private LocalDate registrationDate = LocalDate.now();

	@Column(name = "order_total")
	private BigDecimal orderTotal;

	@ManyToOne
	private Customer customer;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // bidirectional relationship
	private List<OrderProduct> orderProducts = new ArrayList<>();

	public Order() {
	}

	public Order(Customer customer) {
		this.customer = customer;
	}

	public void addProduct(OrderProduct item) {
		item.setOrder(this);
		this.orderProducts.add(item);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
}
