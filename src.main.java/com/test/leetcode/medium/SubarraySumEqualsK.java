package com.test.leetcode.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {

	public static void main(String[] args) {

		SubarraySumEqualsK obj = new SubarraySumEqualsK();
		int[] nums = {1,5,10};
		int k = 10;
		obj.subarraySum(nums, k);
	}

	public int subarraySum(int[] nums, int k) {
		int sum = 0; 
		int count = 0;
		HashMap<Integer, Integer> preMap = new HashMap<>();
		preMap.put(0, 1);

		for(int i=0; i<nums.length; i++){
			sum = sum + nums[i];

			if(preMap.containsKey(sum-k)){
				count = count + preMap.get(sum-k);
			}

			preMap.put(sum, preMap.getOrDefault(sum, 0)+1);
		}
		return count;
	}
}
