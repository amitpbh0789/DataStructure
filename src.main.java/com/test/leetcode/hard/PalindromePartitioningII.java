package com.test.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * 
 * @author amit
 *
 */
public class PalindromePartitioningII {

	int minCut = Integer.MAX_VALUE;
	public static void main(String[] args) {

		PalindromePartitioningII obj = new PalindromePartitioningII();
		String s = "ababababababababababababcbabababababababababababa";
		System.out.println(obj.minCut(s));
	}

	public int minCut(String s) {

		if(s.length() < 1)
			return 0;

		getPartitions(s, new ArrayList<>());
		return minCut;
	}


	private void getPartitions(String s, List<String> partition){

		if(s.length() == 0){
			minCut = Math.min(minCut, partition.size()-1);
		}

		for(int i=0; i<s.length(); i++){

			if(isPalindrome(s.substring(0,i+1))){

				partition.add(s.substring(0,i+1));
				getPartitions(s.substring(i+1), partition);
				partition.remove(partition.size()-1);
			}
		}

	}

	private boolean isPalindrome(String s){

		int i=0; 
		int j=s.length()-1;

		while(i<j){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
