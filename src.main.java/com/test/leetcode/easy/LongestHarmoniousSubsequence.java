package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 * 
 * @author amit
 *
 */
public class LongestHarmoniousSubsequence {

	public static void main(String[] args) {
		LongestHarmoniousSubsequence obj = new LongestHarmoniousSubsequence();
		int[] nums = {1,3,2,2,5,2,3,7};
		System.out.println(obj.findLHS(nums));
	}

	public int findLHS(int[] nums) {

		if(nums == null || nums.length == 0)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}

		int result = 0;
		for(int key : map.keySet()){
			if(map.containsKey(key+1)){
//              Adding frequency of min and max value
				result = Math.max(result, map.get(key+1) + map.get(key));
			}
		}
		return result;
	}
}
