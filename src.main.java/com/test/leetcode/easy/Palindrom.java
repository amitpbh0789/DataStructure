package com.test.leetcode.easy;

public class Palindrom {

	public static void main(String[] args) {
		System.out.println(isPalidrome(121));
	}
	
	public static boolean isPalidrome(int number) {
		int temp = number;
		if(number<0) {
			return false;
		}
		long result = 0;
		while(number != 0) {
			result = result *10 + number%10;
			number = number/10;
		}
		if (temp == result) {
			return true;
		}
		return false;
		
	}
}
