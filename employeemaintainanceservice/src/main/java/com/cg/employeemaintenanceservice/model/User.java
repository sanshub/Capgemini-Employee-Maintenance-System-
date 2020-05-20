package com.cg.employeemaintenanceservice.model;

public class User {
	
	private Integer userId;
	private String emailId;
	private String password;
	private String role;
	
	public User(Integer userId, String emailId, String password) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.role = "Employee";
	}
	
	public User() {
		super();
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
