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
//					Ki???m tra account th??? 2
//					N???u kh??ng c?? group th?? s??? in ra text "Nh??n vi??n n??y ch??a c?? group"
//					N???u c?? m???t trong 1 ho???c 2 group th?? s??? in ra text "Group c???a nh??n vi??n
//					n??y l?? Java Fresher, C# Fresher"
//					N???u c?? m???t trong 3 Group th?? s??? in ra text "Nh??n vi??n n??y l?? ng?????i
//					quan tr???ng, tham gia nhi???u group"
//					N???u c?? m???t trong 4 group tr??? l??n th?? s??? in ra text "Nh??n vi??n n??y l??
//					ng?????i h??ng chuy???n, tham gia t???t c??? c??c group"
		if (account1.groups.length == 0) {
			System.out.println("Nh??n vi??n ch??a c?? group");
		} else if (account1.groups.length == 1 || account1.groups.length == 2) {
			System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");
		} else if (account1.groups.length == 3) {
			System.out.println(" nh??n vi??n n??y quan trong ");
		} else {
			System.out.println("Nhan vien nay la nguoi hong chuyen");

		}
		System.out.println("\n");
//		Question 3:
//			S??? d???ng to??n t??? ternary ????? l??m Question 1

		System.out.println((account.department == null) ? "Nhan vien chua co phong ban "
				: "Phong ban cua nhan vien nay la " + account.department.departmentName);
		System.out.println("\n");
//		Question 4:
//			S??? d???ng to??n t??? ternary ????? l??m y??u c???u sau:
//			Ki???m tra Position c???a account th??? 1
//			N???u Position = Dev th?? in ra text "????y l?? Developer"
//			N???u kh??ng ph???i th?? in ra text "Ng?????i n??y kh??ng ph???i l?? Developer"
		System.out.println(
				account.position.positionName == "Dev" ? "????y l?? Developer" : "Ng?????i n??y kh??ng ph???i l?? Developer");
		System.out.println("\n");
//		SWITCH CASE
//		Question 5:
//		
		switch (group.accounts.length) {
		case 1:
			System.out.println("Nh??m c?? m???t th??nh vi??n");
			break;
		case 2:
			System.out.println("Nh??m c?? hai th??nh vi??n");
			break;
		case 3:
			System.out.println("Nh??m c?? ba th??nh vi??n");
			break;
		default:
			System.out.println("Nh??m c?? nhi???u th??nh vi??n");
			break;
		}
		System.out.println("\n");
//		Question 6

		switch (account1.groups.length) {
		case 0:
			System.out.println("Nh??n vi??n ch??a c?? group");
			break;
		case 1:
		case 2:
			System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println(" nh??n vi??n n??y quan trong ");
			break;
		default:

			System.out.println("Nhan vien nay la nguoi hong chuyen");

		}
//		Question 7:
//			S??? d???ng switch case ????? l??m l???i Question 4
		switch (account.position.positionName) {
		case "Dev":
			System.out.println("nguoi n??y l?? Dev");
			break;
		default:
			System.out.println("nguoi n??y khong pahi la  Dev");
			break;
		}
		System.out.println("\n");
