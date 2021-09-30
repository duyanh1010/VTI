package com.vti.InheritanceBai4;


import java.util.Date;
import java.util.Scanner;

public class Bao extends TaiLieu{
	private Date creatOfDate;

	public Date getCreatOfDate() {
		return creatOfDate;
	}

	public void setCreatOfDate(Date creatOfDate) {
		this.creatOfDate = creatOfDate;
	}
	//
//  create obj, Scanner
	Bao(String maTL, String Tennhasx, int SLphathanh, Date creatOfDate) {
		super(maTL, Tennhasx, SLphathanh);
		this.creatOfDate = creatOfDate;
	}

	Bao() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Nhap ngay phat hanh: ");
		creatOfDate = new Date();
	}

	// toString
	@Override
	public String toString() {
		String results = super.toString();
		results += "Ngay phat hanh: " + creatOfDate + "\n";
		return results;
	}

}
