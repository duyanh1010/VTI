package com.vti.entity;
import java.time.LocalDateTime;
import java.util.Date;

public class Account {
	int accountId;
	String email;
	String userName;
	String fullName;
	Department	department;
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", userName=" + userName + ", fullName="
				+ fullName + ", department=" + department + ", createDate=" + createDate + "]";
	}
	Date createDate;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Account(int accountId, String email, String userName, String fullName, Department department,
			Date createDate) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.createDate = createDate;
	}
	
	
}

