package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @author amit
 *
 */
public class LetterCombinationsOfAPhoneNumber {

	
	
	public static void main(String[] args) {

		LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
		System.out.println(obj.letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {

		List<String> res = new LinkedList<String>();
		if(digits == null || digits.length() == 0) 
			return res;
		res.add("");
		
		char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		
		for(int i=0; i<digits.length(); i++) {
			
			List<String> nextList = new LinkedList<>();
			
			int num = digits.charAt(i) - '0';
			
			for(String s: res){
                for(int k = 0;k< map[num].length;k++){
                    nextList.add(s+map[num][k]);
                }
            }
			res = nextList;
			
		}
		return res;
	}
}
