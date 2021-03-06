package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForCreatingRegister;
import com.vti.form.AccountFormForUpdating;

public interface IAccountService extends UserDetailsService {
	public Page<Account> getAllAccount(Pageable pageable, String search);
	
	public List<Account> getAllAccount();

	public Account getAccountById(short id);

	public Account getAccountByName(String name);

	public void createAccount(AccountFormForCreating form);

	public void updateAccount(short id, AccountFormForUpdating form);

	public void deleteAccount(short id);

	public boolean isAccountExistsByID(short id);

	public boolean isAccountExistsByName(String name);
	
	public boolean existsByUsername(String name);
	
	public boolean existsByEmail(String email);
	
	Account getAccountByUsername(String username);
	
	public Account getAccountByEmail(String email);
	
	public void createAccountRegister(AccountFormForCreatingRegister form);

	public void activeUser(String token);
	
	public void sendConfirmUserRegistrationViaEmail(String email);

}
