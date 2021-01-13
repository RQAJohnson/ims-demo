package com.qa.ims.utils;

import java.util.Scanner;

public class Utils {
	
	private Utils () {
		
	}

	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	public static Float getinput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextFloat();
}
	public static Integer getinpuT() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
