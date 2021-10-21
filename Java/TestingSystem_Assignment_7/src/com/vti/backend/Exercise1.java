package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Configs;
import com.vti.entity.HinhHoc;
import com.vti.entity.HinhHocException;
import com.vti.entity.HinhTron;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

import sun.security.util.Length;

public class Exercise1 {
//	Question 1: static variable
//	Khai báo 1 class student có các thuộc tính id, name, college
//	Với college là static variable.
//	Hãy khởi tạo các student sau:
//	Student có id = 1, name ="Nguyễn Văn A"
//	Student có id = 2, name = " Nguyễn Văn B "
//	Student có id = 3, name = " Nguyễn Văn C "
//	Và tất cả các student này đều học ở "Đại học bách khoa".
//	Dùng vòng for để in ra thông tin các student
//	Sau đó hãy chuyển các student này sang "Đại học công nghệ"
//	Dùng vòng for để in ra thông tin các student
	public static void Question1() {
		Student student1 = new Student(1, "Nguyen van A");
		Student student2 = new Student(2, "Nguyen van B");
		Student student3 = new Student(3, "Nguyen van C");
		Student[] students = { student1, student2, student3 };
		Student.setCollege("Dai Hoc Bach Khoa Ha Noi");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].getId());
			System.out.println(students[i].getName());
			System.out.println(students[i].getCollege());
		}
		Student.setCollege("Dai Hoc Cong Nghe Ha Noi");
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].getId());
			System.out.println(students[i].getName());
			System.out.println(students[i].getCollege());
		}

	}
//	Question 2: tiếp tục question 1
//	Bổ sung thuộc tính moneyGroup cho Student (moneyGroup là tiền quỹ
//	lớp - dùng chung cho tất cả các student).
//	Hãy viết chương trình main() để mô tả các bước sau:
//	B1: Các Student sẽ nộp quỹ, mỗi Student 100k
//	B2: Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan
//	B3: Student thứ 2 lấy 20k đi mua bánh mì
//	B4: Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm
//	B5: cả nhóm mỗi người lại đóng quỹ mỗi người 50k
//	In ra số tiền còn của nhóm tại mỗi bước
	public static void Question2() {
		Student student1 = new Student(1, "Nguyen van A");
		Student student2 = new Student(2, "Nguyen van B");
		Student student3 = new Student(3, "Nguyen van C");
		Student[] students = { student1, student2, student3 };
		Student.setCollege("Dai Hoc Cong Nghe Ha Noi");
		Student.setMoneyGroup(100000);
		int tongtien=0;
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].getId());
			System.out.println(students[i].getName());
			System.out.println(students[i].getCollege());
			System.out.println(students[i].getMoneyGroup());
			tongtien=tongtien+students[i].getMoneyGroup();
		}
		System.out.println("tong tien khi ca lop dong 100k la:"+tongtien);
		tongtien=tongtien-50000;
		System.out.println("so tien con lai khi nguoi 1 mua 50k la:"+tongtien);
		tongtien=tongtien-20000;
		System.out.println("so tien con lai khi nguoi 2 mua 20k la:"+tongtien);
		tongtien=tongtien-150000;
		System.out.println("so tien con lai khi nguoi 3 mua 250k la:"+tongtien);
		Student.setMoneyGroup(50000);
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].getId());
			System.out.println(students[i].getName());
			System.out.println(students[i].getCollege());
			System.out.println(students[i].getMoneyGroup());
			tongtien=tongtien+students[i].getMoneyGroup();
		}
		System.out.println("So Tien con lai la:"+tongtien);
		
		
	}
	
	public static void Question5() {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Nguyen Van A"));
		students.add(new Student(2, "Nguyen Van B"));
	
		students.add(new Student(3, "Nguyen Van C"));
		
		
			System.out.println(Student.count);
		
		
		
	}

	//Question 6:

		public static void Question6() throws Exception {
			// them 2 pri
			Student student1 = new PrimaryStudent(1, "Nguyen Van A");
			Student student2 = new PrimaryStudent(2, "Nguyen Van B");
			// them 4 se
			Student student3 = new SecondaryStudent(3, "Nguyen Van C");
			Student student4 = new SecondaryStudent(4, "Nguyen Van D");
			Student student5 = new SecondaryStudent(5, "Nguyen Van E");
			Student student6 = new SecondaryStudent(6, "Nguyen Van");
			System.out.println("So PrimaryStudent  them vao : " + PrimaryStudent.countPrimary);
			System.out.println("So SecondaryStudent  them vao : " + SecondaryStudent.countSe);
			System.out.println("Tong so hoc sinh them vao la: " + Student.count);
			
	// Question 7: 
			Scanner scanner=new Scanner(System.in);
			while (true) {
				if (Student.count < 7) {
					Student student7 = new SecondaryStudent(7, "Nguyen Thi F");
					System.out.println("Them moi thanh cong tong so hoc sinh la : " + Student.count);
				} else {
					System.err.println("ban da tao toi da 7 hoc sinh");
				}
				scanner.nextLine();
			}
		}

		// Question 8:
		public static void Question8() throws HinhHocException {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				try {
					HinhHoc hinh1 = new HinhTron();
					if (HinhHoc.count > Configs.SO_LUONG_HINH_TOI_DA) {
						throw new HinhHocException("Ban chi duoc them toi da: " + Configs.SO_LUONG_HINH_TOI_DA);
					}
				} catch (HinhHocException ex) {
					System.err.println(ex.getMessage());
				}
				System.out.println("Ban da them thanh cong so Luong hinh hoc la: " + HinhHoc.count);
				scanner.nextLine();
			}
		}
	
}