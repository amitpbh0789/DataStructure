package com.test.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/next-closest-time/
 * 
 * @author amit
 *
 */
public class NextClosestTime {

	public static void main(String[] args) {
		
		NextClosestTime obj = new NextClosestTime();
		String time = "19:35";
		System.out.println(obj.nextClosestTime(time));
	}
	
	public String nextClosestTime(String time) {
		
//		Parse String time into Integer and convert into Minutes
		int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
		minutes += Integer.parseInt(time.substring(3));
		
//		Add all the time digits into HashSet
		Set<Integer> digits = new HashSet<>();
		for(char c: time.toCharArray()) {
			digits.add(c - '0');
		}
		
		while(true) {
			
//			To wrap the time, incase when time is 11:59 and becomes 00:00 midnight, will do a mode of 24*60
			minutes = (minutes +1)%(24*60);
//			Now will convert minutes into original time format we have
			int[] nextTime = {minutes/60/10, minutes/60%10, minutes%60/10, minutes%60%10};
			
			boolean isValid = true;
			for(int digit : nextTime) {
				if(!digits.contains(digit)) {
					isValid = false;
					break;
				}
			}
			
			if(isValid) {
//				Return 2 decimal points : 2 decimal points. 
//				minutes/60 will give hours and minutes%60 minutes.
				return String.format("%02d:%02d", minutes/60, minutes%60);
			}
		}
	}
}
