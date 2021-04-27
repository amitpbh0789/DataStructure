package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/to-lower-case/
 * 
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * Input: "Hello"
 * Output: "hello"
 * 
 * @author amit
 *
 */
public class ToLowerCase {

	public static void main(String[] args) {
		
		System.out.println(toLowerCase("LOVELY"));
	}
	private static String toLowerCase(String str) {
		
		char[] chars = str.toCharArray();
		for(int i=0;i<chars.length; i++) {
			if(chars[i]>=65 && chars[i]<=90) {
				chars[i] = (char)(chars[i] + 32);
			}
		}
		return String.copyValueOf(chars);
	}
}
