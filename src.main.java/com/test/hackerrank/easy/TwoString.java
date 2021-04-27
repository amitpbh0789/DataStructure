package com.test.hackerrank.easy;

import java.util.Arrays;

public class TwoString {

	public static void main(String[] args) {

		String s1 = "hello";
		String s2 = "world";
		
		System.out.println(twoStrings(s1, s2));
	}

	static String twoStrings(String s1, String s2) {
        boolean[] arr = new boolean[26];
        Arrays.fill(arr, false);
        char[] charArr = s1.toCharArray();
        for(int i=0; i<charArr.length; i++){
            arr[charArr[i]-'a'] = true;
        }

        for(int i=0; i<s2.length(); i++){
            if(arr[s2.charAt(i)-'a']){
                return "Yes";
            }
        }
        return "No";
    }
}
