package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercise3 {

	public static void main(String[] args) {
		
	}
	public void deleteDepartmentUsingProcedure(int id) throws SQLException, ClassNotFoundException, Exception {
		DepartmentDao departmentdao = new DepartmentDao();
		if (departmentdao.isDepartmentIdExists(id) == false) {
			throw new Exception("Cannot find department which has id = " + id);
		} else {
			String databaseURL = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			String username = "root";
			String password = "Anhanh10";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conection = DriverManager.getConnection(databaseURL, username, password);
			String SQL = "CALL sp_delete_department(?); ";
			PreparedStatement ps = conection.prepareStatement(SQL);
			ps.setInt(1, id);

			int n = ps.executeUpdate();
			System.out.println("row success: " + n);
			System.out.println("ban da xoa thanh cong");
		}
		
	}

}
