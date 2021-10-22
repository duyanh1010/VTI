package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class Exercise2 {
	// Question1
		public void question1() {
			@SuppressWarnings("deprecation")
			Date date = new Date(2020, 05, 18);
			date.toString();
		}

	//Question2:
		public void question2() {
			@SuppressWarnings("deprecation")
			Student student = new Student(1, "Nguyen Duy Anh");
			
			System.out.println(student.getName());
			System.out.println(student.getId());
			System.out.println(student.getIdNew());
}
}