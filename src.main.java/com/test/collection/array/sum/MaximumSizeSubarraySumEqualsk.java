package com.test.collection.array.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/911/
 * 
 * Given an array nums and a target value k, find the maximum length of a
 * subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Time: O(N) Space: O(N)
 * 
 */
public class MaximumSizeSubarraySumEqualsk {

	public static void main(String[] args) {
		MaximumSizeSubarraySumEqualsk obj = new MaximumSizeSubarraySumEqualsk();
		int[] arr = new int[] { 1, -1, 5, -2, 3 };
		int k = 3;
		System.out.println(obj.maxSubArrayLen(arr, k));
	}

	public int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int ans = 0;
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				ans = Math.max(ans, i - map.get(sum - k));
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

		}
		return ans;
	}

}
