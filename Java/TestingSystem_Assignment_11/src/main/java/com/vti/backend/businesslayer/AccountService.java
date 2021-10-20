package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {

	private IAccountRepository accountRepository;

	public AccountService() {
		accountRepository = new AccountRepository();
	}

	public List<Account> getListAccounts()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return accountRepository.getListAccounts();
	}

	public Account getAccountByID(int id) throws Exception {
		return accountRepository.getAccountByID(id);
	}

	public List<Account> getAccountByName(String username) throws Exception {
		return accountRepository.getAccountByName(username);
	}
	public boolean isAccountExists(String username) throws Exception {
		return accountRepository.isAccountExists(username);
	}
	public boolean isAccountExists(int id) throws Exception {
		return accountRepository.isAccountExists(id);
	}
	public void createAccount(String email, String username, String fullname)
			throws SQLException, ClassNotFoundException, Exception {
		accountRepository.createAccount( email, username, fullname);
	}
	public void updateAccountByID(int id, String email, String username, String fullname)
			throws SQLException, ClassNotFoundException, Exception {
		accountRepository.updateAccountByID(id, email, username, fullname);
	}
	public void deleteAccount(int id)
			throws SQLException, ClassNotFoundException, Exception {
		accountRepository.deleteAccount(id);
	}

}
