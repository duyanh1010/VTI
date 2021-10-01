package com.vti.backend;

import com.vti.entity.Student;

public class Ex2_Polymorphism {

	public static void main(String[] args) {
		Question_1();
	}

	public static void Question_1() {
//	Exercise 2: Polymorphism
//	Question 1: Interface Management
//	Tạo 1 class Student gồm các property id, name, group(int)
//	Tạo 1 interface IStudent bao gồm các method : điểmDanh(), họcBài(),
//	đi dọn vệ sinh()
//	Class Student sẽ implement interface như sau:
//	Method điểm danh() sẽ in ra nội dung như sau:
//	"Nguyễn Văn A điểm danh"
//	"Nguyễn Văn B điểm danh"
//	"Nguyễn Văn C điểm danh"
//	….
//	Method học Bài () sẽ in ra nội dung như sau:
//	"Nguyễn Văn A đang học bài"
//	"Nguyễn Văn B đang học bài "
//	"Nguyễn Văn C đang học bài "
//	…
//	Tương tự với các method còn lại
//	Hãy viết chương trình thực hiện các lệnh sau:
//	a) Tạo 10 học sinh, chia thành 3 nhóm
//	b) Kêu gọi cả lớp điểm danh.
//	c) Gọi nhóm 1 đi học bài
//	d) Gọi nhóm 2 đi dọn vệ sinh

		Student[] students = new Student[10];
		for (int i = 0; i < students.length; i++) {
			int group;
			if (i <= 2) {
				group = 1;
			} else if (i <= 5) {
				group = 2;
			} else {
				group = 3;
			}
			students[i] = new Student(i, "Nguyen van A" + (i + 1), group);
			System.out.println(students[i]);

		}

// b) Kêu gọi cả lớp điểm danh.
		for (Student student : students) {
			student.diemdanh();
		}

//c) Gọi nhóm 1 đi học bài
		for (Student student1 : students) {
			if (student1.getGroup() == 1) {
				student1.hocbai();
			}
		}
//d) Gọi nhóm 2 đi dọn vệ sinh			

		for (Student student2 : students) {
			if (student2.getGroup() == 2) {
				student2.donvesinh();
			}
		}
	}
}
