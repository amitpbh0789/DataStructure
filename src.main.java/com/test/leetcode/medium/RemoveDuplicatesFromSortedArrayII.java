package com.test.leetcode.medium;

public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		
		RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();
		int[] nums = {1,1,1,2,2,3};
		System.out.println(obj.removeDuplicates(nums));
	}
	
	 private int removeDuplicates(int[] nums) {
	        if(nums == null)
	            return 0;
	        
//	        Start with index 2 because max we can keep 2 same number. THis will track the position of placement
	        int left = 2;
	        
	        for(int right = 2; right<nums.length; right++) {
	        	if(nums[left-2] != nums[right]) {
	        		nums[left++] = nums[right];
	        	}
	        }
	        return left;
	    }
}
