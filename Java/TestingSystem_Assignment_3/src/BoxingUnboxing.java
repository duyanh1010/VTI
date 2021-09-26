
public class BoxingUnboxing {

	public static void main(String[] args) {
		bai1();
		System.out.println("\n");
		bai2();
		System.out.println("\n");
		bai3();
		
	}
//	Question 1:
//		Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//		Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
//		float có 2 số sau dấu thập phân)
	public static void bai1() {
		Integer luong=5000;
		float cvluong=(float)luong;
		
		System.out.printf("%5.2f",cvluong);
		
		
	}
//	Question 2:
//		Khai báo 1 String có value = "1234567"
//		Hãy convert String đó ra số int
	public static void bai2() {
		String str="1234567";
		int str1=Integer.parseInt(str);
		System.out.println("chuoi la:"+str1);
	}
//	Question 3:
//		Khởi tạo 1 số Integer có value là chữ "1234567"
//		Sau đó convert số trên thành datatype int
	public static void bai3() {
		Integer s=1234567;
		int s1=s.intValue();
		System.out.println(s1);
	}
}
