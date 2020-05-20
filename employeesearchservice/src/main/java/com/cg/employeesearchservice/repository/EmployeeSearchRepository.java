package com.cg.employeesearchservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employeesearchservice.model.Employee;

public interface EmployeeSearchRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByGender(String gender);

	List<Employee> findByDepartment(String dept);

	List<Employee> findByMaritalStatus(String status);

	Employee findByEmail(String emailId);



}
