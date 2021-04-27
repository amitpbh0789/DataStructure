package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * @author amit
 *
 */
public class WordLadder {

	public static void main(String[] args) {
		
		String beginWord = "a";
		String endWord = "c";
		List<String> wordList = new ArrayList<>();
		wordList.add("a");
		wordList.add("b");
		wordList.add("c");
//		wordList.add("lot");
//		wordList.add("log");
//		wordList.add("cog");
		int res = ladderLength(beginWord, endWord, wordList);
		System.out.println(res);
		
	}
	private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
     
		int length = beginWord.length();
		HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
		
		wordList.forEach(word -> {
			
			for(int i=0; i<length; i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i+1, length);
				ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
				transformations.add(word);
				allComboDict.put(newWord, transformations);
			}
			
		});
		
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		int level = 0;
		
	    HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
	    visited.put(beginWord, true);
		
		while(!queue.isEmpty()) {
			
			String fetcehedWord = queue.remove();
			for(int i=0; i<length; i++) {
				String newWord = fetcehedWord.substring(0, i) + "*" + fetcehedWord.substring(i+1, length);
				
				for(String str : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
					if(str.equals(endWord)) {
						return level++;
					}
					
					if(!visited.containsKey(str)) {
						visited.put(str, true);
						queue.add(str);
						level++;
					}
					
				}
			}
			
		}
		
		return 0;
    }
}
