package br.com.cds.carrental.dao;

import java.io.Serializable;
import java.util.List;

public interface ICarDAO<T, PK extends Serializable> {

	void save(T car);
	
	void update(T car);
	
	void delete(PK id);
	
	T findById(PK id);
	
	List<T> findByProperties(String name, String rentalDate, String returnDate);
	
	List<T> findAll();

}
