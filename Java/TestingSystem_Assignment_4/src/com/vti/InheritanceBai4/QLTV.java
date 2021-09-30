package com.vti.InheritanceBai4;

import java.util.Scanner;

public class QLTV {

	TaiLieu[] taiLieus;
	Scanner scanner;

	public QLTV() {
		scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao so luong tai lieu: ");
		int sL = scanner.nextInt();
		taiLieus = new TaiLieu[sL];
	}
	// Question 4 (Optional):
	// Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi
	// tài liệu gồm có các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất),
	// Tên nhà xuất bản, số bản phát hành.
	// Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
	// Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
	// Các báo cần quản lý thêm: Ngày phát hành.
	// Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một
	// cách hiệu quả.
	// Xây dựng lớp QuanLySach có các chức năng sau
	// a) Thêm mới tài liêu: Sách, tạp chí, báo.
	// b) Xoá tài liệu theo mã tài liệu.
	// c) Hiện thị thông tin về tài liệu.
	// d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
	// e) Thoát khỏi chương trình

	// a) Thêm mới tài liêu: Sách, tạp chí, báo.
	public void addTaiLieu() {

		for (int i = 0; i < taiLieus.length; i++) {
			System.out.println("Quy dinh 1 la sach|| 2 la tap chi || 3 la bao");
			int x = scanner.nextInt();
			switch (x) {
			case 1:
				taiLieus[i] = new Sach();
				break;
			case 2:
				taiLieus[i] = new TapChi();
				break;
			case 3:
				taiLieus[i] = new Bao();
				break;
			default:
				System.out.println("Ban nhap sai, moi ban nhap lai ");
				break;
			}
		}
	}

	// b) Xoá tài liệu theo mã tài liệu.
	public void delete() {
		for (int i = 0; i < taiLieus.length; i++) {
			if (taiLieus.equals("TL1")) {
				taiLieus[i] = null;
			}
			System.out.println("xoa thanh cong, moi ba nhap lai !");
		}
	}
	

	// c) Hiện thị thông tin về tài liệu.
	public void prin() {
		for (TaiLieu taiLieu2 : taiLieus) {
			System.out.println(taiLieu2);
		}
		// d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
		for (TaiLieu taiLieu2 : taiLieus) {
			System.out.println(taiLieus.equals("TL1"));
		}
	}
	public void findTL() {
		for (int i = 0; i < taiLieus.length; i++) {
			System.out.println(taiLieus.equals("TL1"));
		}
		
	}
	
}

