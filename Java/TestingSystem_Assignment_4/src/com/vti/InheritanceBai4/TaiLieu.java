package com.vti.InheritanceBai4;

import java.util.Scanner;

public class TaiLieu {
	private String maTL;
	private String Tennhasx;
	private int SLphathanh;
	
	public String getMaTL() {
		return maTL;
	}
	public void setMaTL(String maTL) {
		this.maTL = maTL;
	}
	public String getTennhasx() {
		return Tennhasx;
	}
	public void setTennhasx(String tennhasx) {
		Tennhasx = tennhasx;
	}
	public int getSLphathanh() {
		return SLphathanh;
	}
	public void setSLphathanh(int sLphathanh) {
		SLphathanh = sLphathanh;
	}
	// create obj, Scanner
		TaiLieu(String maTL, String Tennhasx, int SLphathanh) {
			this.maTL = maTL;
			this.Tennhasx = Tennhasx;
			this.SLphathanh = SLphathanh;
		}

		TaiLieu() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Nhap ma tai lieu: ");
			maTL = scanner.nextLine();
			System.out.println("Nhap ten nha san xuat: ");
			Tennhasx = scanner.nextLine();
			System.out.println("Nhap so luong phat hanh: ");
			SLphathanh = scanner.nextInt();
		}

		// toString
		@Override
		public String toString() {
			String results = "";
			results += "Ma tai lieu: " + maTL + "\n";
			results += "Ten nha san xuat: " + Tennhasx + "\n";
			results += "So luong phat hanh: " + SLphathanh + "\n";
			return results;
		}

		// Equals
		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			String MaTL = obj.toString();
			if (maTL.equals(MaTL)) {
				return true;
			}
			return false;
		}
	
	
}
