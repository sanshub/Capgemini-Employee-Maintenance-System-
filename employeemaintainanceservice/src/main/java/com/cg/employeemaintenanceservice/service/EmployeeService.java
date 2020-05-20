package com.cg.employeemaintenanceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeemaintenanceservice.model.Employee;
import com.cg.employeemaintenanceservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	
	public Employee saveEmployee(Employee employee) {
		
		return repository.save(employee);
	}
	

}
