package com.vti.entity;

import java.time.LocalDateTime;

public class Group {
	int groupId;
	String groupName;
	Account creator;
	LocalDateTime createDate;
	Account[] accounts;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Group() {

	}

	public Group(String groupName, Account creator, Account[] accounts, LocalDateTime createDate) {
		this.groupName = groupName;
		this.creator = creator;
		this.accounts = accounts;
		this.createDate = createDate;
	}
	// c) Có các parameter là GroupName, Creator, array String[]
//			usernames , CreateDate

	public Group(String name, Account creator, String[] userNames, LocalDateTime createDate) {
		this.groupName= groupName;
		this.creator = creator;
		this.createDate = createDate;
		// tao Account
		Account[] userAccounts = new Account[userNames.length];
		for (int i = 0; i < userAccounts.length; i++) {
			userAccounts[i] = new Account(i, userNames[i], null, null, null);
		}

	}
}
