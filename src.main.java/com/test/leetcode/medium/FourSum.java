package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 * 
 * 1) Sort the input array.
 * 2) Fix the first element as A[i] where i is from 0 to n–3. 
 * After fixing the first element of quadruple, fix the second element as A[j] 
 * where j varies from i+1 to n-2. Find remaining two elements in O(n) time,
 * using the method 1 of this post
 * 
 * Desc: Idea is to keep sum of first 2 and then loop in for remaining 2
 *  2 sum + 2 sum
 *  
 * @author amit
 *
 */
public class FourSum {

	public static void main(String[] args) {

		FourSum obj = new FourSum();
//		-3,-2,-1,0,0,1,2,3
//		0,0,0,0
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		System.out.println(obj.fourSum(nums, 0));
	}

	private List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		Boundary check
		if(nums == null || nums.length == 0)
			return res;
		
//		Sort the array
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length-3; i++) {
			
			if(i==0 || nums[i] != nums[i-1]) {
				
				for(int j=i+1; j<nums.length-2; j++) {
					
//					IMP --> This check is to make sure if last digit of first 2 sum, is not repeating.
//					Taking it from j>i+1 else 0,0,0,0 will return null value;
					if(j>i+1 && nums[j]== nums[j-1])
						continue;
					
					int left = j+1;
					int right = nums.length-1;
					
					int sum = target-nums[i]-nums[j];
					
//					Loop through to get remaining 2 elements
					while(left<right) {
						
						if(nums[left]+nums[right] == sum) {
							res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
							while(left<right && nums[left]== nums[left+1])
								left++;
							while(left<right && nums[right] == nums[right-1])
								right--;
							left++;
							right--;
						} else if(nums[left]+nums[right]<sum)
							left++;
						else
							right--;
					}
				}
			}
		}
		return res;
	}
}
