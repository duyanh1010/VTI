package com.vti.frontend;

import java.sql.SQLException;

import com.vti.backend.Exercise1;

public class ProgramExercise1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Exercise1 ex1=new Exercise1();
		//ex1.selectPosition();
		//ex1.selectPosition();
		//ex1.insertPosition("Phong Cho");
	//	ex1.updatePosition();
		ex1.DeletePosition(5);
	}

}
