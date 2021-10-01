package com.vti.entity;

public class Student implements IStudent {
	protected int id;
	protected String name;
	protected int group;

	Student() {
	}

	public Student(int id, String name, int group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}

// toString
	@Override
	public String toString() {
		String result = "";
		result += "id: " + id + "\n";
		result += "Name : " + name + "\n";
		result += "Group: " + group + "\n";
		return result;
	}

	// get/set
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

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	// in ra
	@Override
	public void diemdanh() {
		System.out.println("Student: " + " " + name + " " + " diem danh" + "Group " + group);
	}

	@Override
	public void hocbai() {
		System.out.println("Student: " +" " + name + " " + " dang hoc bai" + "Group " + group);

	}

	@Override
	public void donvesinh() {
		System.out.println("Student: " +" " + name + " " + "dang don ve sinh" + "Group " + group);

	}

}
