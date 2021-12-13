package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Student;

public class Exercise1 {
	static Scanner scanner = new Scanner(System.in);
	static List<Student> students = new ArrayList<>();

	// a, In ra tổng số phần tử của students
	public static void countstudent() {
		students.add(new Student(1, "Nguyen Van A"));
		students.add(new Student(2, "Nguyen Van B"));
		students.add(new Student(3, "Nguyen Van C"));
		System.out.println("So luong hoc sinh la: " + Student.counter);
	}

	// b, Lấy phần tử thứ 4 của students
	public void getIndext4OfStudent() {
		countstudent();
		try {
			System.out.println(students.get(4));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Chi in duoc student 1-3");
		}
	}

	// c,In ra phần tử đầu và phần tử cuối của students
	public void printOfStudentFirstAndLast() {
		countstudent();
		System.out.println(students.get(0));

		int x = students.size() - 1;
		System.out.println(students.get(x));
	}

	// d, Thêm 1 phần tử vào vị trí đầu của students
	public void addStudentIndextfirst() {
		countstudent();
		students.add(0, new Student(0, "Nguyen Duy Anh"));
		System.out.println(students);
	}

	// e) Thêm 1 phần tử vào vị trí cuối của students
	public void addStudentIndextLast() {
		countstudent();
		students.add(new Student(4, "Nguyen Duy Anh"));
		System.out.println(students);
	}

	// f) Đảo ngược vị trí của students
	public void reverseList() {
		countstudent();
		Collections.reverse(students);
		System.out.println("Thông tin student sau đảo ngược là: " + students);
	}

	// g) Tạo 1 method tìm kiếm student theo id
	public void findStudentById() {
		countstudent();
		System.out.print("nhap vao id can tim: ");
		int number = scanner.nextInt();
		for (Student student : students) {
			if (student.getId() == number) {
				System.out.println("Tim kiem thanh cong, Id co ton tai");
			} else {
				System.out.println("Hoc sinh khong co trong danh sach");
			}
		}
	}

	// h) Tạo 1 method tìm kiếm student theo name
	public void findStudentByName() {
		countstudent();
		System.out.print("Nhap Ten can tim: ");
		String Nm = scanner.nextLine();
		for (Student student : students) {
			if (student.getName().equals(Nm)) {
				System.out.println("Tim kiem thanh cong, Ten co ton tai");
			} else {
				System.out.println(Nm + " :khong co trong danh sach");
			}
		}
	}

	// i) Tạo 1 method để in ra các student có trùng tên(Xem Duy Chua)
	public static void printSameName() {

	}

	// j) Xóa name của student có id = 2;
	public static void DeleteNameOfStudentId2() {
		for (Student student : students) {
			if (student.getId() == 2) {
				student.setName(null);
			}
		}
	}

	// k) Delete student có id = 5;
	public static void deteleStudentId5() {
		for (Student student : students) {
			if (student.getId() == 5) {
				students.remove(student);
			}
		}
	}

	// l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
	// studentCopies
	public static void CreateStudentCopy() {
		ArrayList<Student> studentCopies = new ArrayList<>();
		studentCopies.addAll(students);
	}
}
