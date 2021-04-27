package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 * 
 * You are playing the following Bulls and Cows game with your friend: You write down a number 
 * and ask your friend to guess what the number is. Each time your friend makes a guess,
 *  you provide a hint that indicates how many digits in said guess match your secret number 
 *  exactly in both digit and position (called "bulls") and how many digits match the secret
 *   number but locate in the wrong position (called "cows"). Your friend will use successive 
 *   guesses and hints to eventually derive the secret number.
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate
 *  the bulls and B to indicate the cows. 
 *  
 *  Please note that both secret number and friend's guess may contain duplicate digits.
 *  
 *  Input: secret = "1807", guess = "7810"
 *  Output: "1A3B"
 *  Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 *  
 *  Note: You may assume that the secret number and your friend's guess only contain digits,
 *   and their lengths are always equal.
 *  
 * @author amit
 *
 */
public class BullsAndCows {

	public static void main(String[] args) {
		System.out.println(countBullsAndCows("1807", "7810"));
	}
	private static String countBullsAndCows(String secret, String guess) {
		char[] secretArr = secret.toCharArray();
		char[] guessArr = guess.toCharArray();
		List<Character> charList = new ArrayList<Character>();
		int bullsCount = 0;
		int count = 0;
		while(count<secretArr.length) {
			if(secretArr[count] == guessArr[count]) {
				bullsCount++;
			}else {
				charList.add(secretArr[count]);
			}
			count++;
		}
		int cowsCount = 0;
		for(int i=0; i<guessArr.length; i++) {
			if(charList.contains(guessArr[i])) {
				cowsCount++;
			}
				
		}
		String result = bullsCount+"A"+cowsCount+"B";
		return result;
	}
}
