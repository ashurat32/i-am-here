package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utility {
	public static String stringUtil() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String strInput = input.readLine();
		return strInput;
	}
	
	public static double doubleUtil() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		double dbInput = Double.parseDouble(input.readLine());
		return dbInput;
	}
	
	public static int integerUtil() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int intInput = Integer.parseInt(input.readLine());
		return intInput;
	}
}
