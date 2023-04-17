package br.com.alura.store.dao;

import br.com.alura.store.model.Order;
import br.com.alura.store.vo.SalesReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDAO {

	private EntityManager entityManager;

	public OrderDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<SalesReportVo> salesReport() {
		String JPQL_SELECT_STATEMENT = "SELECT new br.com.alura.store.vo.SalesReportVo" +
				"(p.name, SUM(item.quantity), MAX(o.registrationDate)) " +
				"FROM Order o " +
				"JOIN o.orderProducts item " +
				"JOIN item.product p " +
				"GROUP BY p.name " +
				"ORDER BY item.quantity DESC";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, SalesReportVo.class).getResultList();
	}

	public void create(Order order) {
		this.entityManager.persist(order);
	}

	public Order findById(Long id) {
		return entityManager.find(Order.class, id);
	}

	public BigDecimal calculateTotalSalesValue() {
		String JPQL_SELECT_STATEMENT = "SELECT SUM(o.orderTotal) FROM Order o";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, BigDecimal.class).getSingleResult();
	}

	public Order findOrderByIdWithCustomer(Long id) {
		String SELECT_STATEMENT = "SELECT o FROM Order o JOIN FETCH o.customer WHERE o.id = :id";
		return entityManager.createQuery(SELECT_STATEMENT, Order.class)
							.setParameter("id", id)
							.getSingleResult();
	}

}
