package com.vti.AbstractBai1;

import java.util.Scanner;

public class VNPhone extends Phone {
	Scanner scanner;

	public VNPhone() {
		scanner = new Scanner(System.in);
		System.out.println("Nhap vao so contact: ");
		int x = scanner.nextInt();
		contacts = new Contact[x];
	}

	@Override
	public void insertContact() {
		for (int i = 0; i < contacts.length; i++) {
			Contact contact = new Contact();
			contacts[i] = contact;
		}
	}

	@Override
	public void removeContact() {
		for (int i = 0; i < contacts.length; i++) {
			if (contacts[i] != null && contacts[i].getName().equals("Nguyen DuyAnh"))
				;
			{
				contacts[i] = null;
			}
			System.out.println("Ban xoa thanh cong!");
		}
	}

	@Override
	public void updateContact() {
		for (int i = 0; i < contacts.length; i++) {
			String x = scanner.nextLine();
			if (contacts[i].getNumber().equals(x)) {
				System.out.println(contacts[i].getNumber().equals("09xxxxx"));
			}
		}
	}

	@Override
	public void searchContact() {
		for (int i = 0; i < contacts.length; i++) {
			System.out.println(contacts[i].getName().equals("Nguyen DuyAnh"));

		}
	}

}
