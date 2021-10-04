package com.vti.InheritanceBai1;

import java.util.Scanner;

public class QLCB {

	private CanBo[] canbos;
	private Scanner scanner;
	// Khoi tao QLCB moi
	public QLCB() { 
		scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap so can bo:");
		int qlcb = scanner.nextInt();

		canbos = new CanBo[qlcb];
	}
//	Question 2: Tiếp tục Question 1
//	Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực
//	hiện các chức năng sau:
//	a) Thêm mới cán bộ.
//	b) Tìm kiếm theo h�? tên.
//	c) Hiện thị thông tin v�? danh sách các cán bộ.
//	d) Nhập vào tên của cán bộ và delete cán bộ đó
//	e) Thoát kh�?i chương trình.

	// a. them CanBo
	public void addCanBo() {
		for (int i = 0; i < canbos.length; i++) {
			System.out.println("Nhap 1 in ra Cong Nhan || 2 in ra Ky su || 3 in ra Nhan vien");
			int x = scanner.nextInt();
			switch (x) {
			case 1:
				canbos[i] = new CongNhan();
				break;
			case 2:
				canbos[i] = new KySu();
				break;
			case 3:
				canbos[i] = new NhanVien();
				break;
			default:
				System.out.println("Ban nhap sai, moi ban nhap lai");
				i--;
				break;
			}
		}
	}

	// b, Tìm kiếm theo h�? tên.
	
	public void findName() {
		for (CanBo canBo : canbos) {
			System.out.println(canBo.equals("NguyenDuyAnh"));
		}
	}

//	c) Hiện thị thông tin v�? danh sách các cán bộ. 
	public void print() {
		for (CanBo canBo : canbos) {
			System.out.println(canBo);
		}
	}

//	d) Nhập vào tên của cán bộ và delete cán bộ đó
	public void delete() {
		for (int i = 0; i < canbos.length; i++) {
			if (canbos[i].equals("NguyenDuyAnh")) {
				canbos[i] = null;
			}
			System.out.println("Ban xoa thanh cong, moi ban nhap lai ");
		}
	}
}
