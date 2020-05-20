package com.cg.employeeleaveservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employeeleaveservice.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {

	List<Leave> findByManagerId(double managerId);

	List<Leave> findByEmployeeId(double employeeId);

}
