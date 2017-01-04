package br.com.cds.carrental.dao;

import java.io.Serializable;
import java.util.List;

public interface ICustomerDAO<T, PK extends Serializable> {

	void save(T customer);
	
	void update(T customer);
	
	void delete(PK id);
	
	T findById(PK id);
	
	List<T> findByCpf(String cpf);
	
	List<T> findByCnpj(String cnpj);
	
	List<T> findExactCpf(String cpf);
	
	List<T> findAll();

}
