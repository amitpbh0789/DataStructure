package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/rotate-string/
 * 
 * We are given two strings, A and B.
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost 
 * position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A.
 * Return True if and only if A can become B after some number of shifts on A.
 * 
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true

 * @author amit
 *
 */
public class RotateString {

	public static void main(String[] args) {
		
		String A = "abcde";
		String B = "abced";
		System.out.println(rotateString(A, B));
	}
	private static boolean rotateString(String A, String B) {
     
		
		if(A.isEmpty() && B.isEmpty())
			return true;
		
		char[] chars = A.toCharArray();
		
		for(int i=0; i<chars.length; i++) {
			swapElements(chars);
			A = String.copyValueOf(chars);
			if(A.equals(B))
				return true;
		}
		return false;
    }
	
	private static void swapElements(char[] chars) {
		
		char first = chars[0];
		for(int i=chars.length-1; i>=0; i--) {
			
			char temp = chars[i];
			chars[i] = first;
			first = temp;
		}
	}
}
