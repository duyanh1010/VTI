package Exception;

import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		
		
		System.out.println(inputAge());

	}

	public static int  inputAge()  {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("moi ban nhap vao 1 so tuoi :");
		int sos=0;
	
		while(true) {
		try {
			
			String so=sc.nextLine();
			 sos=Integer.parseInt(so);
			
			 return Integer.parseInt(sc.next().trim());
		
		}
		 catch (Exception e) {
			System.out.println("wrong inputing! Please input an age as int, input again");
		}
		finally {
			sc.close();
		}
		sc.close();
		}
		
		
		
		
	}
}
