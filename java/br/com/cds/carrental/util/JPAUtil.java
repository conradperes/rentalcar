package br.com.cds.carrental.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cds.carrental.domain.Customer;

public class JPAUtil {
	
	private EntityManagerFactory factory;
	
	private static JPAUtil instance;

	private JPAUtil() {
		this.factory = Persistence.createEntityManagerFactory("JPAUtil");
	}

	public static synchronized JPAUtil getInstance() {
		if (instance == null) {
			instance = new JPAUtil();
			instance.new PopulatingDatabase(instance.factory).loadScriptSQL();
		}
		return instance;
	}
	
	public EntityManager getEntityManager() {
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
	
	class PopulatingDatabase {	
		
		private EntityManagerFactory factory;		
	
		public PopulatingDatabase(EntityManagerFactory factory) {
			this.factory = factory;
		}

		public void loadScriptSQL() {
			
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(new Customer("Joana Pires","Pires",new Date().toString(),"053.546.757-58","","342342934", "9192-0595", "Rua barao de mesquita","30797117"));
			customers.add(new Customer("Joana Pires","Pires",new Date().toString(),"053.546.757-58","","342342934" , "9192-0595","Rua barao de mesquita", "30797117"));
			customers.add(new Customer("Joana Pires","Pires",new Date().toString(),"053.546.757-58","","342342934" , "9192-0595","Rua barao de mesquita", "30797117"));
			customers.add(new Customer("Joana Pires","Pires",new Date().toString(),"053.546.757-58","","342342934" , "9192-0595","Rua barao de mesquita", "30797117"));
			customers.add(new Customer("Joana Pires","Pires",new Date().toString(),"053.546.757-58","","342342934" , "9192-0595","Rua barao de mesquita", "30797117"));

			customers.forEach(c -> setDefaultEntity(c));		
		}
		
		private void setDefaultEntity(Customer cutomer) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(cutomer);
			em.getTransaction().commit();
			em.close();		
		}  
	}
}
