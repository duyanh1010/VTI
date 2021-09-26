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
//					Kiểm tra account thứ 2
//					Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//					Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
//					này là Java Fresher, C# Fresher"
//					Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
//					quan trọng, tham gia nhiều group"
//					Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
//					người hóng chuyện, tham gia tất cả các group"
		if (account1.groups.length == 0) {
			System.out.println("Nhân viên chưa có group");
		} else if (account1.groups.length == 1 || account1.groups.length == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if (account1.groups.length == 3) {
			System.out.println(" nhân viên này quan trong ");
		} else {
			System.out.println("Nhan vien nay la nguoi hong chuyen");

		}
		System.out.println("\n");
//		Question 3:
//			Sử dụng toán tử ternary để làm Question 1

		System.out.println((account.department == null) ? "Nhan vien chua co phong ban "
				: "Phong ban cua nhan vien nay la " + account.department.departmentName);
		System.out.println("\n");
//		Question 4:
//			Sử dụng toán tử ternary để làm yêu cầu sau:
//			Kiểm tra Position của account thứ 1
//			Nếu Position = Dev thì in ra text "Đây là Developer"
//			Nếu không phải thì in ra text "Người này không phải là Developer"
		System.out.println(
				account.position.positionName == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");
		System.out.println("\n");
//		SWITCH CASE
//		Question 5:
//		
		switch (group.accounts.length) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}
		System.out.println("\n");
//		Question 6

		switch (account1.groups.length) {
		case 0:
			System.out.println("Nhân viên chưa có group");
			break;
		case 1:
		case 2:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println(" nhân viên này quan trong ");
			break;
		default:

			System.out.println("Nhan vien nay la nguoi hong chuyen");

		}
//		Question 7:
//			Sử dụng switch case để làm lại Question 4
		switch (account.position.positionName) {
		case "Dev":
			System.out.println("nguoi này là Dev");
			break;
		default:
			System.out.println("nguoi này khong pahi la  Dev");
			break;
		}
		System.out.println("\n");
//			FOREACH
//			Question 8:
//			In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//			họ	
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
//				In ra thông tin các phòng ban bao gồm: id và name
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
//				In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//				họ theo định dạng như sau:
//				Thông tin account thứ 1 là:
//				Email: NguyenVanA@gmail.com
//				Full name: Nguyễn Văn A
//				Phòng ban: Sale
//				Thông tin account thứ 2 là:
//				Email: NguyenVanB@gmail.com
//				Full name: Nguyễn Văn B
//				Phòng ban: Marketting
		for (i = 0; i < accounts.length; i++) {
			System.out.println("thong tin account thu " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phong ban: " + accounts[i].department.departmentName);

			System.out.println("\n");
		}
//			Question 11:
//				In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//				Thông tin department thứ 1 là:
//				Id: 1
//				Name: Sale
//				Thông tin department thứ 2 là:
//				Id: 2
//				Name: Marketing

		for (i = 0; i < departments.length; i++) {
			System.out.println("Thông tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
		}
//			Question 12:
//				Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
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
			System.out.println("Thông tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
		}
//			Question 13:
//				In ra thông tin tất cả các account ngoại trừ account thứ 2
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
//			In ra thông tin tất cả các account có id < 4
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
//			In ra các số chẵn nhỏ hơn hoặc bằng 20
		for (i = 0; i <= 20; i++) {
			if (i % 2 == 0) {

				System.out.println(i);
			}
		}
		// WHILE
//		Question 16:
//			Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với
//			lệnh break, continue
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
		// câu 11
		i = 0;
		while (i < departments.length) {

			System.out.println("Thông tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
			i++;
			System.out.println("\n");
		}
		// câu 12
		i = 0;
		while (i < 2) {
			System.out.println("Thông tin departmnet thu " + (i + 1) + " la :");
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
//		Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với
//		lệnh break, continue
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
			System.out.println("Thông tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
			i++;
			System.out.println("\n");
		} while (i < departments.length);
		// cau 12
		i = 0;
		do {
			System.out.println("Thông tin departmnet thu " + (i + 1) + " la :");
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
//			Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
//			nguyên đó

		int x = 5;
		System.out.println(x);
//		Question 2:
//			Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
//			ra số nguyên đó thành định dạng như sau: 100,000,000
		long k = 100000000;
		System.out.printf(Locale.US, "%,d", k);
		System.out.println("\n");
		// lam lai
		long h = 100000000;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		System.out.printf(formatter.format(h));
//		Question 3:
//			Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
//			thực đó chỉ bao gồm 4 số đằng sau
		System.out.println("\n");
		float sothuc = 5.567098f;
		System.out.printf("%.4f %n", sothuc);

//		Question 4:
//			Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
//			dạng như sau:
//			Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//			Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.

		String hoTen = "Nguyễn Văn A";
		System.out.printf("Tên tôi là %s và tôi đang độc thân", hoTen);
		System.out.println("\n");
//		Question 5:
//			Lấy thời gian bây giờ và in ra theo định dạng sau:
//			24/04/2020 11h:16p:20s

		Date date = new Date();
		System.out.printf("%1$td/ %1$tm/ %1$ty  %tHh:%tMp:%tS%ns", date, date, date, date);
		System.out.println();
//		Question 6:
//			In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
//			table (giống trong Database)
		System.out.printf("%-40s %-50s %s \n", "id", "email", "fullname");
		System.out.printf("%-40s %-50s %s \n", account.accountId, account.email, account.fullName);
		System.out.printf("%-40s %-50s %s \n", account1.accountId, account1.email, account1.fullName);
		System.out.printf("%-40s %-50s %s \n", account2.accountId, account2.email, account2.fullName);
//		Exercise 3 (Optional): Date Format
//		Question 1:
//		In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
//		dạng vietnamese
		System.out.println(exam.createDate);

//		Question 2:
//		In ra thông tin: Exam đã tạo ngày nào theo định dạng
//		Năm – tháng – ngày – giờ – phút – giây
		System.out.println(exam.createDate); // vi dinh dang la loacaldatime sẵn rồi
//		Question 3:
//		Chỉ in ra năm của create date property trong Question 2
//

//		48
//
//		Question 4:
//		Chỉ in ra tháng và năm của create date property trong Question 2
//		Question 5:
//		Chỉ in ra "MM-DD" của create date trong Question 2

//		Exercise 4 (Optional): Random Number
//		Question 1:
//		In ngẫu nhiên ra 1 số nguyên
//		Question 2:
//		In ngẫu nhiên ra 1 số thực
//		Question 3:
//		Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên
//		ra tên của 1 bạn
//		Question 4:
//		Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-
//		1995
//		Question 5:
//		Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
//		Question 6:
//		Lấy ngẫu nhiên 1 ngày trong quá khứ
//		Question 7:
//		Lấy ngẫu nhiên 1 số có 3 chữ số
//		Exercise 5: Input from console
//		Question 1:
//		Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
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
//		Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình

		System.out.println("Nhap vao  so thuc thu 1: ");
		float soThuc1 = sc.nextFloat();

		System.out.println("Nhap vao  so thu thu 2: ");
		float soThuc2 = sc.nextFloat();
		System.out.printf("2 so vua nhap la %f, %f", soThuc1, soThuc2);

		System.out.println("\n");

//		Question 3:
//		Viết lệnh cho phép người dùng nhập họ và tên
		System.out.println("Nhap Ho  cua ban:");
		String ho = sc.next();

		System.out.println("\n");
		System.out.println("Nhap Ten  cua ban:");
		String ten = sc.next();

		System.out.printf("Ho ten cua ban la:%s  %s", ho, ten);
		System.out.println("\n");
//		Question 4:
//		Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
		System.out.println("nhap vao ngay sinh cua ban:");
		String date1 = sc.next();
		// string ---> date
		String dinhdang = "DD-MM-YYYY";
		SimpleDateFormat format = new SimpleDateFormat(dinhdang);
		Date date2 = format.parse(date1);
		System.out.printf("Ban vua nhap vao ngay sinh nhat la: " + date2);
		sc.close();
//		Question 5:
//		Viết lệnh cho phép người dùng tạo account (viết thành method)
//		Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
//		chương trình sẽ chuyển thành Position.Dev, Position.Test,
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
//		Viết lệnh cho phép người dùng tạo department (viết thành method)
//		Question 7:
//		Nhập số chẵn từ console
//		Question 8:
//		Viết chương trình thực hiện theo flow sau:
//		Bước 1:
//		Chương trình in ra text "mời bạn nhập vào chức năng muốn sử
//		dụng"
//		Bước 2:
//		Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
//		Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo
//		department
//		Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập
//		lại" và quay trở lại bước 1
//
//		Question 9:
//		Viết method cho phép người dùng thêm group vào account theo flow sau:
//		Bước 1:
//		In ra tên các usernames của user cho người dùng xem
//		Bước 2:
//		Yêu cầu người dùng nhập vào username của account
//		Bước 3:
//		In ra tên các group cho người dùng xem
//		Bước 4:
//		Yêu cầu người dùng nhập vào tên của group
//		Bước 5:
//		Dựa vào username và tên của group người dùng vừa chọn, hãy
//		thêm account vào group đó .
//		Question 10: Tiếp tục Question 8 và Question 9
//		Bổ sung thêm vào bước 2 của Question 8 như sau:
//		Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào
//		account
//		Bổ sung thêm Bước 3 của Question 8 như sau:
//		Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng
//		text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác
//		không?". Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người
//		dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để
//		kết thúc chương trình)
//		Question 11: Tiếp tục Question 10
//		Bổ sung thêm vào bước 2 của Question 8 như sau:
//		Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account
//		vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
//		Bước 1:
//		In ra tên các usernames của user cho người dùng xem
//
//		6
//
//		Bước 2:
//		Yêu cầu người dùng nhập vào username của account
//		Bước 3:
//		Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
//		Bước 4:
//		Thêm account vào group chương trình vừa chọn ngẫu
//		nhiên
	}

}
