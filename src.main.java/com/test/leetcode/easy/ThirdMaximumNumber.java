package com.test.leetcode.easy;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/third-maximum-number/
 * 
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist,
 *  return the maximum number. The time complexity must be in O(n).
 * @author amit
 *
 */
public class ThirdMaximumNumber {

	public static void main(String[] args) {
		ThirdMaximumNumber obj = new ThirdMaximumNumber();
		int[] nums = new int[] {3, 2, 1};
		System.out.println(obj.thirdMax(nums));
	}

	public int thirdMax(int[] nums) {

		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for(int i=0; i<nums.length; i++){
			if(!heap.contains(nums[i])){
				heap.add(nums[i]);
				if(heap.size()>3){
					heap.poll();
				}
			}

		}
		if(heap.size()==2)
			heap.poll();
		return heap.peek();
	}

}
