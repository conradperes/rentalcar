package br.com.cds.carrental.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.cds.carrental.domain.RentCar;
import br.com.cds.carrental.util.JPAUtil;

public class RentalCarDAO implements IRentCarDAO<RentCar, Long> {
	
	private EntityManager entityManager = JPAUtil.getInstance().getEntityManager();
	
	public void delete(Long id) {

		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.getReference(RentCar.class, id));
		entityManager.getTransaction().commit();
		entityManager.close();			
	}


	public List<RentCar> findByName(String name) {
		TypedQuery<RentCar> query = entityManager
				.createQuery("from RentCar c where c.customer.name like :name", RentCar.class);		
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RentCar> findAll() {
		
		return entityManager.createQuery("from RentCar").getResultList();
	}



	@Override
	public void save(RentCar rentCar) {
		entityManager.getTransaction().begin();
		entityManager.persist(rentCar);
		entityManager.getTransaction().commit();
		entityManager.close();	
		
	}





	@Override
	public RentCar findById(Long id) {
		return entityManager.find(RentCar.class, id);
	}





	@Override
	public void update(RentCar rentalCar) {
		entityManager.getTransaction().begin();
		entityManager.merge(rentalCar);
		entityManager.getTransaction().commit();
		entityManager.close();		
	}


	@Override
	public List<RentCar> findByCustomer(String name) {
		TypedQuery<RentCar> query = entityManager
				.createQuery("from RentCar c where c.customer.name like :name", RentCar.class);		
		query.setParameter("name", "%" + name+ "%");
		return query.getResultList();
	}


	@Override
	public List<RentCar> findRent(Long idCustomer, Long idCar, String rentalDate, String returnDate) {
		TypedQuery<RentCar> query = entityManager
				.createQuery("from RentCar c where c.customer.id="+idCustomer
						+" and c.car.id="+idCar
						+" and c.car.rentalDate='"+rentalDate+"'"
						+" and c.car.returnDate='"+returnDate+"'", RentCar.class);		
		return query.getResultList();
	}

}
