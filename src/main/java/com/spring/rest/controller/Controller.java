package com.spring.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.exception.ResourceNotFoundException;
import com.spring.rest.model.Employee;
import com.spring.rest.model.PersonalDetails;
import com.spring.rest.repository.EmployeeRepository;
import com.spring.rest.repository.PersonalDetailsRepository;

@RestController
@RequestMapping("/onetoonebi")
public class Controller {
	
//	Employee Controller
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	Fetch all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
//		System.out.println(this.employeeRepository);
		return this.employeeRepository.findAll();
	}
//	Get individual employee
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable (value="id") Long employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found ::" + employeeId));
		return ResponseEntity.ok().body(employee);
	}
	
//	Save employee into database
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
//	Update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee( @PathVariable (value="id") Long employeeId, @Validated @RequestBody
			Employee employeeDetails) throws ResourceNotFoundException
	{
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found ::" + employeeId));
		employee.setName(employeeDetails.getName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setDept(employeeDetails.getDept());
		employee.setPersonalDetails(employeeDetails.getPersonalDetails());
		
		return ResponseEntity.ok(this.employeeRepository.save(employee));
	}
	
//	Delete employee
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) 
		throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(employeeId)
		        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		this.employeeRepository.delete(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted Successfully.", Boolean.TRUE);
		
		return response;
	}
	
	
//	Personal Details Controller
	
	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;
	
//	Fetch all PersonalDetails
	@GetMapping("/personalinfo")
	public List<PersonalDetails> getAllPersonalDetails()
	{
		return this.personalDetailsRepository.findAll();
	}
	
//	Get individual PersonalDetails
	@GetMapping("/personalinfo/{id}")
	public ResponseEntity<PersonalDetails> getPersonalDetailsById(@PathVariable (value="id") Long personalDetailsId) throws ResourceNotFoundException {
		PersonalDetails personalDetails = personalDetailsRepository.findById(personalDetailsId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found ::" + personalDetailsId));
		return ResponseEntity.ok().body(personalDetails);
	}
	
//	save personal info into database
	@PostMapping("/personalinfo")
	public PersonalDetails createPersonalDetails(@RequestBody PersonalDetails personalDetails)
	{
		return personalDetailsRepository.save(personalDetails);
	}
	

	
	
	
	

}
