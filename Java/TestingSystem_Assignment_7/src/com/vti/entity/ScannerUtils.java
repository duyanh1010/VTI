package com.vti.entity;

import java.util.Scanner;

public class ScannerUtils {

	private static Scanner scanner = new Scanner(System.in);

	public static int inputId() {
		while (true) {
			int id = inputInt("bạn phải nhập vào số");
			if (id > 0) {
				return id;
			}
			System.out.println("bạn phải nhập vào số >0, vui lòng nhập lại");
		}
	}

	public static String inputName() {
		return inputString();
	}

	public static int inputInt() {
		return inputInt("hãy nhập vào số , vui lòng nhập lại");
	}

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputString() {
		while (true) {
			String input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else if (input.length() < 6) {
				System.err.println("Ban nhap vao chuoi lon hon 6 ki tu  ");
			}
		}
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

	public static String Password(String errorMessage) throws Exception {
		while (true) {
			String password = ScannerUtils.inputString();
			
				
				if (password == null || password.length() < 6 || password.length() > 12) {
					System.err.println(errorMessage);
				} else {
				
				
			
			boolean Strpass = false; 
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) {
					Strpass = true;
					break;
				}
			}
			if (Strpass == true) {
				return password;
			} else {
				System.err.println("ban hay nhap 1 ki tu viet hoa ");
			}}
		}
	}
	

}
