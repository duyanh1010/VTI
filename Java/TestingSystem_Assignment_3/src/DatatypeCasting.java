import java.util.Random;
import java.util.Scanner;

public class DatatypeCasting {

	public static void main(java.lang.String[] args) {
		bai1();
		bai2();
		bai3();
		bai3b();
		bai4();
	}

//	Exercise 1 (Optional): Datatype Casting
//	Question 1:
//	Khai bÃ¡o 2 sá»‘ lÆ°Æ¡ng cÃ³ kiá»ƒu dá»¯ liá»‡u lÃ  float.
//	Khá»Ÿi táº¡o LÆ°Æ¡ng cá»§a Account 1 lÃ  5240.5 $
//	Khá»Ÿi táº¡o LÆ°Æ¡ng cá»§a Account 2 lÃ  10970.055$
//	Khai bÃ¡o 1 sá»‘ int Ä‘á»ƒ lÃ m trÃ²n LÆ°Æ¡ng cá»§a Account 1 vÃ  in sá»‘ int Ä‘Ã³ ra
//	Khai bÃ¡o 1 sá»‘ int Ä‘á»ƒ lÃ m trÃ²n LÆ°Æ¡ng cá»§a Account 2 vÃ  in sá»‘ int Ä‘Ã³ ra
	public static void bai1() {
		float luong1 = 5240.5f, luong2 = 10970.055f;
		int luongAccount1 = (int) luong1;
		int luongAccount2 = (int) luong2;
		System.out.println("luong nhan vien 1 la :" + luongAccount1);
		System.out.println("luong nhan vien 2 la :" + luongAccount2);

	}
//	Question 2:
//		Láº¥y ngáº«u nhiÃªn 1 sá»‘ cÃ³ 5 chá»¯ sá»‘ (nhá»¯ng sá»‘ dÆ°á»›i 5 chá»¯ sá»‘ thÃ¬ sáº½ thÃªm
//		cÃ³ sá»‘ 0 á»Ÿ Ä‘áº§u cho Ä‘á»§ 5 chá»¯ sá»‘)

	public static void bai2() {
		Random random = new Random();
		int x = random.nextInt(100000);
		java.lang.String so5chuso = x + "";
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
//		Láº¥y 2 sá»‘ cuá»‘i cá»§a sá»‘ á»Ÿ Question 2 vÃ  in ra.
//		Gá»£i Ã½:
//		CÃ¡ch 1: convert sá»‘ cÃ³ 5 chá»¯ sá»‘ ra String, sau Ä‘Ã³ láº¥y 2 sá»‘ cuá»‘i
	public static void bai3() {
		Random random = new Random();
		int x = random.nextInt(100000);
		java.lang.String so5chuso = x + "";
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
		
		java.lang.String haisocuoi=so5chuso.substring(so5chuso.length() - (so5chuso.length()-3));
		System.out.println(haisocuoi);
	}

//		CÃ¡ch 2: chia láº¥y dÆ° sá»‘ Ä‘Ã³ cho 100
	public static void bai3b() {
		Random random = new Random();
		int x = random.nextInt(100000);
		java.lang.String so5chuso = x + "";
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
//		Viáº¿t 1 method nháº­p vÃ o 2 sá»‘ nguyÃªn a vÃ  b vÃ  tráº£ vá»� thÆ°Æ¡ng cá»§a chÃºng
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
