package com.test.leetcode.easy;

/**
 * 
 * https://leetcode.com/problems/roman-to-integer/
 * @author amit
 *
 */
public class RomanToInteger {

	public static void main(String[] args) {
		
		String str = "XIV";
		char[] charArray = str.toCharArray();
		int prev = romanDictionary(charArray[charArray.length-1]);
		int current = 0;
		int result = prev;
		for(int i = charArray.length-2; i>=0; i--) {
			current = romanDictionary(charArray[i]);
			if(current<prev) {
				result -= current;
				prev = 0;
			}else {
				result += current;
				prev = current;
			}
		}
		System.out.println(result);
		
	}
	private static int romanDictionary(char romanChar) {
		
		int num = 0;
		switch(romanChar) {
		
		case 'I':
			num = 1;
			break;
		case 'V':
			num = 5;
			break;
		case 'X':
			num = 10;
			break;
		case 'L':
			num = 50;
			break;
		case 'C':
			num = 100;
			break;
		case 'D':
			num = 500;
			break;
		case 'M':
            num = 1000;
            break;
        default:
            num = 0;
            break;
		}
		return num;
	}
}
