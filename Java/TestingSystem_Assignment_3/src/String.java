import java.util.Scanner;

public class String {

	public static void main(java.lang.String[] args) {
//		bai1();
//		System.out.println("\n");
//		bai2();
//		System.out.println("\n");
//		bai3();
//		System.out.println("\n");
//		bai4();
//		System.out.println("\n");
//		bai5();
//		System.out.println("\n");
		bai6();
		System.out.println("\n");
		bai7();
	}

//	Question 1:
//		Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//		thể cách nhau bằng nhiều khoảng trắng );
	public static void bai1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap  vao xau ki tu");
		java.lang.String chuoi = scanner.nextLine();
		chuoi = chuoi.replaceAll(" ", "");
		System.out.println("do dai xau ly tu la " + chuoi.length());

	}

//	Question 2:
//		Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
	public static void bai2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap  vao xau ki tu 1:");
		java.lang.String str1 = scanner.nextLine();
		System.out.println("Nhap  vao xau ki tu 2:");
		java.lang.String str2 = scanner.nextLine();
		java.lang.String str3 = str2 + str1;
		System.out.println(str3);

	}

//	Question 3:
//		Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
//		viết hoa chữ cái đầu thì viết hoa lên
	public static void bai3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap  vao ten:");
		java.lang.String str1 = scanner.nextLine();

		java.lang.String firstChar = str1.substring(0, 1).toUpperCase();
		java.lang.String laststr = str1.substring(1).toLowerCase();
		str1 = firstChar + laststr;
		System.out.println(str1);

	}
//	Question 4:
//		Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
//		của người dùng ra
//		VD:
//		Người dùng nhập vào "Nam", hệ thống sẽ in ra
//		"Ký tự thứ 1 là: N"
//		"Ký tự thứ 1 là: A"
//		"Ký tự thứ 1 là: M"

	public static void bai4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap  vao ten4:");
		java.lang.String str1 = scanner.nextLine();
		for (int i = 0; i < str1.length(); i++) {
			System.out.println(str1.substring(i, i + 1));
		}

	}

//	Question 5:
//		Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//		dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	public static void bai5() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap  vao ho:");
		java.lang.String str1 = scanner.nextLine();
		System.out.println("Nhap  vao ten:");
		java.lang.String str2 = scanner.nextLine();
		System.out.println("Ho ten la:" + (str1 + str2));

	}

//	Question 6:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//		sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//		VD:
//		Người dùng nhập vào "Nguyễn Văn Nam"
//		Hệ thống sẽ in ra
//		"Họ là: Nguyễn"
//		"Tên đệm là: Văn"
//		"Tên là: Nam"
	public static void bai6() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap  vao ho va ten :");
		java.lang.String str1 = scanner.nextLine();

		str1 = str1.trim();
		java.lang.String[] tmp = str1.split("\\s+");
		if (tmp.length < 3) {
			System.out.println("Ten phai co day du ho, ten dem, ten");
			return;
		}
		System.out.println("Ho viet hoa: " + tmp[0].toUpperCase());
		System.out.println("Ten dem viet thuong: " + tmp[1].toLowerCase());
		System.out.println("Ten viet hoa: " + tmp[2].toUpperCase());

	}
//	Question 7:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//		chuẩn hóa họ và tên của họ như sau:
//		a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập
//		vào
//
//		3
//
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//		chuẩn hóa thành "nguyễn văn nam"
	public static void bai7() {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ten day du: ");
		java.lang.String fullName = scanner.nextLine();
		fullName = fullName.replaceAll("\\s+", " ");
		System.out.println("Ten day du la: " + fullName.trim());
//		b) Viết hoa chữ cái mỗi từ của người dùng
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//		chuẩn hóa thành "Nguyễn Văn Nam"
		

	}


	
}
