package com.vti.backend.datalayer;

import com.vti.utils.JDBCUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Account;

public class AccountRepository implements IAccountRepository {

	private JDBCUtils jdbcUtils;

	public AccountRepository() {
		jdbcUtils = new JDBCUtils();
	}

	// get list
	public List<Account> getListAccounts()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Account> accounts = new ArrayList<Account>();
		// get conection
		Connection connection = jdbcUtils.getConnection();
		String sql = "SELECT *FROM `Account` ";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql); // cau truy van co dinh moi dung
		while (resultSet.next()) {
			Account account = new Account(resultSet.getInt("AccountID"), resultSet.getString("Email"),
					resultSet.getString("Username"), resultSet.getString("Fullname"));
			accounts.add(account);
		}
		jdbcUtils.disconnect();
		return accounts;
	}

	// get acc by id
	public Account getAccountByID(int id) throws Exception {
		// List<Account> accounts = new ArrayList<Account>();
		// get conection
		Connection connection = jdbcUtils.getConnection();
		String sql = "SELECT *FROM `Account`WHERE AccountID=? ";
		PreparedStatement pr = connection.prepareStatement(sql);
		pr.setInt(1, id);

		ResultSet resultSet = pr.executeQuery();

		// Step6: Handling result Set
		if (resultSet.next()) {
			Account account = new Account(resultSet.getInt("AccountID"), resultSet.getString("Email"),
					resultSet.getString("Username"), resultSet.getString("Fullname"));
			return account;
		} else {
			throw new Exception("Cannot find Account " + id);
		}
	}

	// isAccountExists(String username),
	public List<Account> getAccountByName(String username) throws Exception {
		List<Account> accounts = new ArrayList<Account>();
		// get conection
		Connection connection = jdbcUtils.getConnection();
		String sql = "SELECT *FROM `Account`WHERE Username=? ";
		PreparedStatement pr = connection.prepareStatement(sql);
		pr.setString(1, username);

		ResultSet resultSet = pr.executeQuery();
		// dung while vi th co 2 username trung nhau
		try {

			while (resultSet.next()) {
				Account account = new Account(resultSet.getInt("AccountID"), resultSet.getString("Email"),
						resultSet.getString("Username"), resultSet.getString("Fullname"));
				accounts.add(account);
			}
			jdbcUtils.disconnect();
			return accounts;
			// Step6: Handling result Set
		} catch (Exception e) {

			throw new Exception("Cannot find Account " + username);
		}
	}

	// is name exist
	public boolean isAccountExists(String username) throws Exception {

		Connection connection = jdbcUtils.getConnection();
		String sql = "SELECT *FROM `Account`WHERE Username=? ";
		PreparedStatement pr = connection.prepareStatement(sql);
		pr.setString(1, username);
		ResultSet resultSet = pr.executeQuery();
		// Step6: Handling result Set
		if (resultSet.next()) {
			Account account = new Account(resultSet.getInt("AccountID"), resultSet.getString("Email"),
					resultSet.getString("Username"), resultSet.getString("Fullname"));
			return true;
		} else {

			return false;
		}
	}

	public boolean isAccountExists(int id) throws Exception {

		Connection connection = jdbcUtils.getConnection();
		String sql = "SELECT *FROM `Account`WHERE AccountID=? ";
		PreparedStatement pr = connection.prepareStatement(sql);
		pr.setInt(1, id);
		ResultSet resultSet = pr.executeQuery();
		// Step6: Handling result Set
		if (resultSet.next()) {
			Account account = new Account(resultSet.getInt("AccountID"), resultSet.getString("Email"),
					resultSet.getString("Username"), resultSet.getString("Fullname"));
			return true;
		} else {

			return false;
		}
	}

	// create
	public void createAccount(String email, String username, String fullname)
			throws SQLException, ClassNotFoundException, Exception {

		if (isAccountExists(username) == true) {
			throw new Exception("Account Name isExists!");
		} else {
			Connection connection = jdbcUtils.getConnection();
			String sql = "INSERT INTO `Account` (Email,Username,FullName,DepartmentID,PositionID) VALUES (?,?,?,1,1)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setString(3, fullname);

			ps.executeUpdate();

			System.out.println("ban da insert thanh cong");
		}

	}

	// updtate
	public void updateAccountByID(int id, String email, String username, String fullname)
			throws SQLException, ClassNotFoundException, Exception {

		if (isAccountExists(id) != true) {
			throw new Exception("Account id isExists!");
		} else {
			Connection connection = jdbcUtils.getConnection();
			String sql = "UPDATE `Account` SET Email=?,Username=?,Fullname=? WHERE AccountID=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setString(3, fullname);
			ps.setInt(4, id);

			ps.executeUpdate();

			System.out.println("ban da update thanh cong");
		}

	}
	// delete
	public void deleteAccount(int id)
			throws SQLException, ClassNotFoundException, Exception {

		if (isAccountExists(id) != true) {
			throw new Exception("Account id isExists!");
		} else {
			Connection connection = jdbcUtils.getConnection();
			String sql = "DELETE FROM `Account`  WHERE AccountID=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("ban da delete thanh cong");
		}

	}
}
