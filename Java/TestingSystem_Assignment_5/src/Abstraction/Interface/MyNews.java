package Abstraction.Interface;

import java.util.Scanner;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;

public class MyNews {

	public static void main(String[] args) {
		News news=new News();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap 1 Insert news || 2 View list news|| 3 Average rate|| 4 Exit");
		int x = scanner.nextInt();
		switch (x) {
		case 1:
			System.out.println("moi ban nhap vao Title:");
			String title=scanner.nextLine();
			System.out.println("moi ban nhap vao PublishDate:");
			String publishDate=scanner.nextLine();
			System.out.println("moi ban nhap vao Author:");
			String author=scanner.nextLine();
			System.out.println("moi ban nhap vao Content:");
			String content=scanner.nextLine();
			
			
			break;
		case 2:
			news.Display();
			break;
		case 3:
			news.Calculate();
			news.Display();
			break;
		case 4:
			
			break;
		default:
			System.out.println("Ban nhap sai, moi ban nhap lai");
			break;
		}
	}


}
