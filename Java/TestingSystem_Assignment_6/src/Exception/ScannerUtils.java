package Exception;
import java.util.Scanner;
public class ScannerUtils {

	private static Scanner scanner = new Scanner(System.in);

	public static int inputPositiveInt(String errorMessage) {
		while (true) {
			int id = ScannerUtils.inputInt(errorMessage);
			if (id < 0) {
				System.err.println(errorMessage);
			} else {
				return id;
			}
		}
	}
	public static float inputfloat(String errorMessage) {
		while (true) {
			int id = ScannerUtils.inputInt(errorMessage);
			if (id < 0) {
				System.err.println(errorMessage);
			} else {
				return id;
			}
		}
	}
	
	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				String input = scanner.nextLine();
				input = input.trim();
				int output = Integer.parseInt(input);
				return output;
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	
	public static float inputPositiveMoney(String erroMessage2) {
		while (true) {
			float fl = ScannerUtils.inputMoney(erroMessage2);
			if (fl < 0) {
				System.err.print(erroMessage2);
			} else {
				return fl;
			}
		}
	}


	public static float inputMoney(String errorMessage) {
		while (true) {
			try {
				String inputMoney = scanner.nextLine();
				inputMoney = inputMoney.trim();
				float outputMoney = Float.parseFloat(inputMoney);
				return outputMoney;
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	
	public static String inputString(String errorMessage) {
		String inputString = scanner.nextLine();
		inputString = inputString.trim();
		inputString = inputString.replaceAll("\\s+", " ");

		return inputString;
	}

	public static String inputName() {
		System.out.print("Moi ban nhap vao ten ho day du ");
		String name = ScannerUtils.inputString("Ban phai nhap vao ten!");

		String[] words = name.split(" ");
		name = "";
		for (String word : words) {

			String firstCharacter = word.substring(0, 1).toUpperCase();
			String leftCharacter = word.substring(1);
			word = firstCharacter + leftCharacter;
			name += word + " ";
		}
		return name;
	}
	public static int inputAge() {
		while (true) {
			int age = inputInt("Wrong inputing! hãy nhập vào số, vui lòng nhập lại .");

			if (age <= 0) {
				System.err.println("Wrong inputing! tuổi phải lớn hơn 0, vui long nhập lại .");

			} else {
				return age;
			}
		}
	}
	
	public static String email(String errorMessage) {
		while (true) {
			try {
				String email = scanner.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
				if (!email.contains("@")) {
					System.err.println(errorMessage);
				} else {
					return email;
				}
			} catch (Exception e) {
				System.out.println(errorMessage);
			}
		}
	}

	

}