//			FOREACH
//			Question 8:
//			In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a
//			h???	
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
//				In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name
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
//				In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a
//				h??? theo ?????nh d???ng nh?? sau:
//				Th??ng tin account th??? 1 l??:
//				Email: NguyenVanA@gmail.com
//				Full name: Nguy???n V??n A
//				Ph??ng ban: Sale
//				Th??ng tin account th??? 2 l??:
//				Email: NguyenVanB@gmail.com
//				Full name: Nguy???n V??n B
//				Ph??ng ban: Marketting
		for (i = 0; i < accounts.length; i++) {
			System.out.println("thong tin account thu " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phong ban: " + accounts[i].department.departmentName);

			System.out.println("\n");
		}
//			Question 11:
//				In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name theo ?????nh d???ng sau:
//				Th??ng tin department th??? 1 l??:
//				Id: 1
//				Name: Sale
//				Th??ng tin department th??? 2 l??:
//				Id: 2
//				Name: Marketing

		for (i = 0; i < departments.length; i++) {
			System.out.println("Th??ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
		}
//			Question 12:
//				Ch??? in ra th??ng tin 2 department ?????u ti??n theo ?????nh d???ng nh?? Question 10
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
			System.out.println("Th??ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
		}
//			Question 13:
//				In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2
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
//			In ra th??ng tin t???t c??? c??c account c?? id < 4
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
//			In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20
		for (i = 0; i <= 20; i++) {
			if (i % 2 == 0) {

				System.out.println(i);
			}
		}
		// WHILE
//		Question 16:
//			L??m l???i c??c Question ??? ph???n FOR b???ng c??ch s??? d???ng WHILE k???t h???p v???i
//			l???nh break, continue
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
		// c??u 11
		i = 0;
		while (i < departments.length) {

			System.out.println("Th??ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
			i++;
			System.out.println("\n");
		}
		// c??u 12
		i = 0;
		while (i < 2) {
			System.out.println("Th??ng tin departmnet thu " + (i + 1) + " la :");
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
//		L??m l???i c??c Question ??? ph???n FOR b???ng c??ch s??? d???ng DO-WHILE k???t h???p v???i
//		l???nh break, continue
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
			System.out.println("Th??ng tin departmnet thu " + (i + 1) + " la :");
			System.out.println("Id:  " + departments[i].departmentId);
			System.out.println("Name:  " + departments[i].departmentName);
			i++;
			System.out.println("\n");
		} while (i < departments.length);
		// cau 12
		i = 0;
		do {
			System.out.println("Th??ng tin departmnet thu " + (i + 1) + " la :");
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
//			Khai b??o 1 s??? nguy??n = 5 v?? s??? d???ng l???nh System out printf ????? in ra s???
//			nguy??n ????

		int x = 5;
		System.out.println(x);
//		Question 2:
//			Khai b??o 1 s??? nguy??n = 100 000 000 v?? s??? d???ng l???nh System out printf ????? in
//			ra s??? nguy??n ???? th??nh ?????nh d???ng nh?? sau: 100,000,000
		long k = 100000000;
		System.out.printf(Locale.US, "%,d", k);
		System.out.println("\n");
		// lam lai
		long h = 100000000;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		System.out.printf(formatter.format(h));
//		Question 3:
//			Khai b??o 1 s??? th???c = 5,567098 v?? s??? d???ng l???nh System out printf ????? in ra s???
//			th???c ???? ch??? bao g???m 4 s??? ?????ng sau
		System.out.println("\n");
		float sothuc = 5.567098f;
		System.out.printf("%.4f %n", sothuc);

//		Question 4:
//			Khai b??o H??? v?? t??n c???a 1 h???c sinh v?? in ra h??? v?? t??n h???c sinh ???? theo ?????nh
//			d???ng nh?? sau:
//			H??? v?? t??n: "Nguy???n V??n A" th?? s??? in ra tr??n console nh?? sau:
//			T??n t??i l?? "Nguy???n V??n A" v?? t??i ??ang ?????c th??n.

		String hoTen = "Nguy???n V??n A";
		System.out.printf("T??n t??i l?? %s v?? t??i ??ang ?????c th??n", hoTen);
		System.out.println("\n");
//		Question 5:
//			L???y th???i gian b??y gi??? v?? in ra theo ?????nh d???ng sau:
//			24/04/2020 11h:16p:20s

		Date date = new Date();
		System.out.printf("%1$td/ %1$tm/ %1$ty  %tHh:%tMp:%tS%ns", date, date, date, date);
		System.out.println();
//		Question 6:
//			In ra th??ng tin account (nh?? Question 8 ph???n FOREACH) theo ?????nh d???ng
//			table (gi???ng trong Database)
		System.out.printf("%-40s %-50s %s \n", "id", "email", "fullname");
		System.out.printf("%-40s %-50s %s \n", account.accountId, account.email, account.fullName);
		System.out.printf("%-40s %-50s %s \n", account1.accountId, account1.email, account1.fullName);
		System.out.printf("%-40s %-50s %s \n", account2.accountId, account2.email, account2.fullName);
//		Exercise 3 (Optional): Date Format
//		Question 1:
//		In ra th??ng tin Exam th??? 1 v?? property create date s??? ???????c format theo ?????nh
//		d???ng vietnamese
		System.out.println(exam.createDate);

//		Question 2:
//		In ra th??ng tin: Exam ???? t???o ng??y n??o theo ?????nh d???ng
//		N??m ??? th??ng ??? ng??y ??? gi??? ??? ph??t ??? gi??y
		System.out.println(exam.createDate); // vi dinh dang la loacaldatime s???n r???i
//		Question 3:
//		Ch??? in ra n??m c???a create date property trong Question 2
//

//		48
//
//		Question 4:
//		Ch??? in ra th??ng v?? n??m c???a create date property trong Question 2
//		Question 5:
//		Ch??? in ra "MM-DD" c???a create date trong Question 2

//		Exercise 4 (Optional): Random Number
//		Question 1:
//		In ng???u nhi??n ra 1 s??? nguy??n
//		Question 2:
//		In ng???u nhi??n ra 1 s??? th???c
//		Question 3:
//		Khai b??o 1 array bao g???m c??c t??n c???a c??c b???n trong l???p, sau ???? in ng???u nhi??n
//		ra t??n c???a 1 b???n
//		Question 4:
//		L???y ng???u nhi??n 1 ng??y trong kho???ng th???i gian 24-07-1995 t???i ng??y 20-12-
//		1995
//		Question 5:
//		L???y ng???u nhi??n 1 ng??y trong kho???ng th???i gian 1 n??m tr??? l???i ????y
//		Question 6:
//		L???y ng???u nhi??n 1 ng??y trong qu?? kh???
//		Question 7:
//		L???y ng???u nhi??n 1 s??? c?? 3 ch??? s???
//		Exercise 5: Input from console
//		Question 1:
//		Vi???t l???nh cho ph??p ng?????i d??ng nh???p 3 s??? nguy??n v??o ch????ng tr??nh
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
//		Vi???t l???nh cho ph??p ng?????i d??ng nh???p 2 s??? th???c v??o ch????ng tr??nh

		System.out.println("Nhap vao  so thuc thu 1: ");
		float soThuc1 = sc.nextFloat();

		System.out.println("Nhap vao  so thu thu 2: ");
		float soThuc2 = sc.nextFloat();
		System.out.printf("2 so vua nhap la %f, %f", soThuc1, soThuc2);

		System.out.println("\n");

//		Question 3:
//		Vi???t l???nh cho ph??p ng?????i d??ng nh???p h??? v?? t??n
		System.out.println("Nhap Ho  cua ban:");
		String ho = sc.next();

		System.out.println("\n");
		System.out.println("Nhap Ten  cua ban:");
		String ten = sc.next();

		System.out.printf("Ho ten cua ban la:%s  %s", ho, ten);
		System.out.println("\n");
//		Question 4:
//		Vi???t l???nh cho ph??p ng?????i d??ng nh???p v??o ng??y sinh nh???t c???a h???
		System.out.println("nhap vao ngay sinh cua ban:");
		String date1 = sc.next();
		// string ---> date
		String dinhdang = "DD-MM-YYYY";
		SimpleDateFormat format = new SimpleDateFormat(dinhdang);
		Date date2 = format.parse(date1);
		System.out.printf("Ban vua nhap vao ngay sinh nhat la: " + date2);
		sc.close();
//		Question 5:
//		Vi???t l???nh cho ph??p ng?????i d??ng t???o account (vi???t th??nh method)
//		?????i v???i property Position, Ng?????i d??ng nh???p v??o 1 2 3 4 5 v?? v??o
//		ch????ng tr??nh s??? chuy???n th??nh Position.Dev, Position.Test,
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
	}

//
//		Question 6:
//		Vi???t l???nh cho ph??p ng?????i d??ng t???o department (vi???t th??nh method)
	public static void thongTinDepartment() {

		Department department = new Department();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap thogn tin department id:");
		int so = scanner.nextInt();
		System.out.println("Moi ban nhap thogn tin department name:");
		String name = scanner.nextLine();
		department.departmentId = (byte) so;
		department.departmentName = name;
	}

//		Question 7:
//		Nh???p s??? ch???n t??? console
	public static void nhapsochan() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap mot so ");
		int so = scanner.nextInt();
		if (so % 2 == 0) {
			System.out.println("ban da nhap dung");

		} else {
			System.out.println("xin hay nhap vao so chan");
		}
	}

//		Question 8:
//		Vi???t ch????ng tr??nh th???c hi???n theo flow sau:
//		B?????c 1:
//		Ch????ng tr??nh in ra text "m???i b???n nh???p v??o ch???c n??ng mu???n s???
//		d???ng"
//		B?????c 2:
//		N???u ng?????i d??ng nh???p v??o 1 th?? s??? th???c hi???n t???o account
//		N???u ng?????i d??ng nh???p v??o 2 th?? s??? th???c hi???n ch???c n??ng t???o
//		department
//		N???u ng?????i d??ng nh???p v??o s??? kh??c th?? in ra text "M???i b???n nh???p
//		l???i" v?? quay tr??? l???i b?????c 1
//
	public static void nhap() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap chuc nang muon su dung ");
		int so = scanner.nextInt();
		switch (so) {
		case 1:
			Account account = new Account();
			account.accountId = 8;
			account.email = "duyan01@gmail.com";
			account.userName = "Agnh";
			account.fullName = "NguyenAnh";
			account.department = null;
			account.position = null;
			account.createDate = LocalDateTime.of(2020, 11, 26, 13, 55, 36, 123);
			break;
		case 2:
			Department department = new Department();
			department.departmentId = 3;
			department.departmentName = "van phong";
			break;
		default:
			System.out.println("ban hya chon 1 hoac 2 xin hay nhap lai");
			break;
		}
	}
//	Vi???t method cho ph??p ng?????i d??ng th??m account v??o group theo flow sau:
//	B?????c 1:
//	In ra t??n c??c usernames c???a user cho ng?????i d??ng xem
//	B?????c 2:
//	Y??u c???u ng?????i d??ng nh???p v??o username c???a account
//	B?????c 3:
//	In ra t??n c??c group cho ng?????i d??ng xem
//	B?????c 4:
//	Y??u c???u ng?????i d??ng nh???p v??o t??n c???a group
//	B?????c 5:
//	D???a v??o username v?? t??n c???a group ng?????i d??ng v???a ch???n, h??y
//	th??m account v??o group ???? .
	public static void bai9 () {
		Scanner user = new Scanner(System.in);
		String usernames = user.nextLine();
		System.out.println("danh sach user: " + usernames);
		System.out.println("hay nhap user name muon chon : ");
		String x = user.nextLine();
		String group =  user.nextLine();
		System.out.println("danh sach group l??: "+ group);
		System.out.println("nhap ten group: ");
		
		
	
	}
//	Question 10: Ti???p t???c Question 8 v?? Question 9
//	B??? sung th??m v??o b?????c 2 c???a Question 8 nh?? sau:
//	N???u ng?????i d??ng nh???p v??o 3 th?? s??? th???c hi???n ch???c n??ng th??m group v??o
//	account
//	B??? sung th??m B?????c 3 c???a Question 8 nh?? sau:
//	Sau khi ng?????i d??ng th???c hi???n xong ch???c n??ng ??? b?????c 2 th?? in ra d??ng
//	text ????? h???i ng?????i d??ng "B???n c?? mu???n th???c hi???n ch???c n??ng kh??c
//	kh??ng?". N???u ng?????i d??ng ch???n "C??" th?? quay l???i b?????c 1, n???u ng?????i
//	d??ng ch???n "Kh??ng" th?? 
	public static void 	bai10 () {
			Scanner Scanner = new Scanner(System.in);
			
			System.out.print("m???i b???n nh???p v??o ch???c n??ng mu???n s??? d???ng : ");
			int z = Scanner.nextInt(4);
			switch (z) {
			case 1:{
				System.out.println("Nhap vao Account ID:");
				int accountid = Scanner.nextInt();
				System.out.println("Nhap vao Department ID:");
				int department = Scanner.nextInt();
				System.out.println("Nh???p v??o email c???a b???n : ");
				String email = Scanner.nextLine();
				System.out.println("Nh???p v??o usernames c???a b???n : ");
				String usernames = Scanner.nextLine();
				System.out.print("Nh???p v??o s??? positionid :");
				int i = Scanner.nextInt(6);
				switch (i) {
				case 1:
					System.out.print("position.Dev");
					break;
				case 2:
					System.out.print("position.Test"); 
					break;
				case 3:
					System.out.print("position.ScrumMaster");
					break;
				case 4:
					System.out.print("position.PM");
					break;
				default:
					System.out.print("position.SA");
				}
			}
			break;
			case 2: {
				Scanner scanner = new Scanner(System.in);
				System.out.println("H??y nh???p t??n department m???i :");
				String department = scanner.nextLine();
				}
				break;
			case 3:{
				
			}
				
			default:
				System.out.println("nhap lai : ");
				break;
		
			}
	}
	
//	Exercise 6 (Optional): Method
//	Question 1:
//	T???o method ????? in ra c??c s??? ch???n nguy??n d????ng nh??? h??n 10

//	Question 3:
//	T???o method ????? in ra c??c s??? nguy??n d????ng nh??? h??n 10
	
		
			public static void Question1 () {
				for (int i = 0; i < 10; i++) {
					if (i == 10) {
						continue;
					} else if (i % 2 == 0) {
						System.out.println(i);
					}
				}
			}
			public static void Question3 () {
				for (int j = 0; j < 10; j++) {
					System.out.println(j);
				}
				
			}

}

