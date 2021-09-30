package com.vti.InheritanceBai3;


public class HighSchoolStudent extends Student_Inheri {
	private String clazz;
	private String desiredUniversity;

	public HighSchoolStudent(int id, String name, String clazz, String desiredUniversity ) {
		super( name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}
	
	
}
