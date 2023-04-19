package br.com.alura.store.dao;

import br.com.alura.store.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProductDAO {

	private EntityManager entityManager;

	public ProductDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Product product) {
		this.entityManager.persist(product);
	}

	public void update(Product product) {
		this.entityManager.merge(product);
	}

	public void delete(Product product) {
		product = entityManager.merge(product);
		this.entityManager.remove(product);
	}

	public List<Product> findAll() {
		String JPQL_SELECT_STATEMENT = "SELECT p FROM Product p";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, Product.class).getResultList();
	}

	public List<Product> findByCategoryName(String name) {
		String JPQL_SELECT_STATEMENT = "SELECT p FROM Product p WHERE p.category.name = :name";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, Product.class)
							.setParameter("name", name)
							.getResultList();
	}

	public Product findById(Long id) {
		return entityManager.find(Product.class, id);
	}

	public List<Product> findByName(String name) {
		String JPQL_SELECT_STATEMENT = "SELECT p FROM Product p WHERE p.name = :name";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, Product.class)
							.setParameter("name", name)
							.getResultList();
	}

	public List<Product> findByParameters(String name, BigDecimal price, LocalDate registrationDate) {
		String jpqlSelectStatement = "SELECT p FROM Product p WHERE 1=1 ";
		if(name != null && !name.trim().isEmpty()) {
			jpqlSelectStatement = "AND p.name = :name ";
		}
		if(price != null) {
			jpqlSelectStatement = "AND p.price = :price ";
		}
		if(registrationDate != null) {
			jpqlSelectStatement = "AND p.registrationDate = :registrationDate ";
		}

		TypedQuery<Product> typedQuery = entityManager.createQuery(jpqlSelectStatement, Product.class);
		if(name != null && !name.trim().isEmpty()) {
			typedQuery.setParameter("name", name);
		}
		if(price != null) {
			typedQuery.setParameter("price", price);
		}
		if(registrationDate != null) {
			typedQuery.setParameter("registrationDate", registrationDate);
		}

		return typedQuery.getResultList();
	}

	public List<Product> findByParametersWithCriteria(String name, BigDecimal price, LocalDate registrationDate) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> from = criteriaQuery.from(Product.class);

		Predicate filters = criteriaBuilder.and();
		if(name != null && !name.trim().isEmpty()) {
			filters = criteriaBuilder.and(filters, criteriaBuilder.equal(from.get("name"), name));
		}
		if(price != null) {
			filters = criteriaBuilder.and(filters, criteriaBuilder.equal(from.get("price"), price));
		}
		if(registrationDate != null) {
			filters = criteriaBuilder.and(filters, criteriaBuilder.equal(from.get("registrationDate"), registrationDate));
		}

		criteriaQuery.where(filters);

		return entityManager.createQuery(criteriaQuery).getResultList();
	}


	public BigDecimal findProductPriceByName(String name) {
		String JPQL_SELECT_STATEMENT = "SELECT p.price FROM Product p WHERE p.name = :name";
		return entityManager.createQuery(JPQL_SELECT_STATEMENT, BigDecimal.class)
							.setParameter("name", name)
							.getSingleResult();
	}

}
