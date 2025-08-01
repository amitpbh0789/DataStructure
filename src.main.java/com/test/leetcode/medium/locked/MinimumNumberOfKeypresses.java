package com.test.leetcode.medium.locked;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/minimum-number-of-keypresses/description/
 * 
 * You have a keypad with 9 buttons, numbered from 1 to 9, each mapped to lowercase English letters. You can choose which characters each button is matched to as long as:

All 26 lowercase English letters are mapped to. Each character is mapped to by exactly 1 button. Each button maps to at most 3 characters.
To type the first character matched to a button, you press the button once. To type the second character, you press the button twice, and so on.

Given a string s, return the minimum number of keypresses needed to type s using your keypad.

Note that the characters mapped to by each button, and the order they are mapped in cannot be changed.
 * 
 */
public class MinimumNumberOfKeypresses {

	public static void main(String[] args) {
		String str = "apple";
		System.out.println(MinimumNumberOfKeypresses.minimumKeypresses(str));
	}
	
	public static int minimumKeypresses(String s) {
		Integer[] count = new Integer[26];
		Arrays.fill(count, 0);
		
		for(char c : s.toCharArray()) {
			count[c-'a']++;
		}
		
		Arrays.sort(count, (a,b)->b-a);
		
		int result = 0;
		for(int i=0; i<26; i++) {
			if(i<9) {
				result += count[i];
			} else if(i<18) {
				result += (count[i]*2);
			} else {
				result += (count[i]*3);
			}
		}
		
		return result;
		
	}
}
