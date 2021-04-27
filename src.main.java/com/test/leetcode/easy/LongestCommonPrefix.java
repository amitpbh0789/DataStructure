package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * @author amit
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		System.out.println(obj.longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs) {

		if(strs == null || strs.length == 0)
			return "";

//		Take first string as prefix
		String prefix = strs[0];
//		take each string starting from 2nd and try to find prefix
		for(int i=1; i<strs.length; i++){

//		Keep checking if prefix is found If not keep removing last char every time. If at the last nothing left out means no common prefix found
			while(strs[i].indexOf(prefix) != 0)
				prefix = prefix.substring(0, prefix.length()-1);
		}
		return prefix;
	}
}
