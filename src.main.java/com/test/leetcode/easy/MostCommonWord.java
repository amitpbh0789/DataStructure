package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-common-word/
 * 
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list
 *  of banned words.  It is guaranteed there is at least one word that isn't banned,
 *   and that the answer is unique.
 *   Words in the list of banned words are given in lowercase, and free of punctuation.
 *   Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * @author amit
 *
 */
public class MostCommonWord {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = new String[] {"hit"};
		System.out.println(mostComonWord(paragraph, banned));
	}
	private static String mostComonWord(String paragraph, String[] banned) {
		
		int freq = 0;
		int maxFreq = 0;
		String commonWord = "";
		paragraph = paragraph.replaceAll("[^A-Za-z]+", "").toLowerCase();
		String[] p = paragraph.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String str : p) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		List<String> list = new ArrayList<String>();
		for(int i = 0; i<banned.length; i++) {
			list.add(banned[i]);
		}
		
		for(String key : map.keySet()) {
			if(list.contains(key))
				continue;
			else {
				freq = map.get(key);
				if(freq>maxFreq) {
					maxFreq = freq;
					commonWord = key;
				}
			}
		}
		
		return commonWord;
	}
}
