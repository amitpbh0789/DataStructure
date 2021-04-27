package com.test.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * Contains Duplicate
 * Input: [1,2,3,1]
 * Output: true
 * 
 * @author amit
 *
 */
public class ContainsDuplicateNumber {

	public static void main(String[] args) {
		int[] nums = {1,1,1,3,3,4,3,2,4,2};
		System.out.println(containsDuplicate(nums));
	}
	private static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
