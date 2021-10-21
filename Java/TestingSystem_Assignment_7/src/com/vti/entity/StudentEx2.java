package com.vti.entity;

public class StudentEx2 {
	private final int id;
	private String name;
//q2
	public StudentEx2( final int id, String name) {
	this.name = name;
	this.id = id;}

	public final void study() {
		System.out.println("Dang hoc bai ...");
	}
}
