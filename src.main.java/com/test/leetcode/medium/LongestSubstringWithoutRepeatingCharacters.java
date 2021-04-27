package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3.
 *  
 * @author amit
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		
		System.out.println(lengthOfLongestSubstring("abba"));
	}
	private static int lengthOfLongestSubstring(String s) {
		
		if(s.length() == 0)
			return 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int start=0;
		
		for(int i=0; i<s.length(); ++i) {
			
			if(map.containsKey(s.charAt(i))) {
				start = Math.max(start, map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i-start+1);
		}
		return max;
	}
}
