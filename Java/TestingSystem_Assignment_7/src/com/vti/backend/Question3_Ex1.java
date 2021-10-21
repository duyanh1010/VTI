package com.vti.backend;

import java.util.Scanner;

public class Question3_Ex1 {
	private static  Scanner scanner;

	public static void main(String[] args) {
		

	}
	public static void max(int a, int b) {
		if (a > b) {
			System.out.println("Gia tri lon nhat la: " + a);
		} else
			System.out.println("Gia tri lon nhat la: " + b);
	}
	public static void min(int a, int b) {
		if (a < b) {
			System.out.println("Gia tri nho nhat la: " + a);
		} else
			System.out.println("Gia tri nho nhat la: " + b);
	}

	public static void sum(int a, int b) {
		int result = a + b;
		System.out.println("Tong hai so la : " + result);
	}

}
