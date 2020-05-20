package com.cg.employeeleaveservice.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.employeeleaveservice.model.Employee;
import com.cg.employeeleaveservice.model.Leave;
import com.cg.employeeleaveservice.repository.LeaveRepository;

@Service
public class LeaveService {
	
	@Autowired
	private LeaveRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public Leave saveLeave(Date startDate,Date endDate,String employeeEmail) {
		Leave leave = new Leave();
		Employee employee = restTemplate.getForObject("http://localhost:9200/getemployeesearch/"+employeeEmail, Employee.class);
		leave.setStartDate(startDate);
		leave.setEndDate(endDate);
		leave.setLeaveStatus("pending");
		long diff = endDate.getTime()-startDate.getTime();
		leave.setLeaveDays((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		leave.setLeaveDaysBalance(12-leave.getLeaveDays());
		leave.setEmployeeId(employee.getEmpId());
		leave.setManagerId(employee.getManagerId());
		leave.setEmployeeName(employee.getFirstName());
		return repository.save(leave);
	}
	
	public List<Leave> getLeaves(){
		return repository.findAll();
	}
	
	public List<Leave> findByManagerId(double managerId){
		List<Leave> queryList =  repository.findByManagerId(managerId);
		List<Leave> managerList = new ArrayList<Leave>();
		String pending = "pending";
		for (Leave leave : queryList) {
			if(leave.getLeaveStatus().equalsIgnoreCase(pending)){
				managerList.add(leave);
			}	
		}
		return managerList;	
	}
	
	public List<Leave> findByEmployeeId(double employeeId){
		return repository.findByEmployeeId(employeeId);
	}

	public String changeLeaveStatus(Integer leaveId, String status) {
		Leave leave = repository.findById(leaveId).orElse(null);
		leave.setLeaveStatus(status);
		repository.save(leave);
		return "Leave Status Updated";
	}

}
