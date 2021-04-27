package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 * 
 * @author amit
 *
 */
public class UglyNumberII {

	public static void main(String[] args) {

		UglyNumberII obj = new UglyNumberII();
		
		System.out.println(obj.nthUglyNumber(10));
	}

	public int nthUglyNumber(int n) {

		if(n == 0)
			return n;
		
		int[] nums = new int[n];
		int index2=0, index3=0, index5=0;
		int sequence2=1, sequence3=1, sequence5=1;

		for(int i=0; i<n; i++){
			nums[i] = Math.min(Math.min(sequence2, sequence3), sequence5);

			if(sequence2 == nums[i])
				sequence2 = 2*(nums[index2++]);
			if(sequence3 == nums[i])
				sequence3 = 3*(nums[index3++]);
			if(sequence5 == nums[i])
				sequence5 = 5*(nums[index5++]);
		}
		return nums[nums.length-1];
	}
}
