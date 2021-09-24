import java.time.LocalDateTime;

public class Program {
	private static final LocalDateTime LocalDateTime = null;

	public static void main(String[] args) {
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
		// bai Exercise 1
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
		
		System.out.println((account.department == null)?"Nhan vien chua co phong ban ":"Phong ban cua nhan vien nay la " + account.department.departmentName);
		System.out.println("\n");
//		Question 4:
//			Sử dụng toán tử ternary để làm yêu cầu sau:
//			Kiểm tra Position của account thứ 1
//			Nếu Position = Dev thì in ra text "Đây là Developer"
//			Nếu không phải thì in ra text "Người này không phải là Developer"
		System.out.println(account.position.positionName=="Dev"? "Đây là Developer": "Người này không phải là Developer");
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
		
		switch(account1.groups.length){
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
		default :
			
			System.out.println("Nhan vien nay la nguoi hong chuyen");
			
			
		}
//		Question 7:
//			Sử dụng switch case để làm lại Question 4
			switch(account.position.positionName){
			case "Dev":
				System.out.println("nguoi này là Dev");
				break;
				default :
					System.out.println("nguoi này khong pahi la  Dev");
					break;
			}
			System.out.println("\n");
//			FOREACH
//			Question 8:
//			In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//			họ	
			
	}

}
