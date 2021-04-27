package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 * 
 * @author amit
 *
 */
public class FindNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> resp = findDeprecatedNumbers(nums);
		resp.forEach(res -> {
			System.out.println(res);
		});
	}
	private static List<Integer> findDeprecatedNumbers(int[] nums) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i=0;i<nums.length; i++) {
			map.put(nums[i], true);
		}
		List<Integer> result = new LinkedList<Integer>();
		for(int i=1;i<nums.length; i++) {
			if(!map.containsKey(i)) {
				result.add(i);
			}
		}
		return result;
	}
}
