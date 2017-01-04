package br.com.cds.carrental.dao;

import java.io.Serializable;
import java.util.List;

public interface IRentCarDAO<T, PK extends Serializable> {

	void save(T rentCar);
	
	void update(T rentCar);
	
	void delete(PK id);
	
	T findById(PK id);
	
	List<T> findByCustomer(String name);
	
	List<T> findAll();
	
	List<T>findRent(Long idCustomer, Long idCar, String rentalDate,String  returnDate );

}
