package br.com.cds.carrental.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.cds.carrental.domain.Customer;
import br.com.cds.carrental.util.JPAUtil;

public class CustomerDAO implements ICustomerDAO<Customer, Long> {
	
	private EntityManager entityManager = JPAUtil.getInstance().getEntityManager();
	
	public void save(Customer customer) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();
		entityManager.close();		
	}

	public void update(Customer customer) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(customer);
		entityManager.getTransaction().commit();
		entityManager.close();		
	}

	public void delete(Long id) {

		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.getReference(Customer.class, id));
		entityManager.getTransaction().commit();
		entityManager.close();			
	}

	public Customer findById(Long id) {
		
		return entityManager.find(Customer.class, id);
	}

	public List<Customer> findByName(String name) {
		TypedQuery<Customer> query = entityManager
				.createQuery("from Customer c where c.name like :name", Customer.class);		
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		
		return entityManager.createQuery("from Customer").getResultList();
	}

	public List<Customer> findByCpf(String cpf) {
		TypedQuery<Customer> query = entityManager
				.createQuery("from Customer c where c.cpf like :cpf", Customer.class);		
		query.setParameter("cpf", "%" + cpf + "%");
		return query.getResultList();
	}

	public List<Customer> findByCnpj(String cnpj) {
		TypedQuery<Customer> query = entityManager
				.createQuery("from Customer c where c.cnpj like :cnpj", Customer.class);		
		query.setParameter("cnpj", "%" + cnpj + "%");
		return query.getResultList();
	}

}
