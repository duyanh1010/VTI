package com.vti.entity;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	private static final LocalDateTime LocalDateTime = null;

	public static void main(String[] args) throws ParseException {
		// create Department
		Department department = new Department();
		department.departmentId = 1;
		department.departmentName = "Marketing";

		Department department1 = new Department();
		department1.departmentId = 2;
		department1.departmentName = "Sale";

		Department department2 = new Department();
		department2.departmentId = 3;
		department2.departmentName = "Bao Ve";

		// Create Position

		Position position = new Position();
		position.positionId = 1;
		position.positionName = "Dev";

		Position position1 = new Position();
		position1.positionId = 2;
		position1.positionName = "Test";

		Position position2 = new Position();
		position2.positionId = 3;
		position2.positionName = "Scrum Master";

		// Create Account
		Account account = new Account();
		account.accountId = 1;
		account.email = "duyanhr01@gmail.com";
		account.userName = "Anh";
		account.fullName = "NguyenDuyAnh";
		account.department = department;
		account.position = position;
		account.createDate = LocalDateTime.of(2020, 11, 26, 13, 55, 36, 123);

		// Create Account
		Account account1 = new Account();
		account1.accountId = 2;
		account1.email = "trung@gmail.com";
		account1.userName = "Trung";
		account1.fullName = "Phan Huu Trung";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = LocalDateTime.of(2020, 11, 26, 13, 55, 36, 123);

		// Create Account
		Account account2 = new Account();
		account2.accountId = 3;
		account2.email = "huong@gmail.com";
		account2.userName = "Huong";
		account2.fullName = "Nguyen Duy Huong";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = LocalDateTime.of(2020, 11, 26, 13, 55, 36, 123);

		// Create Group
		Group group = new Group();
		group.groupId = 1;
		group.groupName = "ADN LAND";
		group.creator = account;
		group.createDate = LocalDateTime.of(2020, 11, 26, 13, 55, 36, 123);

		Group group1 = new Group();
		group1.groupId = 2;
		group1.groupName = "AD HOMES";
		group1.creator = account;
		group1.createDate = LocalDateTime.of(2019, 10, 22, 10, 5, 6, 123);

		Group group2 = new Group();
		group2.groupId = 3;
		group2.groupName = "90 LAND";
		group2.creator = account;
		group2.createDate = LocalDateTime.of(2021, 1, 26, 3, 25, 26, 123);

		// 1 department nhieu account
		Account[] DepartmentAccount = { account, account1, account2 };
		department.accounts = DepartmentAccount;
		Account[] DepartmentAccount1 = { account, account1, account2 };
		department1.accounts = DepartmentAccount1;
		Account[] DepartmentAccount2 = { account, account1, account2 };
		department2.accounts = DepartmentAccount2;

		// position co nhieu account
		Account[] PositionAccount = { account, account1, account2 };
		position.accounts = PositionAccount;
		Account[] PositionAccount1 = { account, account1, account2 };
		position1.accounts = PositionAccount1;
		Account[] PositionAccount2 = { account, account1, account2 };
		position2.accounts = PositionAccount2;
		// accountgroup
		Group[] GroupAccount = { group, group1, group2 };
		account.groups = GroupAccount;
		Group[] GroupAccount1 = { group, group1, group2 };
		account1.groups = GroupAccount1;
		Group[] GroupAccount2 = { group, group1, group2 };
		account2.groups = GroupAccount2;

		//
		Account[] AccountGroup = { account, account1, account2 };
		group.accounts = AccountGroup;
		Account[] AccountGroup1 = { account, account1, account2 };
		group1.accounts = AccountGroup1;
		Account[] AccountGroup2 = { account, account1, account2 };
		group2.accounts = AccountGroup2;

		// Create TypeQuestion

		TypeQuestion typeQuestion = new TypeQuestion();
		typeQuestion.typeId = 1;
		typeQuestion.typeName = TypeName.ESSAY;

		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.typeId = 2;
		typeQuestion1.typeName = TypeName.MULTIPLE_CHOICE;
		// Create CategoryQuestion
		CategoryQuestion categoryQuestion = new CategoryQuestion();
		categoryQuestion.categoryId = 1;
		categoryQuestion.categoryName = "Java";

		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.categoryId = 2;
		categoryQuestion1.categoryName = "SQL";

		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.categoryId = 3;
		categoryQuestion2.categoryName = "Ruby";

		// Create Question
		Question question = new Question();
		question.questionId = 1;
		question.content = "cau hoi Java day la noi dung content dau tien";
		question.categoryQuestion = categoryQuestion;
		question.typeQuestion = typeQuestion;
		question.creator = account1;
		question.createDate = LocalDateTime.of(2021, 1, 26, 3, 25, 26, 123);

		Question question1 = new Question();
		question1.questionId = 2;
		question1.content = "tai sao ban hoc SQL day la noi dung content";
		question1.categoryQuestion = categoryQuestion1;
		question1.typeQuestion = typeQuestion;
		question1.creator = account2;
		question1.createDate = LocalDateTime.of(2021, 9, 25, 3, 25, 26, 123);

		Question question2 = new Question();
		question2.questionId = 3;
		question2.content = "tai sao ban hoc Ruby day la noi dung content ";
		question2.categoryQuestion = categoryQuestion2;
		question2.typeQuestion = typeQuestion1;
		question2.creator = account;
		question2.createDate = LocalDateTime.of(2021, 8, 2, 3, 25, 26, 123);

		// Create Answer
		Answer answer = new Answer();
		answer.answerId = 1;
		answer.content = "Java day la noi dung cau tra loi cho cau hoi cau hoi";
		answer.question = question;
		answer.isCorrect = true;

		Answer answer1 = new Answer();
		answer1.answerId = 2;
		answer1.content = "SQL day la noi dung cau tra loi cho cau hoi sao ban hoc";
		answer1.question = question1;
		answer1.isCorrect = true;

		Answer answer2 = new Answer();
		answer2.answerId = 3;
		answer2.content = "Ruby day la noi dung cau tra loi cho cau hoi sao ban hoc";
		answer2.question = question2;
		answer2.isCorrect = false;
		// Create Exam
		Exam exam = new Exam();
		exam.examId = 1;
		exam.code = "11AE";
		exam.title = "Tieu de bai thi 11";
		exam.category = categoryQuestion1;
		exam.duration = 60;
		exam.creator = account1;
		exam.createDate = LocalDateTime.of(2021, 8, 2, 3, 25, 26, 123);

		Exam exam1 = new Exam();
		exam1.examId = 2;
		exam1.code = "PC11";
		exam1.title = "Tieu de bai thi 12";
		exam1.category = categoryQuestion;
		exam1.duration = 60;
		exam1.creator = account2;
		exam1.createDate = LocalDateTime.of(2021, 8, 2, 3, 25, 26, 123);

		Exam exam2 = new Exam();
		exam2.examId = 3;
		exam2.code = "PV34";
		exam2.title = "Tieu de bai thi 13";
		exam2.category = categoryQuestion2;
		exam2.duration = 60;
		exam2.creator = account1;
		exam2.createDate = LocalDateTime.of(2021, 8, 2, 3, 25, 26, 123);

		// abng tyoe question
		Question[] questionType = { question, question1, question2 };
		typeQuestion.questions = questionType;
		Question[] questionType1 = { question, question1, question2 };
		typeQuestion1.questions = questionType1;
		// category
		Question[] questionCategory = { question, question1, question2 };
		categoryQuestion.questions = questionCategory;
		Question[] questionCategory1 = { question, question1, question2 };
		categoryQuestion1.questions = questionCategory1;
		// queston
		Exam[] examQueston = { exam, exam1, exam2 };
		question.exams = examQueston;
		Exam[] examQueston1 = { exam, exam1, exam2 };
		question1.exams = examQueston1;
		Exam[] examQueston2 = { exam, exam1, exam2 };
		question2.exams = examQueston2;
		// exam
		Question[] questionExam = { question, question1, question2 };
		exam.questions = questionExam;
		Question[] questionExam1 = { question, question1, question2 };
		exam1.questions = questionExam1;
		Question[] questionExam2 = { question, question1, question2 };
		exam2.questions = questionExam2;
		// in ra
		// Department
		System.out.println("Phong ban marketing la:");
		System.out.println("departmentId:" + department.departmentId);
		System.out.println("departmentName:" + department.departmentName);

		// position
		System.out.println("chuc vu  dev la:");
		System.out.println("positionId:" + position.positionId);
		System.out.println("positionName:" + position.positionName);
		// group
		System.out.println("groupId:" + group.groupId);
		System.out.println("groupName:" + group.groupName);
		System.out.println("Ngay tao: " + group.createDate);
		System.out.println("account group:" + group.creator);
		// Account
		System.out.println("Account  Nguyen Duy Anh la:");
		System.out.println("accountId:" + account.accountId);
		System.out.println("Email:" + account.email);
		System.out.println("userName:" + account.userName);
		System.out.println("fullName:" + account.fullName);
		System.out.println("Department Id:" + account.department.departmentId);
		System.out.println("Position Id:" + account.position.positionId);
		System.out.println("Ngay Tao:" + account.createDate);
		System.out.println("groupaccount:" + account.groups);

//		Exercise 1 (Optional): Flow Control
		if (account.department == null) {
			System.out.println("Nhan vien chua co phong ban ");
		} else {
			System.out.println("Phong ban cua nhan vien nay la " + account.department.departmentName);
		}

//				Question 2:
//					Kiá»ƒm tra account thá»© 2
//					Náº¿u khÃ´ng cÃ³ group thÃ¬ sáº½ in ra text "NhÃ¢n viÃªn nÃ y chÆ°a cÃ³ group"
//					Náº¿u cÃ³ máº·t trong 1 hoáº·c 2 group thÃ¬ sáº½ in ra text "Group cá»§a nhÃ¢n viÃªn
//					nÃ y lÃ  Java Fresher, C# Fresher"
//					Náº¿u cÃ³ máº·t trong 3 Group thÃ¬ sáº½ in ra text "NhÃ¢n viÃªn nÃ y lÃ  ngÆ°á»�i
//					quan trá»�ng, tham gia nhiá»�u group"
//					Náº¿u cÃ³ máº·t trong 4 group trá»Ÿ lÃªn thÃ¬ sáº½ in ra text "NhÃ¢n viÃªn nÃ y lÃ 
//					ngÆ°á»�i hÃ³ng chuyá»‡n, tham gia táº¥t cáº£ cÃ¡c group"
		if (account1.groups.length == 0) {
			System.out.println("NhÃ¢n viÃªn chÆ°a cÃ³ group");
		} else if (account1.groups.length == 1 || account1.groups.length == 2) {
			System.out.println("Group cá»§a nhÃ¢n viÃªn nÃ y lÃ  Java Fresher, C# Fresher");
		} else if (account1.groups.length == 3) {
			System.out.println(" nhÃ¢n viÃªn nÃ y quan trong ");
		} else {
			System.out.println("Nhan vien nay la nguoi hong chuyen");

		}
		System.out.println("\n");
//		Question 3:
//			Sá»­ dá»¥ng toÃ¡n tá»­ ternary Ä‘á»ƒ lÃ m Question 1

		System.out.println((account.department == null) ? "Nhan vien chua co phong ban "
				: "Phong ban cua nhan vien nay la " + account.department.departmentName);
		System.out.println("\n");
//		Question 4:
//			Sá»­ dá»¥ng toÃ¡n tá»­ ternary Ä‘á»ƒ lÃ m yÃªu cáº§u sau:
//			Kiá»ƒm tra Position cá»§a account thá»© 1
//			Náº¿u Position = Dev thÃ¬ in ra text "Ä�Ã¢y lÃ  Developer"
//			Náº¿u khÃ´ng pháº£i thÃ¬ in ra text "NgÆ°á»�i nÃ y khÃ´ng pháº£i lÃ  Developer"
		System.out.println(
				account.position.positionName == "Dev" ? "Ä�Ã¢y lÃ  Developer" : "NgÆ°á»�i nÃ y khÃ´ng pháº£i lÃ  Developer");
		System.out.println("\n");
//		SWITCH CASE
//		Question 5:
//		
		switch (group.accounts.length) {
		case 1:
			System.out.println("NhÃ³m cÃ³ má»™t thÃ nh viÃªn");
			break;
		case 2:
			System.out.println("NhÃ³m cÃ³ hai thÃ nh viÃªn");
			break;
		case 3:
			System.out.println("NhÃ³m cÃ³ ba thÃ nh viÃªn");
			break;
		default:
			System.out.println("NhÃ³m cÃ³ nhiá»�u thÃ nh viÃªn");
			break;
		}
		System.out.println("\n");
//		Question 6

		switch (account1.groups.length) {
		case 0:
			System.out.println("NhÃ¢n viÃªn chÆ°a cÃ³ group");
			break;
		case 1:
		case 2:
			System.out.println("Group cá»§a nhÃ¢n viÃªn nÃ y lÃ  Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println(" nhÃ¢n viÃªn nÃ y quan trong ");
			break;
		default:

			System.out.println("Nhan vien nay la nguoi hong chuyen");

		}
//		Question 7:
//			Sá»­ dá»¥ng switch case Ä‘á»ƒ lÃ m láº¡i Question 4
		switch (account.position.positionName) {
		case "Dev":
			System.out.println("nguoi nÃ y lÃ  Dev");
			break;
		default:
			System.out.println("nguoi nÃ y khong pahi la  Dev");
			break;
		}
		System.out.println("\n");
//			FOREACH
//			Question 8:
//			In ra thÃ´ng tin cÃ¡c account bao gá»“m: Email, FullName vÃ  tÃªn phÃ²ng ban cá»§a
//			há»�	
		Account[] accounts = { account, account1, account2 };
		int i = 0;
		for (Account Account : accounts) {
			System.out.println("thong tin account thu " + (i + 1) + " la:");
			System.out.println("Email: " + Account.email);
			System.out.println("Full Name: " + Account.fullName);
			System.out.println("Phong ban: " + Account.department.departmentName);
			i++;
			System.out.println("\n");

		}
//			Question 9:
//				In ra thÃ´ng tin cÃ¡c phÃ²ng ban bao gá»“m: id vÃ  name
		Department[] departments = { department, department1, department2 };
		int j = 0;
		for (Department Department : departments) {
			System.out.println("thong tin phong ban thu " + (j + 1) + " la :");
			System.out.println("departmentId  : " + Department.departmentId);
			System.out.println("departmentName  :" + Department.departmentName);
			j++;
			System.out.println("\n");

		}
		// FOR
//			Question 10:
//				In ra thÃ´ng tin cÃ¡c account bao gá»“m: Email, FullName vÃ  tÃªn phÃ²ng ban cá»§a
//				há»� theo Ä‘á»‹nh dáº¡ng nhÆ° sau:
//				ThÃ´ng tin account thá»© 1 lÃ :
//				Email: NguyenVanA@gmail.com
//				Full name: Nguyá»…n VÄƒn A
//				PhÃ²ng ban: Sale
//				ThÃ´ng tin account thá»© 2 lÃ :
//				Email: NguyenVanB@gmail.com
//				Full name: Nguyá»…n VÄƒn B
//				PhÃ²ng ban: Marketting
		for (i = 0; i < accounts.length; i++) {
			System.out.println("thong tin account thu " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phong ban: " + accounts[i].department.departmentName);

			System.out.println("\n");
		}
//			Question 11:
//				In ra thÃ´ng tin cÃ¡c phÃ²ng ban bao gá»“m: id vÃ  name theo Ä‘á»‹nh dáº¡ng sau:
//				ThÃ´ng tin department thá»© 1 lÃ :
//				Id: 1
//				Name: Sale
//				ThÃ´ng tin department thá»© 2 lÃ :
//				Id: 2
//				Name: Marketing

		for (i = 0; i < departments.length; i++) {
			System.out.println("ThÃ´ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
		}
//			Question 12:
//				Chá»‰ in ra thÃ´ng tin 2 department Ä‘áº§u tiÃªn theo Ä‘á»‹nh dáº¡ng nhÆ° Question 10
////			in ra 2 account dau tien 
		for (i = 0; i < 2; i++) {
			System.out.println("thong tin account thu " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phong ban: " + accounts[i].department.departmentName);

			System.out.println("\n");
		}
		// in ra 2 department dau

		for (i = 0; i < 2; i++) {
			System.out.println("ThÃ´ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
		}
//			Question 13:
//				In ra thÃ´ng tin táº¥t cáº£ cÃ¡c account ngoáº¡i trá»« account thá»© 2
		for (i = 0; i < accounts.length; i++) {
			if (i != 1) {

				System.out.println("thong tin account thu " + (i + 1) + " la:");

				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full Name: " + accounts[i].fullName);
				System.out.println("Phong ban: " + accounts[i].department.departmentName);

				System.out.println("\n");
			}
		}
//		Question 14:
//			In ra thÃ´ng tin táº¥t cáº£ cÃ¡c account cÃ³ id < 4
		for (i = 0; i < accounts.length; i++) {
			if (accounts[i].accountId < 4) {
				System.out.println("thong tin account thu " + (i + 1) + " la:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full Name: " + accounts[i].fullName);
				System.out.println("Phong ban: " + accounts[i].department.departmentName);

				System.out.println("\n");
			}
		}

//		Question 15:
//			In ra cÃ¡c sá»‘ cháºµn nhá»� hÆ¡n hoáº·c báº±ng 20
		for (i = 0; i <= 20; i++) {
			if (i % 2 == 0) {

				System.out.println(i);
			}
		}
		// WHILE
//		Question 16:
//			LÃ m láº¡i cÃ¡c Question á»Ÿ pháº§n FOR báº±ng cÃ¡ch sá»­ dá»¥ng WHILE káº¿t há»£p vá»›i
//			lá»‡nh break, continue
		// cau 10
		i = 0;
		while (i < accounts.length) {

			System.out.println("thong tin account thu " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phong ban: " + accounts[i].department.departmentName);
			i++;
			System.out.println("\n");

		}
		// cÃ¢u 11
		i = 0;
		while (i < departments.length) {

			System.out.println("ThÃ´ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
			i++;
			System.out.println("\n");
		}
		// cÃ¢u 12
		i = 0;
		while (i < 2) {
			System.out.println("ThÃ´ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
			i++;
		}
		// cau 13
		i = 0;
		while (i < accounts.length) {
			if (i != 1) {

				System.out.println("thong tin account thu " + (i + 1) + " la:");

				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full Name: " + accounts[i].fullName);
				System.out.println("Phong ban: " + accounts[i].department.departmentName);

				System.out.println("\n");
			}
			i++;

		}
		// cau 14
		i = 0;
		while (i < accounts.length) {
			if (accounts[i].accountId < 4) {
				System.out.println("thong tin account thu " + (i + 1) + " la:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full Name: " + accounts[i].fullName);
				System.out.println("Phong ban: " + accounts[i].department.departmentName);

				System.out.println("\n");
			}
			i++;

		}
		// cau 15
		i = 0;
		while (i <= 20) {
			if (i % 2 == 0) {

				System.out.println(i);
			}
			i++;

		}
//		DO-WHILE
//		Question 17:
//		LÃ m láº¡i cÃ¡c Question á»Ÿ pháº§n FOR báº±ng cÃ¡ch sá»­ dá»¥ng DO-WHILE káº¿t há»£p vá»›i
//		lá»‡nh break, continue
		// cau 10
		i = 0;
		do {
			System.out.println("thong tin account thu " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phong ban: " + accounts[i].department.departmentName);

			System.out.println("\n");
			i++;
		} while (i < accounts.length);
		// cau 11
		i = 0;
		do {
			System.out.println("ThÃ´ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
			i++;
			System.out.println("\n");
		} while (i < departments.length);
		// cau 12
		i = 0;
		do {
			System.out.println("ThÃ´ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
			i++;
		} while (i < 2);
		// cau 13
		i = 0;
		do {
			if (i != 1) {

				System.out.println("thong tin account thu " + (i + 1) + " la:");

				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full Name: " + accounts[i].fullName);
				System.out.println("Phong ban: " + accounts[i].department.departmentName);

				System.out.println("\n");
			}
			i++;
		} while (i < accounts.length);
		// cau 14
		i = 0;
		do {
			if (accounts[i].accountId < 4) {
				System.out.println("thong tin account thu " + (i + 1) + " la:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full Name: " + accounts[i].fullName);
				System.out.println("Phong ban: " + accounts[i].department.departmentName);

				System.out.println("\n");
			}
			i++;
		} while (i < accounts.length);
		// cau 15
		i = 0;
		do {
			if (i % 2 == 0) {

				System.out.println(i);
			}
			i++;
		} while (i <= 20);
//		Exercise 2 (Optional): System out printf
//		Question 1:
//			Khai bÃ¡o 1 sá»‘ nguyÃªn = 5 vÃ  sá»­ dá»¥ng lá»‡nh System out printf Ä‘á»ƒ in ra sá»‘
//			nguyÃªn Ä‘Ã³

		int x = 5;
		System.out.println(x);
//		Question 2:
//			Khai bÃ¡o 1 sá»‘ nguyÃªn = 100 000 000 vÃ  sá»­ dá»¥ng lá»‡nh System out printf Ä‘á»ƒ in
//			ra sá»‘ nguyÃªn Ä‘Ã³ thÃ nh Ä‘á»‹nh dáº¡ng nhÆ° sau: 100,000,000
		long k = 100000000;
		System.out.printf(Locale.US, "%,d", k);
		System.out.println("\n");
		// lam lai
		long h = 100000000;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		System.out.printf(formatter.format(h));
//		Question 3:
//			Khai bÃ¡o 1 sá»‘ thá»±c = 5,567098 vÃ  sá»­ dá»¥ng lá»‡nh System out printf Ä‘á»ƒ in ra sá»‘
//			thá»±c Ä‘Ã³ chá»‰ bao gá»“m 4 sá»‘ Ä‘áº±ng sau
		System.out.println("\n");
		float sothuc = 5.567098f;
		System.out.printf("%.4f %n", sothuc);

//		Question 4:
//			Khai bÃ¡o Há»� vÃ  tÃªn cá»§a 1 há»�c sinh vÃ  in ra há»� vÃ  tÃªn há»�c sinh Ä‘Ã³ theo Ä‘á»‹nh
//			dáº¡ng nhÆ° sau:
//			Há»� vÃ  tÃªn: "Nguyá»…n VÄƒn A" thÃ¬ sáº½ in ra trÃªn console nhÆ° sau:
//			TÃªn tÃ´i lÃ  "Nguyá»…n VÄƒn A" vÃ  tÃ´i Ä‘ang Ä‘á»™c thÃ¢n.

		String hoTen = "Nguyá»…n VÄƒn A";
		System.out.printf("TÃªn tÃ´i lÃ  %s vÃ  tÃ´i Ä‘ang Ä‘á»™c thÃ¢n", hoTen);
		System.out.println("\n");
//		Question 5:
//			Láº¥y thá»�i gian bÃ¢y giá»� vÃ  in ra theo Ä‘á»‹nh dáº¡ng sau:
//			24/04/2020 11h:16p:20s

		Date date = new Date();
		System.out.printf("%1$td/ %1$tm/ %1$ty  %tHh:%tMp:%tS%ns", date, date, date, date);
		System.out.println();
//		Question 6:
//			In ra thÃ´ng tin account (nhÆ° Question 8 pháº§n FOREACH) theo Ä‘á»‹nh dáº¡ng
//			table (giá»‘ng trong Database)
		System.out.printf("%-40s %-50s %s \n", "id", "email", "fullname");
		System.out.printf("%-40s %-50s %s \n", account.accountId, account.email, account.fullName);
		System.out.printf("%-40s %-50s %s \n", account1.accountId, account1.email, account1.fullName);
		System.out.printf("%-40s %-50s %s \n", account2.accountId, account2.email, account2.fullName);
//		Exercise 3 (Optional): Date Format
//		Question 1:
//		In ra thÃ´ng tin Exam thá»© 1 vÃ  property create date sáº½ Ä‘Æ°á»£c format theo Ä‘á»‹nh
//		dáº¡ng vietnamese
		System.out.println(exam.createDate);

//		Question 2:
//		In ra thÃ´ng tin: Exam Ä‘Ã£ táº¡o ngÃ y nÃ o theo Ä‘á»‹nh dáº¡ng
//		NÄƒm â€“ thÃ¡ng â€“ ngÃ y â€“ giá»� â€“ phÃºt â€“ giÃ¢y
		System.out.println(exam.createDate); // vi dinh dang la loacaldatime sáºµn rá»“i
//		Question 3:
//		Chá»‰ in ra nÄƒm cá»§a create date property trong Question 2
//

//		48
//
//		Question 4:
//		Chá»‰ in ra thÃ¡ng vÃ  nÄƒm cá»§a create date property trong Question 2
//		Question 5:
//		Chá»‰ in ra "MM-DD" cá»§a create date trong Question 2

//		Exercise 4 (Optional): Random Number
//		Question 1:
//		In ngáº«u nhiÃªn ra 1 sá»‘ nguyÃªn
//		Question 2:
//		In ngáº«u nhiÃªn ra 1 sá»‘ thá»±c
//		Question 3:
//		Khai bÃ¡o 1 array bao gá»“m cÃ¡c tÃªn cá»§a cÃ¡c báº¡n trong lá»›p, sau Ä‘Ã³ in ngáº«u nhiÃªn
//		ra tÃªn cá»§a 1 báº¡n
//		Question 4:
//		Láº¥y ngáº«u nhiÃªn 1 ngÃ y trong khoáº£ng thá»�i gian 24-07-1995 tá»›i ngÃ y 20-12-
//		1995
//		Question 5:
//		Láº¥y ngáº«u nhiÃªn 1 ngÃ y trong khoáº£ng thá»�i gian 1 nÄƒm trá»Ÿ láº¡i Ä‘Ã¢y
//		Question 6:
//		Láº¥y ngáº«u nhiÃªn 1 ngÃ y trong quÃ¡ khá»©
//		Question 7:
//		Láº¥y ngáº«u nhiÃªn 1 sá»‘ cÃ³ 3 chá»¯ sá»‘
//		Exercise 5: Input from console
//		Question 1:
//		Viáº¿t lá»‡nh cho phÃ©p ngÆ°á»�i dÃ¹ng nháº­p 3 sá»‘ nguyÃªn vÃ o chÆ°Æ¡ng trÃ¬nh
		int soCanNhap1, soCanNhap2, soCanNhap3;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap  va so thu 1: ");
		soCanNhap1 = sc.nextInt();
		System.out.println("Nhap  va so thu 2: ");
		soCanNhap2 = sc.nextInt();
		System.out.println("Nhap  va so thu 3: ");
		soCanNhap3 = sc.nextInt();
		System.out.printf("%d,%d,%d", soCanNhap1, soCanNhap2, soCanNhap3);
		System.out.println("\n");
//		Question 2:
//		Viáº¿t lá»‡nh cho phÃ©p ngÆ°á»�i dÃ¹ng nháº­p 2 sá»‘ thá»±c vÃ o chÆ°Æ¡ng trÃ¬nh

		System.out.println("Nhap vao  so thuc thu 1: ");
		float soThuc1 = sc.nextFloat();

		System.out.println("Nhap vao  so thu thu 2: ");
		float soThuc2 = sc.nextFloat();
		System.out.printf("2 so vua nhap la %f, %f", soThuc1, soThuc2);

		System.out.println("\n");

//		Question 3:
//		Viáº¿t lá»‡nh cho phÃ©p ngÆ°á»�i dÃ¹ng nháº­p há»� vÃ  tÃªn
		System.out.println("Nhap Ho  cua ban:");
		String ho = sc.next();

		System.out.println("\n");
		System.out.println("Nhap Ten  cua ban:");
		String ten = sc.next();

		System.out.printf("Ho ten cua ban la:%s  %s", ho, ten);
		System.out.println("\n");
//		Question 4:
//		Viáº¿t lá»‡nh cho phÃ©p ngÆ°á»�i dÃ¹ng nháº­p vÃ o ngÃ y sinh nháº­t cá»§a há»�
		System.out.println("nhap vao ngay sinh cua ban:");
		String date1 = sc.next();
		// string ---> date
		String dinhdang = "DD-MM-YYYY";
		SimpleDateFormat format = new SimpleDateFormat(dinhdang);
		Date date2 = format.parse(date1);
		System.out.printf("Ban vua nhap vao ngay sinh nhat la: " + date2);
		sc.close();
//		Question 5:
//		Viáº¿t lá»‡nh cho phÃ©p ngÆ°á»�i dÃ¹ng táº¡o account (viáº¿t thÃ nh method)
//		Ä�á»‘i vá»›i property Position, NgÆ°á»�i dÃ¹ng nháº­p vÃ o 1 2 3 4 5 vÃ  vÃ o
//		chÆ°Æ¡ng trÃ¬nh sáº½ chuyá»ƒn thÃ nh Position.Dev, Position.Test,
//		Position.ScrumMaster, Position.PM
//
//		5
		thongTinAccount();
	}

	public static void thongTinAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap so tu 1 den 5");
		int so = scanner.nextInt();
		switch (so) {
		case 1:
			System.out.println("Position.DEV");
			break;

		case 2:
			System.out.println("Position.Test");
			break;

		case 3:
			System.out.println("Position.ScrumMaster");
			break;

		case 4:
			System.out.println("Position.PM");
			break;
		}
//
//		Question 6:
//		Viáº¿t lá»‡nh cho phÃ©p ngÆ°á»�i dÃ¹ng táº¡o department (viáº¿t thÃ nh method)
//		Question 7:
//		Nháº­p sá»‘ cháºµn tá»« console
//		Question 8:
//		Viáº¿t chÆ°Æ¡ng trÃ¬nh thá»±c hiá»‡n theo flow sau:
//		BÆ°á»›c 1:
//		ChÆ°Æ¡ng trÃ¬nh in ra text "má»�i báº¡n nháº­p vÃ o chá»©c nÄƒng muá»‘n sá»­
//		dá»¥ng"
//		BÆ°á»›c 2:
//		Náº¿u ngÆ°á»�i dÃ¹ng nháº­p vÃ o 1 thÃ¬ sáº½ thá»±c hiá»‡n táº¡o account
//		Náº¿u ngÆ°á»�i dÃ¹ng nháº­p vÃ o 2 thÃ¬ sáº½ thá»±c hiá»‡n chá»©c nÄƒng táº¡o
//		department
//		Náº¿u ngÆ°á»�i dÃ¹ng nháº­p vÃ o sá»‘ khÃ¡c thÃ¬ in ra text "Má»�i báº¡n nháº­p
//		láº¡i" vÃ  quay trá»Ÿ láº¡i bÆ°á»›c 1
//
//		Question 9:
//		Viáº¿t method cho phÃ©p ngÆ°á»�i dÃ¹ng thÃªm group vÃ o account theo flow sau:
//		BÆ°á»›c 1:
//		In ra tÃªn cÃ¡c usernames cá»§a user cho ngÆ°á»�i dÃ¹ng xem
//		BÆ°á»›c 2:
//		YÃªu cáº§u ngÆ°á»�i dÃ¹ng nháº­p vÃ o username cá»§a account
//		BÆ°á»›c 3:
//		In ra tÃªn cÃ¡c group cho ngÆ°á»�i dÃ¹ng xem
//		BÆ°á»›c 4:
//		YÃªu cáº§u ngÆ°á»�i dÃ¹ng nháº­p vÃ o tÃªn cá»§a group
//		BÆ°á»›c 5:
//		Dá»±a vÃ o username vÃ  tÃªn cá»§a group ngÆ°á»�i dÃ¹ng vá»«a chá»�n, hÃ£y
//		thÃªm account vÃ o group Ä‘Ã³ .
//		Question 10: Tiáº¿p tá»¥c Question 8 vÃ  Question 9
//		Bá»• sung thÃªm vÃ o bÆ°á»›c 2 cá»§a Question 8 nhÆ° sau:
//		Náº¿u ngÆ°á»�i dÃ¹ng nháº­p vÃ o 3 thÃ¬ sáº½ thá»±c hiá»‡n chá»©c nÄƒng thÃªm group vÃ o
//		account
//		Bá»• sung thÃªm BÆ°á»›c 3 cá»§a Question 8 nhÆ° sau:
//		Sau khi ngÆ°á»�i dÃ¹ng thá»±c hiá»‡n xong chá»©c nÄƒng á»Ÿ bÆ°á»›c 2 thÃ¬ in ra dÃ²ng
//		text Ä‘á»ƒ há»�i ngÆ°á»�i dÃ¹ng "Báº¡n cÃ³ muá»‘n thá»±c hiá»‡n chá»©c nÄƒng khÃ¡c
//		khÃ´ng?". Náº¿u ngÆ°á»�i dÃ¹ng chá»�n "CÃ³" thÃ¬ quay láº¡i bÆ°á»›c 1, náº¿u ngÆ°á»�i
//		dÃ¹ng chá»�n "KhÃ´ng" thÃ¬ káº¿t thÃºc chÆ°Æ¡ng trÃ¬nh (sá»­ dá»¥ng lá»‡nh return Ä‘á»ƒ
//		káº¿t thÃºc chÆ°Æ¡ng trÃ¬nh)
//		Question 11: Tiáº¿p tá»¥c Question 10
//		Bá»• sung thÃªm vÃ o bÆ°á»›c 2 cá»§a Question 8 nhÆ° sau:
//		Náº¿u ngÆ°á»�i dÃ¹ng nháº­p vÃ o 4 thÃ¬ sáº½ thá»±c hiá»‡n chá»©c nÄƒng thÃªm account
//		vÃ o 1 nhÃ³m ngáº«u nhiÃªn, chá»©c nÄƒng sáº½ Ä‘Æ°á»£c cÃ i Ä‘áº·t nhÆ° sau:
//		BÆ°á»›c 1:
//		In ra tÃªn cÃ¡c usernames cá»§a user cho ngÆ°á»�i dÃ¹ng xem
//
//		6
//
//		BÆ°á»›c 2:
//		YÃªu cáº§u ngÆ°á»�i dÃ¹ng nháº­p vÃ o username cá»§a account
//		BÆ°á»›c 3:
//		Sau Ä‘Ã³ chÆ°Æ¡ng trÃ¬nh sáº½ chá»�n ngáº«u nhiÃªn 1 group
//		BÆ°á»›c 4:
//		ThÃªm account vÃ o group chÆ°Æ¡ng trÃ¬nh vá»«a chá»�n ngáº«u
//		nhiÃªn
	}

}
