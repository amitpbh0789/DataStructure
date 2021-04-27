package com.test.leetcode.medium;

/**
 * 
 * https://leetcode.com/problems/sort-colors/
 * 
 * @author amit
 *
 */
public class SortColors {

	public static void main(String[] args) {

		SortColors obj = new SortColors();
		int[] nums = {2,0,1};
		obj.sortColors(nums);
		System.out.println(nums);
		
	}

	public void sortColors(int[] nums) {

		if(nums == null || nums.length == 0)
			return;
		
		int zeroIndex = 0;
		int index = 0;
		int end = nums.length-1;
		
		while(index<=end) {
			
			if(nums[index] == 0) {
				
				nums[index] = nums[zeroIndex];
				nums[zeroIndex++] = 0;
				
			}
			else if(nums[index] == 2) {
				
				nums[index] = nums[end];
				nums[end] = 2;
				end--;
				index--;
			}
			index++;
			
		}
		
	}
}
