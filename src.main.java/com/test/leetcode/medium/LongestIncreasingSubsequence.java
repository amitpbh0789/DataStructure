package com.test.leetcode.medium;

/**
 * @author Amit
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Time complexity : O(n^2). Two loops of n are there.
 * Space complexity : O(n). DP array of size n is used.
 * 
 * Kind of sliding window approach. Traverse from 0 to i and populate DP array with max length
 * At the end, return the max length
 * 
 * IMP --> Idea is to count how many numbers current indexed number is greater from and populate DP array.
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int[] nums = new int[] {10,9,2,5,3,7,101,18};
		System.out.println(obj.lengthOfLIS(nums));
	}
	
	public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
