package com.cg.employeeleaveservice.model;

import java.sql.Date;


public class AngularLeave {
	
	private String emailId;
	private Date startDate;
	private Date endDate;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public AngularLeave(String emailId, Date startDate, Date endDate) {
		super();
		this.emailId = emailId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public AngularLeave() {
		super();
	}

	
}
