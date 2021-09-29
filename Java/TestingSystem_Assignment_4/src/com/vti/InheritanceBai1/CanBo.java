package com.vti.InheritanceBai1;

import java.util.Scanner;

public abstract class CanBo {

	protected String fullName;
	protected int age;
	protected String gender;
	protected String address;

	// Question2_a) Thêm 
	public CanBo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap ten: ");
		fullName = scanner.nextLine();
		System.out.println("Moi ban nhap tuoi: ");
		age = scanner.nextInt();
		System.out.println("Moi ban nhap gioi tinh: ");
		gender = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Moi ban nhap dia chi: ");
		address = scanner.nextLine();
	}

	public CanBo(String fullName, int age, String gender, String address) {
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	// Equals // lam cau tim kiem ten 
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		String FullName = obj.toString();
		if (fullName.equals(FullName)) {
			return true;
		}
		return false;
	}

// toString
	@Override
	public String toString() {
		String result = "";
		result += "Ho va ten: " + fullName + "\n";
		result += "Tuoi: " + age + "\n";
		result += "Gioi tinh: " + gender + "\n";
		result += "Dia chi: " + address + "\n";

		return result;
	}

	// Constructor Inheritance

	// getter/ setter
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}