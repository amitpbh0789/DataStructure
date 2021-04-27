package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

	public static void main(String[] args) {

		LongestWordInDictionaryThroughDeleting obj = new LongestWordInDictionaryThroughDeleting();
		String s = "abpcplea";
		List<String> d = new ArrayList<>();
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");
		
		System.out.println(obj.findLongestWord3(s, d));
	}

	/**
	 * Solution 1
	 * 
	 * @param s
	 * @param d
	 * @return
	 */
	public String findLongestWord(String s, List<String> d) {

		//      Base condion null check
		if(s == null || s.length() == 0 || d == null || d.size() == 0)
			return "";

		String res = "";

		//         Loop through each word and compare with String s and see if word can be formed out of String s
		for(String dicWord : d){

			if(isSubSequent(dicWord, s)){
				//                 If word can be formed then assing word to res;
				if(dicWord.length()>res.length())
					res = dicWord;
				//                 If word is formed and length of the new word and res is same then use compare method for lexicographical. If it is less than 0 then assign new word to res else leave it
				if(dicWord.length() == res.length() && dicWord.compareTo(res)<0)
					res = dicWord;
			}
		}
		return res;
	}

	/*
	 *This method will check if word can be formed out of String s. 
	 */
	private boolean isSubSequent(String dicWord, String s){

		char[] dicWordArr = dicWord.toCharArray();
		char[] scArr = s.toCharArray();
		int i=0, j=0;

		while(i<dicWordArr.length && j<scArr.length){
			if(dicWordArr[i] == scArr[j])
				i++;
			j++;
		}
		return i == dicWordArr.length;
	}
	
	
	private String findLongestWord2(String s, List<String> d) {
		
//	IMP It will sort based on length first, if lengths are same then based on lexicographical
		Collections.sort(d, (a, b) -> a.length() != b.length() 
				? -Integer.compare(a.length(), b.length())
				: a.compareTo(b));
		
		for(String dicWord : d) {
			
			int i=0;
			for(char c : s.toCharArray()) {
				if(i<dicWord.length() && c==dicWord.charAt(i))
					i++;
			}
			if(i==dicWord.length()) 
				return dicWord;
		}
		return "";
	}
	
	private String findLongestWord3(String s, List<String> d) {
//		If length is same the lexical order else decreasing length
		Collections.sort(d, (s1, s2)-> s1.length()==s2.length()?s1.compareTo(s2):s2.length()-s1.length());
		
		for(String dicWord : d) {
			int i=0;
			
			for(char c : s.toCharArray()) {
				if(i<dicWord.length() && dicWord.charAt(i)==c) {
					i++;
				}
			}
			
			if(i==dicWord.length()) {
				return dicWord;
			}
		}
		return null;
	}
}
