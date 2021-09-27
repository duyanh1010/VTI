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
//		bai6();
//		System.out.println("\n");
//		bai7();
//		System.out.println("\n");
//		bai8();
//		System.out.println("\n");
//		bai10();
//		System.out.println("\n");
//		bai11();
//		System.out.println("\n");
//		bai12();
//		System.out.println("\n");
//		bai13();
//		System.out.println("\n");
//		bai14();
//		System.out.println("\n");
//		bai15();
		bai16();
		bai17();
		

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
		java.lang.String[] words = fullName.split(" ");
		fullName = " ";

		for (java.lang.String word : words) {
			java.lang.String firstCharacter = word.substring(0, 1).toUpperCase();
			java.lang.String leftCharacter = word.substring(1);
			word = firstCharacter + leftCharacter;
			fullName += word + " ";

		}
		System.out.println("Ho va ten sau khi chuan hoa la: " + fullName);

	}

//	Question 8:
//		In ra tất cả các group có chứa chữ "Java"
	public static void bai8() {
		java.lang.String[] groupNames = { "java", "hoi yeu java", "muon hoc java", "  yeu cong nghe  " };

		for (java.lang.String groupName : groupNames) {
			if (groupName.contains("java"))
				System.out.println("Group co chua tu java la: " + groupName.trim());
		}
//		Question 9:
//			In ra tất cả các group "Java"
		for (java.lang.String groupName : groupNames) {
			if (groupName.equals("java"))
				System.out.println("Group ten java: " + groupName);
		}
	}

	private boolean contains(java.lang.String string) {
		// TODO Auto-generated method stub
		return false;
	}

	private java.lang.String trim() {
		// TODO Auto-generated method stub
		return null;
	}

//Question 10 (Optional):
//Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
//Nếu có xuất ra “OK” ngược lại “KO”.
//Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
	public static void bai10() {
		// nhap thong tin 2 chuoi
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi 1: ");
		java.lang.String str1 = scanner.nextLine();
		str1 = str1.replaceAll("\\s+", " "); // gop 2 hay nhieu khaong trnag
		str1 = str1.trim();
		System.out.println("Moi ban nhao vao chuoi 2: ");
		java.lang.String str2 = scanner.nextLine();
		str2 = str2.replaceAll("\\s+", " ");
		str2 = str2.trim(); // bo khoang trang
		java.lang.String reverses1 = "";// de hung chuoi
		// in ra chuoi dao nguoc reverses1 cua s1
		for (int i = str2.length() - 1; i >= 0; i--) {

			reverses1 += str2.charAt(i);
		}
		System.out.println(reverses1);
// so sanh khi da dao nguoc 
		System.out.println(str1.equals(reverses1));
		if (str1.equals(reverses1)) {

			System.out.println("Day la chuoi dao nguoc cua chuoi 1");
		} else {
			System.out.println("Day khong phai chuoi dao nguoc cua chuoi 1 ");
		}

	}

//	Question 11 (Optional): Count special Character
//	Tìm số lần xuất hiện ký tự "a" trong chuỗi
	public static void bai11() {
		java.lang.String chuoi;
		char kyTu = 'a';
		int count = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập vào chuỗi bất kỳ: ");
		chuoi = scanner.nextLine();

		// duyệt từ đầu đến cuối chuỗi
		for (int i = 0; i < chuoi.length(); i++) {
			// Nếu ký tự tại vị trí thứ i bằng 'a' thì tăng count lên 1
			if (chuoi.charAt(i) == kyTu) {
				count++;
			}
		}

		System.out.println("Số lần xuất hiện của ký tự " + kyTu + " trong chuỗi " + chuoi + " = " + count);
	}

	private static java.lang.String charAt(int i) {
		// TODO Auto-generated method stub
		return null;
	}

//Question 12 (Optional): Reverse String
//Đảo ngược chuỗi sử dụng vòng lặp
	public static void bai12() {
		// nhap thong tin chuoi
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi 1: ");
		java.lang.String str1 = scanner.nextLine();
		str1 = str1.replaceAll("\\s+", " "); // gop 2 hay nhieu khaong trnag
		str1 = str1.trim();

		java.lang.String reverses1 = "";// de hung chuoi
		// in ra chuoi dao nguoc reverses1 cua str1
		for (int i = str1.length() - 1; i >= 0; i--) {

			reverses1 += str1.charAt(i);
		}
		System.out.println(reverses1);
	}
//	Question 13 (Optional): String not contains digit
//	Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
//	lại true.
//	Ví dụ:
//	"abc" => true
//	"1abc", "abc1", "123", "a1bc", null => false
	public static void bai13() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi 1: ");
		java.lang.String str1 = scanner.nextLine();
		str1 = str1.replaceAll("\\s+", " "); // gop 2 hay nhieu khaong trnag
		str1 = str1.trim();
		boolean string=false;
		for (int i = 0; i < str1.length(); i++) {
			if (Character.isDigit(str1.charAt(i)) == true) {
				string = true;
				break;
			}
		}
		
			System.out.println(string);
		
	}
//	Question 14 (Optional): Replace character
//	Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
//	cho trước.
//	Ví dụ:
//	"VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
	public static void bai14() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi 1: ");
		java.lang.String str1 = scanner.nextLine();
		str1 = str1.replaceAll("\\s+", " "); // gop 2 hay nhieu khaong trnag
		str1 = str1.trim();
		System.out.println("Moi ban nhap ki tu bi thay the: ");
		char c1= scanner.nextLine().toCharArray()[0]; 
		System.out.println("Ky tu moi duoc thay the: ");
		char c2 = scanner.nextLine().toCharArray()[0];
		
		for (int i = 0; i < str1.length(); i++) {
			str1 = str1.replace(c1, c2);
		}
		
			System.out.println(str1);
		
	}
//	Question 15 (Optional): Revert string by word
//	Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng
//	thư viện.
//	Ví dụ: " I am developer " => "developer am I".
//	Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//	Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt
//	chuỗi theo dấu cách	
	
	public static void bai15() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi: ");
		java.lang.String str = scanner.nextLine();
		str = str.replaceAll("\\s+", " ");
		str=str.trim();
		// cat chuoi bang split
		java.lang.String[] words = str.split(" ");
		str = "";
		for (int i = words.length - 1; i >= 0; i--) {
			str += words[i] + " ";
		}
		System.out.println("Chuoi dao nguoc la: " + str);

	}
//	Question 16 (Optional):
//
//		4
//
//		Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
//		bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
//		hình “KO”.
	public static void bai16() {
		int so;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi: ");
		java.lang.String str = scanner.nextLine();
		System.out.println(" nhap so ky tu : ");
		so = scanner.nextInt();

		if (str.length() <= so) { 
			System.out.println(str);
		} else { 
			if (str.length() % so != 0) {
				System.out.println("KO");
			} else {
				
				System.out.println("Cac chuoi la \n: ");
				for (int i = 0; i < str.length(); i += so) {
					System.out.println(str.substring(i, i + so));
				}
			}
		}
	}
	// lam cho gon vi khaong trang no van chia 
	
	public static void bai17() {
		int so;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi: ");
		java.lang.String str = scanner.nextLine();
		System.out.println(" nhap so ky tu : ");
		so = scanner.nextInt();
		str = str.replaceAll("\\s+", " ");
		if (str.length() <= so) { 
			System.out.println(str);
		} else { 
			if (str.length() % so != 0) {
				System.out.println("KO");
			} else {
				
				System.out.println("Cac chuoi la \n: ");
				for (int i = 0; i < str.length(); i += so) {
					System.out.println(str.substring(i, i + so));
				}
			}
		}
	}
}
