package Exception;

import java.util.Scanner;

public class Question6 {

	public static void main(String[] args) {

			inputAge();

		}

		public static void inputAge()  {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("moi ban nhap vao 1 so tuoi :");
			try {
				String so=sc.nextLine();
				int sos=Integer.parseInt(so);
				
			}
			 catch (Exception e) {
				System.out.println("wrong inputing! Please input an age as int, input again");
			}
				
					
			
		}
	}