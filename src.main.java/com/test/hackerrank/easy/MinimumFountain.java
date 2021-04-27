package com.test.hackerrank.easy;

import java.util.Arrays;
import java.util.List;

/**
 * Similar to  Video Stitching Leetcode problem 
 * 
 * https://leetcode.com/problems/video-stitching/
 *
 */
public class MinimumFountain {

	public static void main(String[] args) {
		
		MinimumFountain obj = new MinimumFountain();
		List<Integer> locations = Arrays.asList(1, 2, 0, 0,0);
		System.out.println(obj.fountainActivation(locations));
	}
	
	public int fountainActivation(List<Integer> locations) {
		
		int n = locations.size();
		int[] dp = new int[n];
		
		for(int i=1; i<=n; i++) {
			int start = Math.max(i-locations.get(i-1), 1);
			int end = Math.min(i+locations.get(i-1), n);
			
			dp[start-1] = end;
		}
		
		int end = dp[0];
		int max = end;
		
		int count = 1;
		for(int i=1; i<n; i++) {
			
			if(i>=max) {
				return -1;
			}
			max = Math.max(max, dp[i]);
			
			if(i==end) {
				count++;
				end = max;
			}
		}
		
		return count;
	}
}
