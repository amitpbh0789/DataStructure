package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/rotated-digits/
 * 
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X.  Each digit must be rotated - 
 * we cannot choose to leave it alone.A number is valid if each digit remains a digit after rotation.
 * 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other,
 * and the rest of the numbers do not rotate to any other number and become invalid.
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *    
 * Input: 10
 * Output: 4
 * Explanation: 
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.

 * @author amit
 *
 */
public class RotatedDigits {

	public static void main(String[] args) {
		System.out.println(getRotatedDigits(100));
	}
	private static int getRotatedDigits(int n) {
		
		int result = 0;
		
		for(int i=1; i<=n; i++) {
			int j = i;
			boolean contains2569 = false;
			boolean contains347 = false;
			while(j!=0) {
				int digit = j%10;
				
				if(digit == 2 ||digit == 5 ||digit == 6 ||digit == 9) {
					contains2569 = true;
				}
				else if(digit == 3 ||digit == 4 ||digit == 7) {
					contains347 = true;
				}
				j = j/10;
			}
			if(!contains347 && contains2569) {
				result++;
			}
		}
		return result;
	}
}
