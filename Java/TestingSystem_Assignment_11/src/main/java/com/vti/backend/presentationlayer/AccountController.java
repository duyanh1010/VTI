package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.backend.datalayer.AccountRepository;
import com.vti.entity.Account;

public class AccountController {

	private IAccountService accountService;

	public AccountController() {
		accountService = new AccountService();
	}

	public List<Account> getListAccounts()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return accountService.getListAccounts();
	}

	public Account getAccountByID(int id) throws Exception {
		return accountService.getAccountByID(id);
	}

	public List<Account> getAccountByName(String username) throws Exception {
		return accountService.getAccountByName(username);
	}
	public boolean isAccountExists(String username) throws Exception {
		return accountService.isAccountExists(username);
	}
	public boolean isAccountExists(int id) throws Exception {
		return accountService.isAccountExists(id);
	}
	public void createAccount(String email, String username, String fullname)
			throws SQLException, ClassNotFoundException, Exception {
		accountService.createAccount( email, username, fullname);
	}
	public void  updateAccountByID(int id, String email, String username, String fullname)
			throws SQLException, ClassNotFoundException, Exception {
		accountService.updateAccountByID(id, email, username, fullname);
	}
	public void  deleteAccount(int id)
			throws SQLException, ClassNotFoundException, Exception {
		accountService.deleteAccount(id);
	}
}
