package com.vti.backend;

import com.vti.entity.ScannerUtils;

public class Exercise5Student {
	private static final long serialVersionUID = 1L;

	private static int counter = 0;

	private int id;
	private String name;

	public Exercise5Student() {
		this.id = ++counter;
		input();
	}

	public Exercise5Student(String name) {
		this.name = name;
	}

	private void input() {
		System.out.println("Input name: ");
		name = ScannerUtils.inputName();
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
