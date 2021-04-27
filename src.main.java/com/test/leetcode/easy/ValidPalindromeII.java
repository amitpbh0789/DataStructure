package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * 
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * 
 * Example 1:
 * Input: "aba"
 * Output: True
 * 
 * @author amit
 *
 */
public class ValidPalindromeII {

	public static void main(String[] args) {
		
		System.out.println(validPalindrome("deeee"));
		
	}
	private static boolean validPalindrome(String s) {
		int start = 0;
		for(int i=0; i<s.length(); i++) {
			String first = s.substring(start, i);
			String second = s.substring(i+1, s.length());
			String finalWord = first+second;
			if(checkValindrome(finalWord)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean checkValindrome(String str) {
		
		if(str.length() == 1) {
			return true;
		}
		int i=0;
		int j= str.length()-1;
		char[] chars = str.toCharArray();
		while(i<j) {
			if(!(chars[i] == chars[j])) {
				return false;
			}else {
				i++;
				j--;
			}
		}
		
		return true;
	}
}
