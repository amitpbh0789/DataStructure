package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * 
 * @author amit
 *
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		int[] nums = {1,1,2};
//		Using extra space
		List<Integer> res = removeDuplicatesUsingExtraSpace(nums);
		res.forEach(r -> {
			System.out.println(r);
		});
		
	}
	private static List<Integer> removeDuplicatesUsingExtraSpace(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(nums[0]);
		for(int i=1; i<nums.length; i++) {
			if(nums[i] != nums[i-1])
				list.add(nums[i]);
		}
		return list;
	}
}
