package com.vti.entity;

public class Account {
	private int accountId;
	private String email;
	private String username;
	private String fullname;

	public Account() {
	}

	
	public Account(int accountID,String email, String username, String fullName) {
		this.accountId = accountID;
		this.email = email;
		this.username = username;
		this.fullname = fullName;
	}

	public int getAccountID() {
		return accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getFullName() {
		return fullname;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", username=" + username + ", fullname="
				+ fullname + "]";
	}

	

}
