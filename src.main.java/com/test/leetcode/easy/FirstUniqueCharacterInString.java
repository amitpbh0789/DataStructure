package com.test.leetcode.easy;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		System.out.println(findUniqueCharacter("cc"));
	}

	private static int findUniqueCharacter(String s) {
		
		if(s.isEmpty())
			return -1;
		char[] chars = s.toCharArray();
		int[] count = new int[26];
		
		for(int i=0; i<chars.length; i++) {
			count[chars[i] - 'a'] = count[chars[i] - 'a'] + 1;
		}
		
		for(int i = 0; i<chars.length; i++) {
			if(count[chars[i]-'a']==1) {
				return i;
			}
		}
		return -1;
	}
}
