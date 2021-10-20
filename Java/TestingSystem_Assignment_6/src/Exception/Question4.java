package Exception;

public class Question4 {
//	Tạo 1 array departments gồm 3 phần tử
//	Sau đó viết 1 method getIndex(int index) để lấy thông tin phần tử thứ
//	index trong array departments. Nếu index vượt quá length lấy ra thì sẽ
//	in ra text "Cannot find department."

	public static void main(String[] args) {
		
		getIndex(4);
	}
	public static void getIndex(int index ) {
		
		Department[] departments=new Department[5];
		departments[0]=new Department(1,"anh1");
		departments[1]=new Department(2,"anh2");
		departments[2]=new Department(3,"anh3");
		departments[3]=new Department(4,"anh4");
		departments[4]=new Department(5,"anh5");
		
		try {
			
				System.out.println(departments[index]);
				
				
			
		} catch (Exception e) {
			System.out.println("Cannot find department.");
		}
		
		
		
		
	}

}
