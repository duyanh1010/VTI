package com.vti.backend;

import com.vti.AbstractBai1.VNPhone;

public class Abstraction {
	public void Bai1() {
		VNPhone vnPhone = new VNPhone();
		vnPhone.insertContact();
		vnPhone.printContacts();
		vnPhone.removeContact();
		vnPhone.updateContact();
		vnPhone.searchContact();
	}

}
