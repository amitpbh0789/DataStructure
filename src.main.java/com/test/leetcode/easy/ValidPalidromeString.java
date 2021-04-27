package com.test.leetcode.easy;

/**
 * Write a program to check if a sentence is palindrome or not.
 * You can ignore white spaces and other characters to consider sentence as a palindrome.
 * @author amit
 *
 */
public class ValidPalidromeString {

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
//		Solution 1
		System.out.println(isValidPalidrome2(str));
		
//		Solution 2
		char[] strArr = str.toLowerCase().trim().toCharArray();
		int start = 0;
		int end = strArr.length-1;
		
		System.out.println(isValidPalidrome(strArr, start, end));
		
	}
	
	private static boolean isValidPalidrome(char[] strArray, int start, int end) {
		
		boolean isPalidrome = true;
		
		while(start<end) {
			
			if(strArray[start]<'a' ||  strArray[start]>'z') {
				start++;
			}
			
			else if(strArray[end]<'a' ||  strArray[end]>'z') {
				end--;
			}else {
				if(strArray[start] != strArray[end]) {
					isPalidrome = false;
					return isPalidrome;
				}
				start++;
				end--;
			}
		}
		return isPalidrome;
	}
	
	private static boolean isValidPalidrome2(String s) {

		s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
		char[] arr = s.toCharArray();
		int i=0;
		int j = arr.length-1;
		while(i<j) {
			if(arr[i] == arr[j]) {
				i++;
				j--;
			}else {
				return false;
			}
		}
		return true;
    
	}
}
