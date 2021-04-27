package com.test.leetcode.medium;

/**
 * 
 * https://leetcode.com/problems/palindromic-substrings/
 * 
 * @author amit
 *
 */
public class PalindromicSubstrings {


	int res;
	public static void main(String[] args) {
		PalindromicSubstrings obj = new PalindromicSubstrings();
		System.out.println(obj.getSubStringsCount("abc"));
	}
	
	public int getSubStringsCount(String s) {
		for (int start = 0; start <= s.length()-1; start++) {
			expand(s, start, start);
			expand(s, start, start+1);
			
		}
		return res;
	}
	
	public void expand(String s, int start, int end) {
		int length = s.length();
		
		while(start>=0 && end<length && s.charAt(start) == s.charAt(end)) {
			res++;
			start--;
			end++;
		}
		
	}
	
	
}
