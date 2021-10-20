package Exception;



public class Question {

	public static void main(String[] args) {
		
		float result=divide(7,0);
		System.out.println(result);
		
	}
	public static float  divide(int a,int b) {
		return a/b;
		
	}
	// cua 1 va 2 
	public static void Question1() {
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("cannot divide 0");
		} finally {
			System.out.println("divide completed!");// co the viet xuong bo finally di
		}
	}
	
	
}
