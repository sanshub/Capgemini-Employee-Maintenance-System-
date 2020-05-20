package com.cg.employeemaintenanceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.employeemaintenanceservice.model.Employee;
import com.cg.employeemaintenanceservice.model.User;
import com.cg.employeemaintenanceservice.service.EmployeeService;

@CrossOrigin("http://localhost:4200")
@RestController
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@CrossOrigin("http://localhost:4200/add")
	@PostMapping("/employees/addemployee")
	public Employee addEmployee(@RequestBody Employee employee){
		Employee tempEmployee = employeeService.saveEmployee(employee);
		User user = new User(tempEmployee.getEmpId(),tempEmployee.getEmail(),
				    tempEmployee.getPassword());
		restTemplate.postForObject("http://localhost:9200/employeesearch/addemployee", tempEmployee, Employee.class);
		restTemplate.postForObject("http://localhost:9500/sprintems/registeruser", user, User.class);
		restTemplate.getForObject("http://localhost:9500/sprintems/changerole/"+tempEmployee.getManagerId(),User.class);
		return employeeService.saveEmployee(employee);
		
	}
	

}
