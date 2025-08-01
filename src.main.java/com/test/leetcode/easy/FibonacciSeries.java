package com.test.leetcode.easy;

public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println(findFebonacciNumber(4));
		System.out.println(fibonacciDP(4));
	}
	
	private static int findFebonacciNumber(int number) {
		
		if(number<=1) {
			return number;
		}
		return findFebonacciNumber(number-1) + findFebonacciNumber(number-2);
	}
	
	private static int fibonacciDP(int n) {
		int[] ans = new int[n+2];
		ans[0] = 0;
		ans[1] = 1;
		
		for(int i=2; i<=n; i++) {
			ans[i] = ans[i-1] + ans[i-2];
		}
		
		return ans[n];
	}
}
