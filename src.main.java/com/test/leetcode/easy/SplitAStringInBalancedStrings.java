package com.test.leetcode.easy;

public class SplitAStringInBalancedStrings {

	public static void main(String[] args) {
		SplitAStringInBalancedStrings obj = new SplitAStringInBalancedStrings();
		String s = "RLRRLLRLRL";
		System.out.println(obj.balancedStringSplit(s));
	}

	public int balancedStringSplit(String s) {

		char[] arr = s.toCharArray();
		if(s.length() == 0)
			return 0;

		int countR = 0;
		int countL = 0;
		int count = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 'L')
				countL++;
			else if(arr[i] == 'R')
				countR++;
			if(countR == countL){
				count++;
				countR = 0;
				countL = 0;
			}
		}
		return count;
	}
}
