import java.util.Random;
import java.util.Scanner;

public class DatatypeCasting {

	public static void main(String[] args) {
		bai1();
		bai2();
		bai3();
		bai3b();
		bai4();
	}

//	Exercise 1 (Optional): Datatype Casting
//	Question 1:
//	Khai báo 2 số lương có kiểu dữ liệu là float.
//	Khởi tạo Lương của Account 1 là 5240.5 $
//	Khởi tạo Lương của Account 2 là 10970.055$
//	Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//	Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
	public static void bai1() {
		float luong1 = 5240.5f, luong2 = 10970.055f;
		int luongAccount1 = (int) luong1;
		int luongAccount2 = (int) luong2;
		System.out.println("luong nhan vien 1 la :" + luongAccount1);
		System.out.println("luong nhan vien 2 la :" + luongAccount2);

	}
//	Question 2:
//		Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//		có số 0 ở đầu cho đủ 5 chữ số)

	public static void bai2() {
		Random random = new Random();
		int x = random.nextInt(100000);
		String so5chuso = x + "";
		switch (so5chuso.length()) {
		case 1:

			so5chuso = "0000" + so5chuso;
			break;
		case 2:

			so5chuso = "000" + so5chuso;
			break;
		case 3:

			so5chuso = "00" + so5chuso;
			break;
		case 4:

			so5chuso = "0" + so5chuso;
			break;

		default:
			break;
		}
		System.out.println(so5chuso);
	}

//	Question 3:
//		Lấy 2 số cuối của số ở Question 2 và in ra.
//		Gợi ý:
//		Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
	public static void bai3() {
		Random random = new Random();
		int x = random.nextInt(100000);
		String so5chuso = x + "";
		switch (so5chuso.length()) {
		case 1:

			so5chuso = "0000" + so5chuso;
			break;
		case 2:

			so5chuso = "000" + so5chuso;
			break;
		case 3:

			so5chuso = "00" + so5chuso;
			break;
		case 4:

			so5chuso = "0" + so5chuso;
			break;

		default:
			break;
		}
		
		String haisocuoi=so5chuso.substring(so5chuso.length() - (so5chuso.length()-3));
		System.out.println(haisocuoi);
	}

//		Cách 2: chia lấy dư số đó cho 100
	public static void bai3b() {
		Random random = new Random();
		int x = random.nextInt(100000);
		String so5chuso = x + "";
		switch (so5chuso.length()) {
		case 1:

			so5chuso = "0000" + so5chuso;
			break;
		case 2:

			so5chuso = "000" + so5chuso;
			break;
		case 3:

			so5chuso = "00" + so5chuso;
			break;
		case 4:

			so5chuso = "0" + so5chuso;
			break;

		default:
			break;
		}
		int so5=Integer.parseInt(so5chuso);
		int haisocuoi=so5%100;
		System.out.println(haisocuoi);
	}
//	Question 4:
//		Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
	public static void bai4() {
		int a,b;
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhap vao so nguyen a:");
		a=sc.nextInt();
		System.out.println("Nhap vao so nguyen b:");
		b=sc.nextInt();
		float c=(float)a/b;
		System.out.println("thuong hai so "+c);
		System.out.printf("thuong hai so %d va %d la: %f ",a,b,c);
		
		
		
	}
}
