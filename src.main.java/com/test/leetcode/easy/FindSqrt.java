package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/sqrtx/
 * 
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer 
 * part of the result is returned.
 * Input: 4
 * Output: 2
 * @author amit
 *
 */
public class FindSqrt {

	public static void main(String[] args) {
		System.out.println(findSqrt(8));
	}
	private static int findSqrt(int number) {
		if(number == 0 || number == 1)
            return number;
		
		int start = 1;
		int end = number;
		while(start<=end) {
			int mid = (start+end)/2;
			if(mid*mid==number) return mid;
			else if(mid*mid>number) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
				
		}
		return start-1;
	}
}

