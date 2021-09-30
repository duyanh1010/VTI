package com.vti.InheritanceBai4;

import java.util.Scanner;

public class TapChi extends TaiLieu {
	private int soPH;
	private byte thangPH;
//  create obj, Scanner
	TapChi(String maTL, String Tennhasx, int SLphathanh, int soPH, byte thangPH) {
		super(maTL, Tennhasx, SLphathanh);
		this.soPH = soPH;
		this.thangPH = thangPH;
	}

	TapChi() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so phat hanh: ");
		soPH = scanner.nextInt();
		System.out.println("Nhap thang phat hanh: ");
		thangPH = scanner.nextByte();
	}

	// toString
	@Override
	public String toString() {
		String results = super.toString();
		results += "So phat hanh: " + soPH + "\n";
		results += "Thang phat hanh: " + thangPH + "\n";
		return results;
	}

	public int getSoPH() {
		return soPH;
	}

	public void setSoPH(int soPH) {
		this.soPH = soPH;
	}

	public byte getThangPH() {
		return thangPH;
	}

	public void setThangPH(byte thangPH) {
		this.thangPH = thangPH;
	}
	
}
