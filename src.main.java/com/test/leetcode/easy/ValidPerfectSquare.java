package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 * 
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 * Example 1:
 * Input: 16
 * Output: true
 * 
 * @author amit
 *
 */
public class ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(27));
	}
	private static boolean isPerfectSquare(int num) {
		int start = 1;
		int end = num/2;
		
		while(start<=end) {
			int mid = (start + end)/2;
			if(mid * mid < num)
				start = start +1;
			if(mid*mid > num)
				end = end - 1;
			if(mid*mid == num)
				return true;
		}
		
		return false;
	}
}
