package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * @author amit
 *
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		
		int numberOfSteps = 4;
		System.out.println("Number of ways = "+ countStepsToClimbStairs(numberOfSteps)); 
	}
	
	private static int countStepsToClimbStairs(int numberOfSteps) {
		
		return fib(numberOfSteps+1);
		
	}
	
	private static int fib(int number) {
		if(number<=1)
			return number;
		return fib(number-1) + fib(number-2);
	}
}
