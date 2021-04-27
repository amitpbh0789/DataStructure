package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * https://www.youtube.com/watch?v=DK5OKKbF6GI
 * Check mid of Palindrome for each index 
 * @author amit
 *
 */
public class LongestPalindromicSubstringOptimized {

	int resultStart;
    int resultLength;
    
	public static void main(String[] args) {
		LongestPalindromicSubstringOptimized obj = new LongestPalindromicSubstringOptimized();
		System.out.println(obj.longestPalindrome("cbbnokplplhud"));
	}
	
	public String longestPalindrome(String s) {
		
		int length = s.length();
		
		if(length<2)
			return s;
		
		for(int start=0; start<length-1; start++) {
			checkPalindrome(s, start, start);
			checkPalindrome(s, start, start+1);
		}
		
		return s.substring(resultStart, resultStart+resultLength);
		
	}

    private void checkPalindrome(String str, int begin, int end) {
    	
    	while(begin>=0 && end<str.length() && str.charAt(begin) == str.charAt(end)) {
    		begin--;
    		end++;
    	}
    	
    	if(resultLength<end-begin-1) {
    		resultLength = end-begin-1;
    		resultStart = begin+1;
    	}
    	
    }
}
