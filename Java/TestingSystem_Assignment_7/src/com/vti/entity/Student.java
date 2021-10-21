package com.vti.entity;

public class Student {
	
	private int id;
	private String name;
	static String college;
	static int  moneyGroup;
	public static int count = 0;
	public static int getMoneyGroup() {
		return moneyGroup;
	}
	public static void setMoneyGroup(int moneyGroup) {
		Student.moneyGroup = moneyGroup;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		count++;
	}
	public Student() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getCollege() {
		return college;
	}
	public static void setCollege(String college) {
		Student.college = college;
	}
//q4 co thay doi o setter roi 
	public static void thaydoicollege(String coll) {
		college=coll;
	}
	
	
	
}
