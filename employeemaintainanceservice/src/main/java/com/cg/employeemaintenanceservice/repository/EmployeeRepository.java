package com.cg.employeemaintenanceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employeemaintenanceservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	List<Employee> findByGender(String gender);
//
//	List<Employee> findByDepartment(String dept);
//
//	List<Employee> findByMaritalStatus(String status);
//
//	Employee findByEmail(String emailId);



}
