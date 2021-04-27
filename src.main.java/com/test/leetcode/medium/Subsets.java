package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/subsets/
 * 
 * @author amit
 *
 */
public class Subsets {

	public static void main(String[] args) {

		Subsets obj = new Subsets();
		int[] nums = {1,2,3};
		System.out.println(obj.subsets(nums));
	}

	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		
		List<Integer> subset = new ArrayList<>();
		
		Arrays.sort(nums);
		getSubSets(res, subset, 0, nums);
		
		return res;
	}
	
	private void getSubSets(List<List<Integer>> res, List<Integer> subset, int start, int[] nums) {
		
//		Add each subset into superset
		res.add(new ArrayList<>(subset));
		
//		Iterate and add each into set and pass next index as start.
		for(int i=start; i<nums.length; i++) {
			subset.add(nums[i]);
			getSubSets(res, subset, i+1, nums);
			subset.remove(subset.size()-1);
		}
		
	}

}
