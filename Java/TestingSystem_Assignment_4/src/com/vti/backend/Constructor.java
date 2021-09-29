package com.vti.backend;

import java.time.LocalDateTime;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;


public class Constructor {


	public static void main(String[] args) {
		bai1();
		bai2();
		bai3();
	}
//	Question 1:
//		Tạo constructor cho department:
//		a) không có parameters
//		b) Có 1 parameter là nameDepartment và default id của
//		Department = 0
//		Khởi tạo 1 Object với mỗi constructor ở trên
		public static void bai1() {
			Department department1=new Department();
			System.out.println(department1);
			
			Department department2=new Department((byte) 0,"Nguyen Duy Anh");
			System.out.println(department2);
		}
//		Question 2:
//			Tạo constructor cho Account:
//			a) Không có parameters
//			b) Có các parameter là id, Email, Username, FirstName,
//			LastName (với FullName = FirstName + LastName)
//			c) Có các parameter là id, Email, Username, FirstName,
//			LastName (với FullName = FirstName + LastName) và
//			Position của User, default createDate = now
//			d) Có các parameter là id, Email, Username, FirstName,
//			LastName (với FullName = FirstName + LastName) và
//			Position của User, createDate
//			Khởi tạo 1 Object với mỗi constructor ở trên
//	
		public static void bai2() {
			
			Account account1=new Account();
			System.out.println(account1);
			//b
			Account account2=new Account(1,"duyanhr01@gmail.com","duy","anh","nguyen");
			System.out.println(account2);
			//c d

			Position position = new Position((byte) 3, "DE");
			String email = "Ngoc@gmail.com";
			LocalDateTime createDate = LocalDateTime.now();
			Account account3=new Account(3,"Ngoc@gmail.com","ngoc","Thi","nguyen",position,LocalDateTime.of(2021, 10, 01,00,00,00));
			System.out.println(account3);
			Account account4=new Account(4,"lam@gmail.com","lam","Thi","nguyen",position,createDate);
			System.out.println(account4);
			
		}
//		Question 3:
//			Tạo constructor cho Group:
//			a) không có parameters
//			b) Có các parameter là GroupName, Creator, array Account[]
//			accounts, CreateDate
//			c) Có các parameter là GroupName, Creator, array String[]
//			usernames , CreateDate
//			Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
//			username, các thông tin còn lại = null).
//			Khởi tạo 1 Object với mỗi constructor ở trên
		public static void bai3() {
		
			Group group1 = new Group();
			System.out.println(group1);
			
			//b, Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
			// creator
			Account creator = new Account((short) 3, "minh@gmail", "nguyenminh", null, null, null, null);
			
			// tao array accounts
			Account account1 = new Account();
			
			Account account2 = new Account();
		
			Account account3 = new Account();
			
			Account[] accounts = {account1, account2, account3};

			
			
			Group group2 = new Group("Nhan vien ", creator, accounts, LocalDateTime.of(2020, 01, 01,00,00,00));
			System.out.println(group2);
			
		//	c) Có các parameter là GroupName, Creator, array String[] usernames , CreateDate (Chua bai tap)
			// tao array string
			
			String[] userNames = {"duy anh", "kien", "nam"};
		
			Group group3 = new Group("duyanh", creator, userNames,  LocalDateTime.of(2020, 12, 01,00,00,00));
			System.out.println(group3);
		}
		
}
