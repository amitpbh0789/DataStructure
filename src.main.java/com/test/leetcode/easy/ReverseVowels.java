package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Input: "hello"
 * Output: "holle"
 * 
 * @author amit
 *
 */
public class ReverseVowels {

	public static void main(String[] args) {
		
		System.out.println(reverseVowel("lleetcode"));
	}
	private static boolean isVowel(char c) {
		
		return (c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
	}
	private static String reverseVowel(String str) {
		
		int startIndex = 0;
		int endIndex = str.length()-1;
		char[] chars = str.toCharArray();
		
		while(startIndex<endIndex) {
			
			if(isVowel(chars[startIndex]) && isVowel(chars[endIndex])) {
				char temp = chars[startIndex];
				chars[startIndex] = chars[endIndex];
				chars[endIndex] = temp;
				startIndex++;
				endIndex--;
			}
			
			if(!isVowel(chars[startIndex]))
				startIndex++;
			if(!isVowel(chars[endIndex]))
				endIndex--;
			
//			char temp = chars[startIndex];
//			chars[startIndex] = chars[endIndex];
//			chars[endIndex] = temp;
//			
//			startIndex++;
//			endIndex--;
		}
		return String.copyValueOf(chars);
	}
}
