package com.test.leetcode.easy;

/**
 * Similar to https://leetcode.com/problems/to-lower-case/
 *
 */
public class ToUpperCase {

	public static void main(String[] args) {
		
		System.out.println(toUpperCase("abcDbg"));
	}
	private static String toUpperCase(String str) {
		
		char[] chars = str.toCharArray();
		for(int i=0; i<chars.length; i++) {
			
			if(chars[i]>= 'a'-0  && chars[i]<='z'-0) {
				
				chars[i] = (char)(chars[i]-32);
			}
		}
		return String.copyValueOf(chars);
	}
}
