package com.test.leetcode.medium.locked.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the shortest sorted list of ranges that exactly covers all the missing numbers. 
That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: [[2,2],[4,49],[51,74],[76,99]]
Explanation: The ranges are: [2,2], [4,49], [51,74], [76,99]

Time: O(N)

 */
public class MissingRanges {

	public static void main(String[] args) {
		MissingRanges mr = new MissingRanges();
		int[] nums = new int[] {0,1,3,50,75};
		int lower = 0;
		int upper = 99; 
		List<List<Integer>> ans = mr.findMissingRanges(nums, lower, upper);
		System.out.println("Missing ranges are--> "+ans);

	}

	public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
		List<List<Integer>> ans = new ArrayList<>();
		int start = lower;
		
		for(int curr : nums) {
			if(curr == start) {
				start++;
			} else {
				ans.add(Arrays.asList(start, curr-1));
				start = curr + 1;
			}
		}
		
		// to handle last range between last number and end of the range
		if(start<= upper) {
			ans.add(Arrays.asList(start, upper));
		}
		
		return ans;
	}

}
