package com.test.algorithm.array;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Time: O(N)
 * Space: O(1)
 * 
 * Sliding Window Approach
 * 
 * Keep on reducing nums[i] from sum until becomes less than or equal to 0
 * if becomes 0 then calculate the min length and add current value which will make next window
 * 
 * If no solution found, then mod n+1 will return 0 else min length calculated so far
 *
 */
public class MinimumSubArrayLengthOfSumK {

	public static void main(String[] args) {
		MinimumSubArrayLengthOfSumK obj = new MinimumSubArrayLengthOfSumK();
		int[] nums = new int[] {2,1,1,4,3};
		int sum = 7;
		System.out.println(obj.minSubArrayLen(sum, nums));
	}
	
	public int minSubArrayLen(int s, int[] A) {
        int i = 0;
        int n = A.length;
        int res = n + 1; // maxLength is n+1 so that later mod n+1 can help to return 0 incase no solution 
        
        for (int j = 0; j < n; j++) {
            s = s - A[j];
            while (s <= 0) {
                res = Math.min(res, j - i + 1);
                s += A[i++];
            }
        }
        return res % (n + 1);
    }
}
