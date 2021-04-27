package com.test.leetcode.easy;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of 
 * them is that adjacent houses have security system connected and it will automatically 
 * contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * #################
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * @author amit
 *
 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] money = {2,7,9,3,1};
		
		System.out.println("Max money which can be robbed is -> "+houseRobber(money));
	}
	
	private static int houseRobber(int[] money) {
		
		if(money.length ==0 || money == null)
			return 0;
		if(money.length == 1)
			return money[0];
		if(money.length == 2)
			return Math.max(money[0], money[1]);
		
		int[] robberyAmount = new int[money.length];
		
		robberyAmount[0] = money[0];
		robberyAmount[1] = Math.max(money[0], money[1]);
		
		for(int i = 2; i<money.length; i++) {
			robberyAmount[i] = Math.max(money[i] + robberyAmount[i-2], robberyAmount[i-1]);
		}
		
		return (robberyAmount[money.length - 1]);
	}
}
