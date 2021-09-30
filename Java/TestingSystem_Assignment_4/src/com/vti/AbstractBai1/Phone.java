package com.vti.AbstractBai1;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

public abstract class Phone {
	Contact[] contacts;

// Method
	public abstract void insertContact();

	public abstract void removeContact();

	public abstract void updateContact();

	public abstract void searchContact();

	public void printContacts() {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
}
