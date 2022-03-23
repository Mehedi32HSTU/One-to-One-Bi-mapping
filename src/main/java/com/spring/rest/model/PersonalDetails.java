package com.spring.rest.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="personal_info")
public class PersonalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email")
	private String email;
	@Column(name="Mobile")
	private String mobile;
	@Column(name="Address")
	private String address;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="Emp_Id",referencedColumnName="Id")
	@JsonIgnoreProperties({"personalDetails","hibernateLazyInitializer", "handler"})
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	
//	@JsonManagedReference
//	@JsonBackReference
	private Employee employee;

	public PersonalDetails() {
		
	}

	public PersonalDetails(String name, String email, String mobile, String address) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	

}
