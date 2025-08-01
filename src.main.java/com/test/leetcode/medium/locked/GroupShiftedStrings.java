package com.test.leetcode.medium.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.ca/all/249.html
 * 
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". 
 * We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz"
 * 
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * 
 * 
 */
public class GroupShiftedStrings {
	
	public static void main(String[] args) {
		String[] strings = new String[] {"abc","bcd","acef","xyz","az","ba","a","z"};
		List<List<String>> ans = GroupShiftedStrings.groupStrings(strings);
		System.out.println(ans);
		
	}
	
	public static List<List<String>> groupStrings(String[] strings) {
		
		Map<String, List<String>> map = new HashMap<>();
		for(String str : strings) {
			
			StringBuilder pattern = new StringBuilder();
			
			for(int i=1; i<str.length(); i++) {
				char prev = str.charAt(i-1);
				char curr = str.charAt(i);
				
				int distance = computeDistance(prev, curr);
				// Appending each distances by , to handle case [0,1,11]
				pattern.append(distance).append(",");
			}
			
			String patternStr = pattern.toString();
			if(!map.containsKey(patternStr)) {
				map.put(patternStr, new ArrayList<>());
			}
			map.get(patternStr).add(str);
		}
		
		return new ArrayList<>(map.values());
		
	}
	// Compute distance between 2 characters
	private static int computeDistance(char prev, char curr) {
		
		int val1 = prev-'a';
		int val2 = curr-'a';
		return val1<val2? val2-val1 : (26-val1) + val2; // handling "ba" case. from b to a to get the diff 
	}

}
