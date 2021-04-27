package com.test.leetcode.easy;

public class ReverseString {

	public static void main(String[] args) {
		
		String str = "yes";
		char[] strArray = str.toCharArray();
		reverseString(strArray, 0, strArray.length-1);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<strArray.length; i++) {
			sb.append(strArray[i]);
		}
		System.out.println(sb.toString());
	}
	
	private static void reverseString(char[] str, int start, int end) {
		
		if(start>=end)
			return;
		
		char temp = str[start];
		str[start] = str[end];
		str[end] = temp;
		
		reverseString(str, start+1, end-1);
	}
}
