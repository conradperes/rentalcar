package br.com.cds.carrental.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cds.carrental.dao.CarDAO;
import br.com.cds.carrental.dao.CustomerDAO;
import br.com.cds.carrental.domain.Car;
import br.com.cds.carrental.domain.Customer;
import br.com.cds.carrental.domain.RentCar;

public class JPAUtil {

	private EntityManagerFactory factory;

	private static JPAUtil instance;

	private JPAUtil() {
		this.factory = Persistence.createEntityManagerFactory("JPAUtil");
	}

	public static synchronized JPAUtil getInstance() {
		if (instance == null) {
			instance = new JPAUtil();
			instance.new PopulatingDatabase(instance.factory).loadCustomerScriptSQL();
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

		public void loadCustomerScriptSQL() {

			List<Customer> customers = new ArrayList<Customer>();
			customers.add(new Customer("Joana Pires", "Pires", new Date().toString(), "053.546.757-58", "", "342342934",
					"9192-0595", "Rua barao de mesquita", "30797117"));
			customers.add(new Customer("Joana Pires", "Pires", new Date().toString(), "053.546.757-58", "", "342342934",
					"9192-0595", "Rua barao de mesquita", "30797117"));
			customers.add(new Customer("Joana Pires", "Pires", new Date().toString(), "053.546.757-58", "", "342342934",
					"9192-0595", "Rua barao de mesquita", "30797117"));
			customers.add(new Customer("Joana Pires", "Pires", new Date().toString(), "053.546.757-58", "", "342342934",
					"9192-0595", "Rua barao de mesquita", "30797117"));
			customers.add(new Customer("Joana Pires", "Pires", new Date().toString(), "053.546.757-58", "", "342342934",
					"9192-0595", "Rua barao de mesquita", "30797117"));

			customers.forEach(c -> setDefaultEntity(c));
			loadCarScriptSQL();
			loadSelectCarAndCustomesScriptSQL();
			loadRentCarScriptSQL();
		}
		public void loadSelectCarAndCustomesScriptSQL() {
			CustomerDAO cusDao = new CustomerDAO();
			cusDao.findAll().forEach(c->System.out.println(c));
			CarDAO carDao = new CarDAO();
			carDao.findAll().forEach(c->System.out.println(c));
			
			
		}
		public void loadCarScriptSQL() {

			List<Car> car = new ArrayList<Car>();
			car.add(new Car("Ferrari", new Date().toString(), "09/01/2017", "500", "0", "100"));
			car.add(new Car("BMW", new Date().toString(), "09/01/2017", "500", "0", "100"));
			car.add(new Car("Lamborguini", new Date().toString(), "09/01/2017", "500", "0", "100"));
			car.add(new Car("Camaro", new Date().toString(), "09/01/2017", "500", "0", "100"));
			car.add(new Car("Mustang", new Date().toString(), "09/01/2017", "500", "0", "100"));
			car.add(new Car("DS5", new Date().toString(), "09/01/2017", "500", "0", "100"));
			car.add(new Car("Mitsubish", new Date().toString(), "09/01/2017", "500", "0", "100"));
			car.add(new Car("Volvo", new Date().toString(), "09/01/2017", "500", "0", "100"));
			car.forEach(c -> setCarEntity(c));
		}

		private void setCarEntity(Car c) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();
		}

		public void loadRentCarScriptSQL() {

			List<Car> cars = new ArrayList<Car>();
			Car c1 = new Car("Ferrari", new Date().toString(), "09/01/2017", "500", "0", "100");
			Car c2 = new Car("BMW", new Date().toString(), "09/01/2017", "500", "0", "100");
			Customer customer1 = new Customer("Joana Pires", "Pires", new Date().toString(), "053.546.757-58", "",
					"342342934", "9192-0595", "Rua barao de mesquita", "30797117");
			Customer customer2 = new Customer("Conrad Peres", "marques", new Date().toString(), "053.546.757-58", "",
					"342342934", "9192-0595", "Rua barao de mesquita", "30797117");
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customer1);
			customers.add(customer2);
			// c1.setCustomers(customers);
			// c2.setCustomers(customers);
			cars.add(c1);
			cars.add(c2);
			//cars.forEach(c -> setCarEntity(c));
			List<RentCar> rents = new ArrayList<RentCar>();
			RentCar rent = new RentCar(1,1);
			RentCar rent2 = new RentCar(2,2);
			rent.setCar(c1);
			rent.setCustomer(customer1);
			rent2.setCar(c2);
			rent2.setCustomer(customer2);
			rents.add(rent);
			rents.add(rent2);
			rents.forEach(r->setRentCarEntity(r));
			
		}

		private void setRentCarEntity(RentCar c) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();
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
