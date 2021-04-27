package com.test.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/circular-array-loop/
 *
 */
public class CircularArrayLoop {

	public static void main(String[] args) {
		CircularArrayLoop obj = new CircularArrayLoop();
		int[] nums = new int[] {2,-1,1,2,2};
		obj.circularArrayLoop(nums);
	}

	public boolean circularArrayLoop(int[] nums) {
		Set<Integer> visited = new HashSet<>(); // set to make sure if index is visited

		for(int i=0; i<nums.length; ){

			if(visited.contains(i))
				return true;

			visited.add(i);
			int next = i+nums[i];

			if(next<0)
				i = nums.length-nums[i];
			else if(next>=nums.length)
				i = nums[i];
			else
				i = next;
		}
		return false;
	}
}
