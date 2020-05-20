package com.cg.employeesearchservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeesearchservice.model.Employee;
import com.cg.employeesearchservice.repository.EmployeeSearchRepository;

@Service
public class EmployeeSearchService {
	
	@Autowired
	private EmployeeSearchRepository repository;
	
	public List<Employee> getEmployees(){
		return repository.findAll();
	}

	public List<Employee> getEmployeesByGender(String gender) {
		return repository.findByGender(gender);
	}

	public List<Employee> getEmployeesByDepartment(String dept) {
		return repository.findByDepartment(dept);
	}

	public List<Employee> getEmployeesByStatus(String status) {
		return repository.findByMaritalStatus(status);
	}
	
	public Employee getEmpoyeeByEmailId(String emailId) {
		return repository.findByEmail(emailId);
	}

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	
	

}
