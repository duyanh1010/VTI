package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float points;
	public Student(int id, String name, String hometown, float points) {
		super();
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.points = points;
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
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
//	b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
//	dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
	
	public Student(String name, String hometown, Float points) {
		this.name = name;
		this.hometown = hometown;
		this.points = points;
	}
	public Student(String name, Float points) {
		this.name = name;
		this.points = points;
	}

	
}
