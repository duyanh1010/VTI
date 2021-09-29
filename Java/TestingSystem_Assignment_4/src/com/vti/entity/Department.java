package com.vti.entity;
public class Department {
	byte departmentId;
	String departmentName;
	Account[] accounts;
	// contructor
	public Department (byte departmentId,String departmentName) {
		this.departmentId=departmentId;
		this.departmentName=departmentName;
	}
	public Department() {
		
	}
	@Override
	public java.lang.String toString() {
		java.lang.String result = "";
		result += "id: " + departmentId + "\n";
		result += "name: " + departmentName + "\n";
		return result;
	}
	public byte getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(byte departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

}
