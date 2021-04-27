package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * 
 * @author amit
 *
 */
public class WordBreak {

	public static void main(String[] args) {
		String s = "applepenapple";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("apple");
		wordDict.add("pen");
		boolean rs = wordBreak(s, wordDict);
		System.out.println(rs);
		System.out.println(wordBreakSolution2(s, wordDict));
	}
	private static boolean wordBreak(String s, List<String> wordDict) {
		return word_break(s, wordDict, 0);
    }
	
	private static boolean word_break(String s, List<String> wordDict, int start) {
		
		if(start==s.length()) {
			return true;
		}
		for(int end=start+1; end<=s.length(); end++) {
			
			if(wordDict.contains(s.substring(start, end)) && word_break(s, wordDict, end)) {
				return true;
			}
			
		}
		return false;
	}
	
	
	private static boolean wordBreakSolution2(String s, List<String> list) {
		
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i=1; i<=s.length(); i++) {
			for(int j=0; j<i; j++) {
				
				if(dp[j] && list.contains(s.substring(j,i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
