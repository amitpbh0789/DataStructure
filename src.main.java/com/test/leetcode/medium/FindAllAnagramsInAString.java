package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * Sliding Window Approach
 * @author amit
 *
 */
public class FindAllAnagramsInAString {

	public static void main(String[] args) {

		FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
		String s =  "cbaebabacd";
		String p = "abc";
		List<Integer> res = obj.findAnagrams(s, p);
		res.forEach(r -> {
			System.out.println(r);
		});
		
	}

	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> res = new ArrayList<>();
		if(s == null || s.length() == 0) return res;

		//         Frequency array to store the frequency of each character in string p 
		int[] freq = new int[26];
		for(char c : p.toCharArray()){
			freq[c-'a']++;
		}

		//         Now follow sliding window apporach and find out thr anagram in string s

		int left = 0;
		int right = 0;
		int count = p.length();

		//      Right pointer will move until end of the string s
		while(right<s.length()){

			//             Check if current char exists in freqency array if yes, do following
			// then increase the right pointer, decrease the total count as one of them is found
			if(freq[s.charAt(right++)-'a']-->=1)
				count--;

			//          Once count reaches to end, mean anagram found, add the left pointer (first) index into list
			if(count == 0)
				res.add(left);

			//        Once we have cover the length of p in s, add left index char frequence backt o array, increase the index of left and increase the count by 1 so that next inex cound be visited
			if(right - left == p.length() && freq[s.charAt(left++)-'a']++>=0)
				count++;
		}
		return res;
	}
}
