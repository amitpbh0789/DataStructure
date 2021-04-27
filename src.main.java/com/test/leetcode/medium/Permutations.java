package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * 
 * @author amit
 *
 */
public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1,3,2};
		List<List<Integer>> res = permute(nums);
		System.out.println(res);
	}

    public static List<List<Integer>> permute(int[] nums) {
    	
    	List<List<Integer>> res = new ArrayList<>();
    	
    	if(nums == null || nums.length == 0) {
    		return res;
    	}
    	backtrack(nums, res, new ArrayList<>());
    	return res;
    	
    }
    
    /**
     * @param nums
     * @param res
     * @param permutation
     */
    private static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> permutation) {
    	
    	if(permutation.size() == nums.length) {
    		res.add(new ArrayList<>(permutation));
    		return;
    	}
    	for(int i=0; i<nums.length; i++) {
    		
    		if(permutation.contains(nums[i])) {
    			continue;
    		}
    		permutation.add(nums[i]);
    		backtrack(nums, res, permutation);
    		permutation.remove(permutation.size()-1);
    		
    	}
    	
    }
}
