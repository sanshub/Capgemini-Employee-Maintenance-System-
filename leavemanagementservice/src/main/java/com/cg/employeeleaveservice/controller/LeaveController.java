package com.cg.employeeleaveservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeeleaveservice.model.AngularLeave;
import com.cg.employeeleaveservice.model.Leave;
import com.cg.employeeleaveservice.service.LeaveService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LeaveController {
	
	@Autowired
	private LeaveService service;
	
	
	@GetMapping("/leaves")
	public List<Leave> findAllLeaves(){
		return service.getLeaves();
	}

	@CrossOrigin(origins="http://localhost:4200/applyleave/")
	@PostMapping("/addleave")
	public Leave addleave(@RequestBody AngularLeave angularLeaveObj) {
		return service.saveLeave(angularLeaveObj.getStartDate(),angularLeaveObj.
				getEndDate(),angularLeaveObj.getEmailId());
	}
	
	@CrossOrigin(origins="http://localhost:4200/managerleavelist/")
	@GetMapping("/managerleavelist/{managerId}")
	public List<Leave> getManagerLeaveList(@PathVariable double managerId){
		return service.findByManagerId(managerId);
	}
	
	@CrossOrigin(origins="http://localhost:4200/employeeleavelist/")
	@GetMapping("/employeeleavelist/{employeeId}")
	public List<Leave> getEmployeeLeaveList(@PathVariable double employeeId){
		return service.findByEmployeeId(employeeId);
	}
	
	@CrossOrigin(origins="http://localhost:4200/managerleavelist")
	@GetMapping("/updateleave/approve/{leaveId}")
	public String approveLeave(@PathVariable Integer leaveId) {		
		return service.changeLeaveStatus(leaveId,"approved");
	}
	@CrossOrigin(origins="http://localhost:4200/managerleavelist")
	@GetMapping("/updateleave/reject/{leaveId}")
	public String rejectLeave(@PathVariable Integer leaveId) {		
		return service.changeLeaveStatus(leaveId,"rejected");
	}
	
	

}
