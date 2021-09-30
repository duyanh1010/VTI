package com.vti.AbstractBai1;

import java.util.Scanner;

public class Contact {
	private String number;
	private String name;

// Scanner, create obj
	public Contact(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public Contact() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so dien thoai: ");
		number = scanner.nextLine();
		System.out.println("Nhap ten: ");
		name = scanner.nextLine();
	}
// toString
	@Override
	public String toString() {
	String resluts = "";
	resluts += " So dien thoai: " + number + "\n";
	resluts += "Ten: " + name + "\n";
		return resluts;
	}
	
//get, set 
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
