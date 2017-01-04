package br.com.cds.carrental.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.cds.carrental.domain.Car;
import br.com.cds.carrental.domain.Customer;
import br.com.cds.carrental.util.JPAUtil;

public class CarDAO implements ICarDAO<Car, Long> {
	
	private EntityManager entityManager = JPAUtil.getInstance().getEntityManager();
	
	public void delete(Long id) {

		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.getReference(Customer.class, id));
		entityManager.getTransaction().commit();
		entityManager.close();			
	}

	public Car findById(Long id) {
		
		return entityManager.find(Car.class, id);
	}

	public List<Car> findByName(String name) {
		TypedQuery<Car> query = entityManager
				.createQuery("from Car c where c.name like :name", Car.class);		
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Car> findAll() {
		
		return entityManager.createQuery("from Car").getResultList();
	}



	@Override
	public void save(Car car) {
		entityManager.getTransaction().begin();
		entityManager.persist(car);
		entityManager.getTransaction().commit();
		entityManager.close();	
		
	}

	@Override
	public void update(Car car) {
		entityManager.getTransaction().begin();
		entityManager.merge(car);
		entityManager.getTransaction().commit();
		entityManager.close();	
	}


	@Override
	public List<Car> findByProperties(String name, String rentalDate, String returnDate) {
		TypedQuery<Car> query = entityManager
				.createQuery("from Car c where c.name like :name"
						+ " and c.rentalDate like :rentalDate"
						+ " and c.returnDate like :returnDate ", Car.class);		
		query.setParameter("name", "%" + name + "%");
		query.setParameter("rentalDate", "%" + rentalDate + "%");
		query.setParameter("returnDate", "%" + returnDate + "%");
		return query.getResultList();
	}

}
