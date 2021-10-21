package com.vti.entity;

public class PrimaryStudent extends Student {
	public static int countPrimary = 0;

	
// dem o ham khoi tao 
	public PrimaryStudent(int id, String name) {
		super(id, name);
		 countPrimary++;
	}
	

}
