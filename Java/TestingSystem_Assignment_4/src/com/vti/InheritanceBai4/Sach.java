package com.vti.InheritanceBai4;

import java.util.Scanner;

public class Sach extends TaiLieu {
	private String tenTG;
	private int SLTrang;
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	public int getSLTrang() {
		return SLTrang;
	}
	public void setSLTrang(int sLTrang) {
		SLTrang = sLTrang;
	}
	// create obj,Scanner
		Sach(String maTL, String Tennhasx, int SLphathanh, String tenTG, int SLTrang) {
			super(maTL, Tennhasx, SLphathanh);
			this.SLTrang = SLphathanh;
			this.tenTG = tenTG;
		}

		Sach() {
			super();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Nhap so luong trang: ");
			SLTrang = scanner.nextInt();
			scanner.nextLine();
			System.out.println(" Nhap ten tac gia: ");
			tenTG = scanner.nextLine();
		}

		// toString
		@Override
		public String toString() {
			String results = super.toString();
			results += "So luong trang: " + SLTrang + "\n";
			results += "Ten tac gia: " + tenTG + "\n";
			return results;
		}
}
