package com.cg.loginapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_credentials")
public class User {

	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="email_id")
	private String emailId;
	@Column
	private String password;
	@Column
	private String role;
	
	
	public User(int userId, String emailId, String password, String role) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}
	
	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
