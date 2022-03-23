package com.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.rest.model.Employee;
import com.spring.rest.model.PersonalDetails;
import com.spring.rest.repository.EmployeeRepository;
import com.spring.rest.repository.PersonalDetailsRepository;

@SpringBootApplication
public class OneToOneBiMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneBiMappingApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;
	
	@Override
	public void run(String ...args) throws Exception{
		Employee employee = new Employee();
		employee.setName("Mehedi");
		employee.setEmail("mehedi@nsl.com");
		employee.setDept("Software");
		PersonalDetails personalDetails = new PersonalDetails();
		
		personalDetails.setName("Mehedi");
		personalDetails.setEmail("mehedi@gmail.com");
		personalDetails.setMobile("01753250010");
		personalDetails.setAddress("Uttara");
		employee.setPersonalDetails(personalDetails);
		personalDetails.setEmployee(employee);
		
		employeeRepository.save(employee);
		personalDetailsRepository.save(personalDetails);
	
	}

}
