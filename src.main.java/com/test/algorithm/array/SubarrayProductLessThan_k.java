package com.test.algorithm.array;

public class SubarrayProductLessThan_k {

	public static void main(String[] args) {

		int[] arr = new int[] {10, 5, 2, 6};
		int k = 100;
		SubarrayProductLessThan_k obj = new SubarrayProductLessThan_k();
		
		int ans = obj.numSubarrayProductLessThanK(arr, k);
		System.out.println(ans);
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		
		if(nums == null || nums.length == 0)
			return 0;
		
		int length = nums.length;
		
		int leftWindowIndex = 0;
		int rightWindowIndex = 0;
		int total = 0;
		int product = 1;
		
		while(rightWindowIndex<length) {
			product *= nums[rightWindowIndex];
			
//			 Once reaches to k, divide product by nums[leftWindowIndex] and shift left pointer to right by 1 move
			while(leftWindowIndex<=rightWindowIndex 
					&& product>=k) {
				
				product /= nums[leftWindowIndex];
				leftWindowIndex++;
				
			}
			
			total += rightWindowIndex-leftWindowIndex+1;
			rightWindowIndex++;
			
		}
		
		return total;
	}
}
