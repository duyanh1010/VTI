package com.vti.frontend;

import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.DepartmentDao;

public class ProgramExercise2 {

	public static void main(String[] args) throws Exception {
		DepartmentDao departmentdao = new DepartmentDao();
		// departmentdao.getDepartments();
		// departmentdao.getByIdDepartments();
//		departmentdao.getByIdDepartments1(5);
		boolean kt= departmentdao.isDepartmentNameExists("B");
		System.out.println("kiem tra:"+kt);
		// departmentdao.createDepartment();
		departmentdao.isDepartmentIdExists(3);
		boolean y=departmentdao.isDepartmentIdExists(3);
		System.out.println(y);
		Scanner sc = new Scanner(System.in);
		System.out.println("moi bann nhap vao id");
		int id = sc.nextInt();
		System.out.println("moi bann nhap vao name");
		String name = sc.next();
		// departmentdao.deleteDepartment(id);

		if (departmentdao.isDepartmentIdExists(id) != true) {
			throw new Exception("Cannot find department which has id = " + id);
		} else if (departmentdao.isDepartmentNameExists(name) == true) {
				throw new Exception("Department Name is Exists!");
			} else {
				departmentdao.updateDepartmentName(id, name);
			}
		}
	

}
