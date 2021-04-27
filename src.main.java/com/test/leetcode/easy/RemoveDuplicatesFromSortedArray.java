package com.test.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {

		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		int[] nums = {1,1,2};
		System.out.println(obj.removeDuplicates(nums));
	}

	public int removeDuplicates(int[] nums) {

		if(nums == null || nums.length == 0)
			return 0;

//        Start with index 1 because max we can keep just 1 number. This will track the position of placement
		int left=1;

		for(int right=1; right<nums.length; right++){
			if(nums[left-1] != nums[right]) //If current element is not equal to prev one then increase prev index and store current value. Else keep on adding at same index;
				nums[left++] = nums[right];
		}
		return left;
	}
}
