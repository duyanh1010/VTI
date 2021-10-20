package com.vti.backend;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise4 {

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);
		conection.setAutoCommit(false);
		try {
			insertAccount();
			insertDepartment();
			conection.commit();
			System.out.println("commit thnah cong ");
		} catch (Exception e) {
			conection.rollback();
			System.out.println("rollback");
		}
		

	}
	public static void insertAccount() throws SQLException, ClassNotFoundException, Exception {
		
		
			String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			String username = "root";
			String password = "Anhanh10";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conection = DriverManager.getConnection(databaseURL, username, password);
			String SQL = "DELETE FROM `Account` WHERE DepartmentID=3 ";
			Statement statement = conection.createStatement();
			
			

			int n = statement.executeUpdate(SQL);
			System.out.println("row success: " + n);
			System.out.println("ban da xoa accoount  co id=3 thanh cong");
		}
	
	public static void insertDepartment() throws SQLException, ClassNotFoundException, Exception {
		
			String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			String username = "root";
			String password = "Anhanh10";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conection = DriverManager.getConnection(databaseURL, username, password);
			String SQL = "DELETE FROM Department WHERE DepartmentID=3 ";
			Statement statement = conection.createStatement();
			
			

			int n = statement.executeUpdate(SQL);
			System.out.println("row success: " + n);
			System.out.println("ban da xoa department thanh cong");
		}
	


}
