package br.com.cds.carrental.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CAR_CUSTOMER")
@XmlRootElement(name = "CAR_CUSTOMER")
public class RentCar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7820279509090629321L;

	
	@Id
	private Long carId;
	@Id
	private Long customerId;

	@ManyToOne
	@JoinColumn(name = "CAR_ID", updatable = false, insertable = false)
	/*
	 * if this JPA model doesn't create a table for the "PROJ_EMP" entity,
	 * please comment out the @PrimaryKeyJoinColumn, and use the ff:
	 * 
	 * @JoinColumn(name = "employeeId", updatable = false, insertable = false)
	 * or @JoinColumn(name = "employeeId", updatable = false, insertable =
	 * false, referencedColumnName = "id")
	 */
	private Car car;
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", updatable = false, insertable = false)
	/*
	 * the same goes here: if this JPA model doesn't create a table for the
	 * "PROJ_EMP" entity, please comment out the @PrimaryKeyJoinColumn, and use
	 * the ff:
	 * 
	 * @JoinColumn(name = "projectId", updatable = false, insertable = false)
	 * or @JoinColumn(name = "projectId", updatable = false, insertable = false,
	 * referencedColumnName = "id")
	 */
	
	
	private Customer customer;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public RentCar() {
		super();
	}

	public RentCar(long carId, long customerId) {
		super();
		this.carId = carId;
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentCar other = (RentCar) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RentCar [carId=" + carId + ", customerId=" + customerId + "]";
	}

	

	

}
