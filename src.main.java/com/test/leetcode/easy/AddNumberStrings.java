package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/add-strings/
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * @author amit
 *
 */
public class AddNumberStrings {

	public static void main(String[] args) {
		
		System.out.println(addStrings("12", "24"));
		
	}
	private static int addStrings(String num1, String num2) {
		
		int n1 = convertStringToInteger(num1);
		int n2 = convertStringToInteger(num2);
		int sum = n1+n2;
		
		return sum;
	}
	
	private static int convertStringToInteger(String num) {
		
		int zeroAscii = (int)'0';
		int sum = 0;
		for(char c : num.toCharArray()) {
			sum = (sum*10)+((int)c - zeroAscii);
		}
		return sum;
	}
}
