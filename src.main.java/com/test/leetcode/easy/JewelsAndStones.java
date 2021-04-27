package com.test.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 * @author amit
 *
 */
public class JewelsAndStones {

	public static void main(String[] args) {
		String s = "aAAbbbb";
		String j = "aA";
		Set<Character> charSet = new HashSet<>();
		for(char c : j.toCharArray()) {
			charSet.add(c);
		}
		int count = 0;
		for(char c : s.toCharArray()) {
			if(charSet.contains(c)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
