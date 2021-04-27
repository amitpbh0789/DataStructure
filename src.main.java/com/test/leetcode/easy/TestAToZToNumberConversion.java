package com.test.leetcode.easy;

public class TestAToZToNumberConversion {

	public static void main(String[] args) {
		
		int number = 'B'-'A'+1;
		System.out.println("B into number "+number);
		
		int n = 2;
		char res = (char)('A'+(n-1)%26);
		System.out.println("2 converted into "+ res);
	}
}
