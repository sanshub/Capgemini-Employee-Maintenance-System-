package com.cg.employeeleaveservice.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_TBL")
public class Leave {
	
	@Id
	@GeneratedValue
	private Integer leaveId;
	private Integer leaveDays;
	private Integer leaveDaysBalance;
	private String leaveStatus;
	private double managerId;
	private double employeeId;
	private Date startDate;
	private Date endDate;
	private String employeeName;
	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	public Integer getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(Integer leaveDays) {
		this.leaveDays = leaveDays;
	}
	public Integer getLeaveDaysBalance() {
		return leaveDaysBalance;
	}
	public void setLeaveDaysBalance(Integer leaveDaysBalance) {
		this.leaveDaysBalance = leaveDaysBalance;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public double getManagerId() {
		return managerId;
	}
	public void setManagerId(double managerId) {
		this.managerId = managerId;
	}
	public double getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(double employeeId) {
		this.employeeId = employeeId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	

}
