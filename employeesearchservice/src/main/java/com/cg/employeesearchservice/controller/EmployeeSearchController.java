package com.cg.employeesearchservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.employeesearchservice.model.Employee;
import com.cg.employeesearchservice.service.EmployeeSearchService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class EmployeeSearchController {
	
	@Autowired
    private EmployeeSearchService employeeService;

	@CrossOrigin("http://localhost:4200")
    @GetMapping("/employeesearch/search")
    public List<Employee> fetchAll() {
        return employeeService.getEmployees();
    }

	@CrossOrigin("http://localhost:4200")
    @GetMapping("/employeesearch/search/gender/{gender}")
    public List<Employee> fetchByGenders(@PathVariable String gender) {
        return employeeService.getEmployeesByGender(gender);
    }

	@CrossOrigin("http://localhost:4200")
    @GetMapping("/employeesearch/search/department/{dept}")
    public List<Employee> fetchByDepartment(@PathVariable String dept) {
        return employeeService.getEmployeesByDepartment(dept);
    }

	@CrossOrigin("http://localhost:4200")
    @GetMapping("/employeesearch/search/maritalstatus/{status}")
    public List<Employee> fetchByMaritalStatus(@PathVariable String status) {
        return employeeService.getEmployeesByStatus(status);
    }

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getemployeesearch/{emailId}")
	public Employee fetchByEmailId(@PathVariable String emailId) {
		return employeeService.getEmpoyeeByEmailId(emailId);
	}
	
	@PostMapping("/employeesearch/addemployee")
	public Employee addEmployee(@RequestBody Employee employee){
		return employeeService.saveEmployee(employee);
		
	}
	

}
