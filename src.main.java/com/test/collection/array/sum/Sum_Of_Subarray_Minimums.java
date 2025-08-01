package com.test.collection.array.sum;

/**
 * https://www.geeksforgeeks.org/sum-of-minimum-elements-of-all-subarrays/
 * 
 * Given an array A of n integers. The task is to find the sum of minimum of all possible (contiguous) subarray of A.
 * 
 * Input: A = [3, 1, 2, 4] 
 * Output: 17 
 * Explanation: SubArrays are [3], [1], [2], [4], [3, 1], [1, 2], [2, 4], [3, 1, 2], [1, 2, 4], [3, 1, 2, 4]. 
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1. Sum is 17.
 * 
 *Approach: 
 *The Naive approach is to generate all possible (contiguous) SubArrays, find their minimum and add them to result.
 *
 *Time: O(N2)
 *Space: O(1)
 */
public class Sum_Of_Subarray_Minimums {

	public static void main(String[] args) {
		Sum_Of_Subarray_Minimums obj = new Sum_Of_Subarray_Minimums();
		int[] arr = new int[] {3,1,2,4};
		int ans = obj.sumSubarrayMins(arr);
		System.out.println(ans);

	}

	public int sumSubarrayMins(int[] nums) {
		int ans = 0;
        int n = nums.length;
 
        for (int i = 0; i < n; i++) {
            
        	int min_ele = nums[i];
 
            for (int j = i; j < n; j++) {
                min_ele = Math.min(min_ele, nums[j]); // find Min in subArray
 
                ans += min_ele; // Keep adding of each minimum calculated above
            }
        }
 
        return ans;

	}

}
