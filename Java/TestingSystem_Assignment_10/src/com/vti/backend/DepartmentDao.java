package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DepartmentDao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		getDepartments();

	}

	// Question 1:
	public static void getDepartments() throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);

		// System.out.println("Connect success");

		String SQL = "SELECT *FROM Department ";
		Statement statement = conection.createStatement();
		ResultSet result = statement.executeQuery(SQL); // cau truy van co dinh moi dung
		while (result.next()) {
			result.getInt("DepartmentID");
			result.getString("DepartmentName");
			System.out.println(result.getInt("DepartmentID") + " " + result.getString("DepartmentName"));

		}
	}

	// Question 2:
	public static void getByIdDepartments() throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);

		// System.out.println("Connect success");

		String SQL = "SELECT *FROM Department WHERE DepartmentID=5 ";
		Statement statement = conection.createStatement();
		ResultSet result = statement.executeQuery(SQL); // cau truy van co dinh moi dung

		while (result.next()) {
			result.getInt("DepartmentID");
			result.getString("DepartmentName");
			System.out.println(result.getInt("DepartmentID") + " " + result.getString("DepartmentName"));

		}
	}

	// Question3
	public static void getByIdDepartments1(int id) throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);

		// System.out.println("Connect success");

		String SQL = "SELECT *FROM Department WHERE DepartmentID=? ";
		PreparedStatement pr = conection.prepareStatement(SQL);
		pr.setInt(1, id);
		ResultSet result = pr.executeQuery(); // cau truy van co dinh moi dung
		if (result.next()) {
			// while (result.next()) {
			// result.getInt("DepartmentID");
			// result.getString("DepartmentName");
			System.out.println(result.getInt("DepartmentID") + " " + result.getString("DepartmentName"));

		} else {
			System.out.println("kiem tra gia tri dau vao:");
		}

	}

//q4
	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);

		// System.out.println("Connect success");

		String SQL = "SELECT *FROM Department WHERE DepartmentName=? ";
		PreparedStatement pr = conection.prepareStatement(SQL);
		pr.setString(1, name);
		ResultSet result = pr.executeQuery(); // cau truy van co dinh moi dung
		String x = "";
		while (result.next()) {
			result.getInt("DepartmentID");

			x = result.getString("DepartmentName");
			System.out.println(result.getInt("DepartmentID") + " " + result.getString("DepartmentName"));

		}

		System.out.println(x);
		System.out.println(name);
		if (name.contentEquals(x)) {

			return true;
		} else {

			return false;
		}

	}

	// q5
	public void createDepartment() throws SQLException, ClassNotFoundException, Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("moi ban nhap vao ten phong ban :");
		String name = sc.nextLine();
		DepartmentDao de = new DepartmentDao();
		if (de.isDepartmentNameExists(name) == true) {
			throw new Exception("Department Name isExists!");
		} else {
			String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			String username = "root";
			String password = "Anhanh10";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conection = DriverManager.getConnection(databaseURL, username, password);
			String SQL = "INSERT INTO Department (DepartmentName) VALUES (?)";
			PreparedStatement ps = conection.prepareStatement(SQL);

			ps.setString(1, name);
			int n = ps.executeUpdate();
			System.out.println("row success: " + n);
			System.out.println("ban da insert thanh cong");
		}

	}

	// q6
	public boolean isDepartmentIdExists(int id) throws SQLException, ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);

		// System.out.println("Connect success");

		String SQL = "SELECT *FROM Department WHERE DepartmentID=? ";
		PreparedStatement pr = conection.prepareStatement(SQL);
		pr.setInt(1, id);
		ResultSet result = pr.executeQuery(); // cau truy van co dinh moi dung
		int x = 0;
		while (result.next()) {
			x = result.getInt("DepartmentID");

			result.getString("DepartmentName");
		//	System.out.println(result.getInt("DepartmentID") + " " + result.getString("DepartmentName"));

		}

		// System.out.println(x);
		// System.out.println(id);
		if (id == x) {

			return true;
		} else {

			return false;
		}

	}

	// q6
	public void updateDepartmentName(int id, String name) throws SQLException, ClassNotFoundException, Exception {

		String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "Anhanh10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conection = DriverManager.getConnection(databaseURL, username, password);
		String SQL = "UPDATE Department SET DepartmentName=? WHERE DepartmentID=? ";
		PreparedStatement ps = conection.prepareStatement(SQL);
		ps.setString(1, name);
		ps.setInt(2, id);
		int n = ps.executeUpdate();
		System.out.println("row success: " + n);
		System.out.println("ban da update thanh cong");
	}

//q7
	public void deleteDepartment(int id) throws SQLException, ClassNotFoundException, Exception {
		DepartmentDao departmentdao = new DepartmentDao();
		if (departmentdao.isDepartmentIdExists(id) == false) {
			throw new Exception("Cannot find department which has id = " + id);
		} else {
			String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			String username = "root";
			String password = "Anhanh10";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conection = DriverManager.getConnection(databaseURL, username, password);
			String SQL = "DELETE FROM Department WHERE DepartmentID=? ";
			PreparedStatement ps = conection.prepareStatement(SQL);
			ps.setInt(1, id);

			int n = ps.executeUpdate();
			System.out.println("row success: " + n);
			System.out.println("ban da xoa thanh cong");
		}
	}

}
