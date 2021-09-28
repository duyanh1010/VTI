import java.util.Arrays;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class ObjectMethod {

	public static void main(java.lang.String[] args) {
		Department department1=new Department();
		department1.id=1;
		department1.name="Sale";
		Department department2=new Department();
		department2.id=2;
		department2.name="Marketing";
		Department department3=new Department();
		department3.id=3;
		department3.name="Accounting";
		Department department4=new Department();
		department4.id=4;
		department4.name="Boss of director";
		Department department5=new Department();
		department5.id=5;
		department5.name="Waiting room";
		Department[] departments= {department1,department2,department3,department4,department5};
		bai1(department1);
		bai2(departments);
		bai3(department1);
		bai4(department1);
		bai4b(department1);
		bai5(department1, department2) ;
		bai6(departments);
		bai7(departments);
		
		
		}
	
	
	public static void bai1(Department department1) {
		System.out.println(department1);
	}
//	In ra thông tin của tất cả phòng ban (sử dụng toString())
	public static void bai2(Department[] departmens) {
		for (Department department : departmens) {
			System.out.println(department);
		}
	}

//	Question 3:
//		In ra địa chỉ của phòng ban thứ 1
	public static void bai3(Department department1) {
		System.out.println(department1.hashCode());
	}
//	Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
	public static void bai4(Department department1) {
		if(department1.name=="Phòng A") {
			System.out.println("phong ban thu 1 la phong A");
		} else {
			System.out.println("phong ban 1 khong phai phong A");
		}
		
		
	}
	// cách 2 4b
	public static void bai4b(Department department1) {
		
			System.out.println(("Phòng A").equals(department1.name));
		
	}
//	Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
//	không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
	public static void bai5(Department department1,Department department2) {
		if(department1.equals(department2)) {
			System.out.println("bang nhau");
		} else {
			System.out.println("khong bang nhau ");
		}
		
	}
//	Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
//	sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//	VD:
//	Accounting
//	Boss of director
//	Marketing
//	Sale
//	Waiting room
	// dung comparator
	public static void bai6(Department[] departments) {
		java.util.Collections.sort(Arrays.asList(departments), new  ComparatorName());
		for (Department department : departments) {
			System.out.println(department.name);
			
		}
		System.out.println("\n");
	}
//	Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh
//	sách phòng ban được sắp xếp theo tên
//	VD:
//	Accounting
//	Boss of director
//	Marketing
//	waiting room
//	Sale
//	
	// dung comparator
	public static void bai7(Department[] departments) {
	
		java.util.Collections.sort(Arrays.asList(departments), new  ComparatorNameBai7());
		for (Department department : departments) {
			System.out.println(department.name);
		}
	}
	
	
}
