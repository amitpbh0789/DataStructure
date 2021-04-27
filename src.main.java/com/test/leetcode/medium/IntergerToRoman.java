package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * @author amit
 *
 */
public class IntergerToRoman {

	public static void main(String[] args) {
		IntergerToRoman obj = new IntergerToRoman();
		System.out.println(obj.intToRoman(58));
		
	}

	public String intToRoman(int num) {

		int[] values = {1000, 900, 500, 400, 100, 90, 50,40,10,9,5,4,1};
		String[] romanLiternals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<values.length; i++) {
			while(num>=values[i]) {
				sb.append(romanLiternals[i]);
				num -= values[i];
			}
		}

		return sb.toString();
	}
}
