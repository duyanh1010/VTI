package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//selectPosition();
		//insertPosition("Phong Cho");
	//	updatePosition();
		DeletePosition(5);
	}

	public static void selectPosition() throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);
//		Question 1: (Sử dụng Database Testing System đã xây dựng ở SQL)
//		Tạo connection tới database Testing System
//		In ra "Connect success!" khi kết nối thành công.
		System.out.println("Connect success");
//		Question 2:
//			Tạo method để in ra các thông tin của position gồm có id, name
		String SQL = "SELECT *FROM Position ";
		Statement statement = conection.createStatement();
		ResultSet result = statement.executeQuery(SQL); // cau truy van co dinh moi dung
		while (result.next()) {
			result.getInt("PositionID");
			result.getString("PositionName");
			System.out.println(result.getInt("PositionID") + " " + result.getString("PositionName"));

		}
	}

	public static void insertPosition(String pattern) throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);

		System.out.println("Connect success");

		String SQL = "INSERT INTO `Position` (PositionName) VALUES (?)";
		PreparedStatement ps = conection.prepareStatement(SQL);
		ps.setString(1, pattern);
		int n = ps.executeUpdate();
		System.out.println("row success: " + n);
	}
//	Question 4:
//		Tạo method để update tên của position gồm có id = 5 thành "Dev".
	public static void updatePosition() throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);

		System.out.println("Connect success");
		
		String SQL = "UPDATE Position\r\n" + "SET PositionName=\"dev11\"\r\n" + "WHERE PositionID=5";
		Statement statement = conection.createStatement();

		int n = statement.executeUpdate(SQL);
		System.out.println("row success: " + n);
	}
//	Question 5:
//		Tạo method để delete của position theo id và user sẽ nhập vào id
	public static void DeletePosition(int pattern) throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);

		System.out.println("Connect success");

		String SQL = "INSERT INTO `Position` (PositionName) VALUES (?)";
		PreparedStatement ps = conection.prepareStatement(SQL);
		ps.setInt(1, pattern);
		int n = ps.executeUpdate();
		System.out.println("row success: " + n);
		System.out.println("xoa thanh cong");
	}
}
