package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * This implementation is kind of similar to getting all permutation of given string
 * 
 * @author amit
 *
 */
public class PalindromePartioning {

	public static void main(String[] args) {
		
		PalindromePartioning obj = new PalindromePartioning();
		String s = "aab";
		System.out.println(obj.partition(s));
	}

	public List<List<String>> partition(String s) {
		
		List<List<String>> res = new ArrayList<>();
		if(s.length()==0)
			return res;
		
		List<String> partition = new ArrayList<>();
		
		recur(res, partition, s);

		return res;
	}

	public void recur(List<List<String>> res,List<String> partition, String s){
		
//		Add partition into res when iteration completed means when string becomes empty.
		if(s.length() == 0) {
			res.add(new ArrayList<>(partition));
			return;
		}
		
		for(int i=0; i<s.length(); i++) {
//			Get each substring and check if its Palindrome.
			if(isPalindrome(s.substring(0,i+1))) {
//			If Palindrome, add into partition list and call recur method with substring starting from next index
				partition.add(s.substring(0,i+1));
				recur(res, partition, s.substring(i+1));
				partition.remove(partition.size()-1);
			}
		}
		
	}

	public boolean isPalindrome(String s){
		
		int i=0;
		int j=s.length()-1;
		
		while(i<j) {
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
