package com.spring.rest.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long Id;
	
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="Dept.")
	private String dept;
	
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="personal_info",referencedColumnName="Id")
	
	@JsonIgnoreProperties({"employee","hibernateLazyInitializer", "handler"})
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	
//	@JsonBackReference
//	@JsonManagedReference
	private PersonalDetails personalDetails;

	public Employee() {
		
	}

	public Employee(String name, String email, String dept) {
		super();
		this.name = name;
		this.email = email;
		this.dept = dept;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	

}
