package br.com.cds.carrental.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CUSTOMERS")
@XmlRootElement(name = "customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1885848865314189135L;

	@Id
	@Column(name="CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(columnDefinition = "VARCHAR_IGNORECASE")
	private String name;

	private String motherName;

	private String BirthDate;

	private String cpf;

	private String cnpj;

	private String cnh;

	private String cellPhone;

	private String address;

	private String phone;

	@ManyToMany
	@JoinTable(name = "CAR_CUSTOMER",
		      joinColumns=@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID"),
		      inverseJoinColumns=@JoinColumn(name="CAR_ID", referencedColumnName="CAR_ID"))
	private List<Car> cars;

	public Customer() {
		super();
	}

	public Customer(String name, String motherName, String birthDate, String cpf, String cnpj, String cnh,
			String cellPhone, String address, String phone) {
		super();
		this.name = name;
		this.motherName = motherName;
		BirthDate = birthDate;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.cnh = cnh;
		this.cellPhone = cellPhone;
		this.address = address;
		this.phone = phone;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@XmlElement(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@XmlElement(name = "motherName")
	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@XmlElement(name = "bithDate")
	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	@XmlElement(name = "cpf")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@XmlElement(name = "cnpj")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@XmlElement(name = "cnh")
	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	@XmlElement(name = "cellPhone")
	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	@XmlElement(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Customer other = (Customer) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", motherName=" + motherName + ", BirthDate=" + BirthDate
				+ ", cpf=" + cpf + ", cnpj=" + cnpj + ", cnh=" + cnh + ", cellPhone=" + cellPhone + ", address="
				+ address + ", phone=" + phone + "]";
	}

}
