package com.test.collection.array.product;

/**
 * https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 */
public class MaximumLengthSubarrayWith_PositiveProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getMaxLen(int[] nums) {

		int countNegative = 0;
		int firstNegative = -1;
		int zeroPostion = -1;
		int max = 0;

		for(int i=0; i<nums.length; i++){
			if(nums[i]<0){
				countNegative++;
				// we only need to know index of first negative number so check if value is -1 then only set else ignore
				if(firstNegative == -1)
					firstNegative = i;
			}
			// if current number is 0, we can't use any element from index 0 to i anymore, so update zeroPosition, 
			//and reset sum and firstNegative. If it is a game, we should refresh the game when we meet 0. 

			if(nums[i] == 0){
				firstNegative = -1;
				countNegative = 0;
				zeroPostion = i;
			} else{
				if(countNegative % 2 == 0){
					max = Math.max(i-zeroPostion, max);
				}else{
					max = Math.max(i-firstNegative, max);
				}
			}
		}
		return max;
	}

}
