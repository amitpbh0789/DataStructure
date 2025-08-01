package com.test.leetcode.medium.locked;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/
 
 Given a string s, return the number of distinct substrings of s.
 A substring of a string is obtained by deleting any number of characters (possibly zero) 
 from the front of the string and any number (possibly zero) from the back of the string.

Solution: 
For each character, iterate through string and find subarray
Add into Set to avoid any duplicate
return the size of the set.

Input: s = "aabbaba", Output: 21
Explanation: The set of distinct strings is 
["a","b","aa","bb","ab","ba","aab","abb","bab","bba","aba","aabb","abba","bbab","baba","aabba","abbab","bbaba","aabbab","abbaba","aabbaba"]

Time: O(N^2)
Space: O(N)

 */

public class NumberOfDistinctSubstringsInAString {

	public static void main(String[] args) {
		NumberOfDistinctSubstringsInAString obj = new NumberOfDistinctSubstringsInAString();
		String str = "aabbaba";
		obj.countDistinct(str);
	}

	public int countDistinct(String s) {

		Set<String> set = new HashSet<>();
		for(int i=0; i<s.length(); i++){
			for(int j=0; j<=i; j++){
				String str = s.substring(j, i+1);
				set.add(str);
			}
		}
		return set.size();
	}
}
