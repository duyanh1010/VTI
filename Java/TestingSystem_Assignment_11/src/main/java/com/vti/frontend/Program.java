package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;

public class Program {

	public static void main(String[] args) throws Exception {
		AccountController accountController=new AccountController();
		List<Account> accounts=accountController.getListAccounts();
		for (Account account : accounts) {
			System.out.println(account);
		}
		System.out.println(" cau ve acc by id");
		// acc by id
		Account account=accountController.getAccountByID(2);
		System.out.println(account);
		// cau by username
		System.out.println(" cau ve username");
		List<Account> accountss=accountController.getAccountByName("Anh");
		for (Account account1 : accountss) {
			System.out.println(account1);
		}
		// is username
		System.out.println("check username");
		boolean ktusername=accountController.isAccountExists("Anh");
		System.out.println(ktusername);
		System.out.println("check id ");
		boolean ktid=accountController.isAccountExists(2);
		System.out.println(ktid);
		// create 
	//	accountController.createAccount("cam", "da","en");
		// update
		
	//	accountController.updateAccountByID(1,"duyanhr01@gmail.com","Anhh","NguyenDuyAnhh");
		accountController.deleteAccount(5);
	}

}
