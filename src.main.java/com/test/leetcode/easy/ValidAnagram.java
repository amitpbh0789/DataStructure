package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/valid-anagram/
 * 
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * @Note: You may assume the string contains only lowercase alphabets.
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * @author amit
 *
 */
public class ValidAnagram {

	public static void main(String[] args) {
		
		String str1 = "anagram";
		String str2 = "nagaran";
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		System.out.println(validAnagram(chars1, chars2));
	}
	
	private static boolean validAnagram(char[] chars1, char[] chars2) {
		
		int[] count = new int[26];
		if(chars1.length != chars1.length) {
			return false;
		}
		
		for(int i=0; i<chars1.length; i++) {
			count[chars1[i]- 'a']++;
			count[chars2[i] - 'a']--;
		}
		
		for(int i = 0; i<count.length; i++) {
			if(count[i]>0)
				return false;
		}
		return true;
		
	}
}
