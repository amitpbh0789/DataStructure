package com.test.leetcode.easy;

public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println(findFebonacciNumber(4));
	}
	
	private static int findFebonacciNumber(int number) {
		
		if(number<=1) {
			return number;
		}
		return findFebonacciNumber(number-1) + findFebonacciNumber(number-2);
	}
}
