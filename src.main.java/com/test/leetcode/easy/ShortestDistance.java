package com.test.leetcode.easy;

import java.util.Vector;

/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 *
 */
public class ShortestDistance {

	public static void main(String[] args) {
		shortestDistance("loveleetcode", 'e');
	}
	private static void shortestDistance(String S, char X) {
		
		int prev = Integer.MAX_VALUE;
		Vector<Integer> ans = new Vector<>();
		for(int i =0; i<S.length(); i++) {
			
			if(S.charAt(i) == X) {
				prev = i;
			}
			ans.add(i - prev);
		}
		
		prev = Integer.MAX_VALUE; 
		for(int i=S.length()-1; i>=0; i--) {
			if(S.charAt(i) == X)
				prev = i;
			ans.set(i, Math.min(ans.get(i), prev-i));
		}
		int firstIndex = ans.indexOf(0);
		for(int i=0; i<ans.size();i++) {
			if(i<firstIndex) {
				ans.set(i, firstIndex-i);
			}
			System.out.print(ans.get(i)+" "); 
		}
	}
}
