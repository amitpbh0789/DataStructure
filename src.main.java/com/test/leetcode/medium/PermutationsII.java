package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/permutations-ii/
 * 
 * @author amit
 *
 */
public class PermutationsII {

	public static void main(String[] args) {

		int[] nums = {1,1,3};
		
		PermutationsII permu = new PermutationsII();
		System.out.println(permu.permuteUnique(nums));
		
	}

	public List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		calculatePermutations(nums, res, new ArrayList<>(), visited);
		
		return res;
	}
	
	private void calculatePermutations(int[] nums, List<List<Integer>> res, List<Integer> permutation, boolean[] visited) {
		
		if(permutation.size() == nums.length) {
			res.add(new ArrayList<>(permutation));
			return;
		}
		
		
		for(int i=0; i<nums.length; i++) {
			
			if (!visited[i]) {
				
				if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
					continue;
                }
				visited[i] = true;
				
				permutation.add(nums[i]);
				calculatePermutations(nums, res, permutation, visited);
				visited[i] = false;
				permutation.remove(permutation.size()-1);
			}
		}
		
	}
}
