package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/decode-ways/
 * 
 * @author amit
 *
 */
public class DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings("2217"));
	}
	private static int numDecodings(String s) {
		int length = s.length();
		
		if(length==0 || s.startsWith("0"))
			return 0;
		
		int[] ways = new int[length+1];
		ways[0] = 1;
		ways[1] = 1;
		
		for(int i=2; i<=length; i++) {
			
			int oneDigit = Integer.parseInt(s.substring(i-1, i));
			int twoDigit = Integer.parseInt(s.substring(i-2, i));
			
			if(oneDigit >=1) {
				ways[i] += ways[i-1];
			}
			if(twoDigit >= 10 && twoDigit<=26) {
				ways[i] += ways[i-2];
			}
		}
		
		return ways[length];
	}
}
