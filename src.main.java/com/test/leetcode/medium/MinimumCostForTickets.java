package com.test.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * 
 * Dynamic Programming: 
	Approach: Calculate min cost for each day and keep on adding. return the last entry from dp array

	Time: O(N)
	Space: O(N)
 *
 */
public class MinimumCostForTickets {

	public static void main(String[] args) {
		MinimumCostForTickets obj = new MinimumCostForTickets();
		int[] days = new int[] {1,4,6,7,8,20};
		int[] costs = new int[] {2,7,15};
		System.out.println(obj.mincostTickets(days, costs));
	}

	public int mincostTickets(int[] days, int[] costs) {
		// length up to the last travel + 1 day is good enough (no need for 365)
		int lastDay = days[days.length - 1]; 
		// dp[i] means up to i-th day the minimum cost of the tickets
		int[] dp = new int[lastDay + 1]; 
		// boolean[] isTravelDays = new boolean[lastDay + 1];
		Set<Integer> daySet = new HashSet<>();
		// mark the travel days
		for(int day : days) 
			daySet.add(day);

		for(int i = 1; i <= lastDay; i++) {
			if(!daySet.contains(i)) { // no need to buy ticket if it is not a travel day
				dp[i] = dp[i - 1];
				continue;
			}
			// select which type of ticket to buy
			dp[i] = costs[0] + dp[i - 1]; // 1-day
			dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]); // 7-day
			dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]); // 30-day
		}
		return dp[lastDay];
	}
}
