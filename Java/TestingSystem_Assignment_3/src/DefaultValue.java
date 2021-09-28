
public class DefaultValue {

	public static void main(java.lang.String[] args) {
//		Exercise 2 (Optional): Default value
//		Question 1:
//		Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
//		tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//		 Email: "Email 1"
//		 Username: "User name 1"
//		 FullName: "Full name 1"
//		 CreateDate: now
		bai11();
		
	}
	public static void bai11() {
		Account[] accounts=new Account[5];
		for(int i=0;i<5;i++) {
			
			accounts[i] = new Account();
			accounts[i].accountId=(i+1);
			accounts[i].email="Email: "+(i+1);
			accounts[i].userName="Username: "+(i+1);
			accounts[i].fullName="Full Name: "+(i+1);
			System.out.println("Id cua tai khoan " + (i + 1) + " la: " + accounts[i].accountId);
			System.out.println("Email cua tai khoan " + (i + 1) + " la: " + accounts[i].email);
			System.out.println("UserName cua tai khoan " + (i + 1) + " la: " + accounts[i].userName);
			System.out.println("FullName cua tai khoan " + (i + 1) + " la: " + accounts[i].fullName);
			System.out.println("Ngay tao:"+java.time.LocalDate.now()); 
			System.out.println("\n");
		
		}
	}

}
