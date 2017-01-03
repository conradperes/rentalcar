package br.com.cds.carrental.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CUSTOMERS")
@XmlRootElement(name="customers")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1885848865314189135L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
	public Customer() {
		super();
	}

	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", motherName=" + motherName + ", BirthDate=" + BirthDate
				+ ", cpf=" + cpf + ", cnpj=" + cnpj + ", cnh=" + cnh + ", cellPhone=" + cellPhone + ", address="
				+ address + ", phone=" + phone + "]";
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



	@XmlElement(name="id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@XmlElement(name="motherName")
	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	@XmlElement(name="bithDate")
	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	@XmlElement(name="cpf")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@XmlElement(name="cnpj")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	@XmlElement(name="cnh")
	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	@XmlElement(name="cellPhone")
	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	@XmlElement(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	}
