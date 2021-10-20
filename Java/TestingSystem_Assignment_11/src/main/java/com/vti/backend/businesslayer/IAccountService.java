/**
 * 
 */
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

/**
 * @author Duy Anh
 *
 */
public interface IAccountService {

	List<Account> getListAccounts() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	Account getAccountByID(int id) throws Exception;

	List<Account> getAccountByName(String username) throws Exception;

	boolean isAccountExists(String username) throws Exception;

	boolean isAccountExists(int id) throws Exception;

	void createAccount(String email, String username, String fullname)
			throws SQLException, ClassNotFoundException, Exception;

	void updateAccountByID(int id, String email, String username, String fullname)
			throws SQLException, ClassNotFoundException, Exception;
	void deleteAccount(int id)
			throws SQLException, ClassNotFoundException, Exception;
}
