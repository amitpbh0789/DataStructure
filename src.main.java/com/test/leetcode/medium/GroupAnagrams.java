package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 * 
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 * @author amit
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(strs);
		System.out.println(res.size());
	}
	private static List<List<String>> groupAnagrams(String[] strs) {
		
		Map<String, List<String>> ans = new HashMap<String, List<String>>();
		for(String s : strs) {
			char[] str = s.toCharArray();
			Arrays.sort(str);
			String key = String.valueOf(str);
			
			if(!ans.containsKey(key)) {
				ans.put(key, new ArrayList<String>());
			}
			ans.get(key).add(s);
		}
		
		return new ArrayList(ans.values());
	}
}
