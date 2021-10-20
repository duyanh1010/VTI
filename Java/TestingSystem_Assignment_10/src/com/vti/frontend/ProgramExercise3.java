package com.vti.frontend;

import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.Exercise1;
import com.vti.backend.Exercise3;

public class ProgramExercise3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
		Exercise3 ex3=new Exercise3();
		Scanner sc=new Scanner(System.in);
		System.out.println("moi bann nhap vao id");
		int id=sc.nextInt();
		ex3.deleteDepartmentUsingProcedure(id);
	}

}
