package com.vti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Account {
	int accountId;
	String email;
	String userName;
	String firstName;
	String lastName;
	String fullName=firstName+lastName;
	Department	department;
	Position	position;
	LocalDateTime createDate;
	Group[]	groups;
	@Override
	public String toString() {
		String result = "";
		result += "id: " + accountId + "\n";
		result += "email: " + email + "\n";
		result += "userName: " + userName + "\n";
		result += "fullName: " + firstName + " " + lastName + "\n";
		return result;
	}
	//  a khogn tham so
	public Account() {
		
	}
	// b
	public Account(int accountId,String email,String userName,String firstName,String lastName) {
			this.accountId=accountId;
			this.email=email;
			this.userName=userName;
			this.firstName=firstName;
			this.lastName=lastName;
			
		}
	// c
	
	public Account(int accountId,String email,String userName,String firstName,String lastName, Position position,
			LocalDateTime createDate) {
		this.accountId=accountId;
		this.email=email;
		this.userName=userName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.position=position;
		this.createDate=LocalDateTime.now();
	}
	
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public String getUserName() {
		return userName;
	}
	public Group[] getGroups() {
		return groups;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setGroups(Group[] groups) {
		this.groups = groups;
	}
	
	
	
}

