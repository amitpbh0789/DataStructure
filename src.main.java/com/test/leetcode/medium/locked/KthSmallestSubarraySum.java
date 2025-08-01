package com.test.leetcode.medium.locked;

/** 
 * LintCode: https://www.lintcode.com/problem/3736
 * https://leetcode.com/problems/kth-smallest-subarray-sum/description/
 * 
 * Given an integer array nums of length n and an integer k, return the kth smallest subarray sum. 
 * A subarray is defined as a non-empty contiguous sequence of elements in an array. A subarray sum is the sum of all elements in the subarray.
 * 
 * Input: nums = [2,1,3], k = 4      Output: 3

Explanation: The subarrays of [2,1,3] are:
- [2] with sum 2
- [1] with sum 1
- [3] with sum 3
- [2,1] with sum 3
- [1,3] with sum 4
- [2,1,3] with sum 6 

Ordering the sums from smallest to largest gives 1, 2, 3, 3, 4, 6. The 4th smallest is 3.

 * ****Similar algorithm as Leetcode Problem "Capacity To Ship Packages Within D Days" https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * 
 * Use binary search. The maximum subarray sum is the sum of all elements in nums and the minimum subarray 
 * sum is the minimum element in nums. Initialize high and low as the maximum subarray sum and the minimum subarray sum. 
 * Each time let mid be the mean of high and low and count the number of subarrays that have sum less than or equal to mid, 
 * and adjust high and low accordingly. Finally the k-th smallest subarray sum can be obtained.

To count the number of subarrays that have sum less than or equal to mid, use sliding window over nums and for each index, 
count the number of subarrays that end at the index with sum less than or equal to mid.
 */
public class KthSmallestSubarraySum {
	
	public static void main(String[] args) {
		KthSmallestSubarraySum obj = new KthSmallestSubarraySum();
		int[] nums = new int[] {1, 2, 3};
		System.out.println(obj.kthSmallestSubarraySum(nums, 4));
	}
	
	public int kthSmallestSubarraySum(int[] nums, int k) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            min = Math.min(min, num); // Min sum
            sum += num; // Max sum
        }
        int low = min, high = sum;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int count = countSubarrays(nums, mid); // Count sub arrays with mid sum. 
            // If sub array count is same as K for given mid value then thats the answer
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int countSubarrays(int[] nums, int threshold) {
        int count = 0;
        int sum = 0;
        int length = nums.length;
        int left = 0, right = 0;
        while (right < length) {
            sum += nums[right];
            while (sum > threshold) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

}
