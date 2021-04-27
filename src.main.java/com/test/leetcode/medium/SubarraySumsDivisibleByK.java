package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 
 * https://www.geeksforgeeks.org/count-sub-arrays-sum-divisible-k/
 * 
 * Time Complexity: O(N), where N is the length of A.
 * Space Complexity: O(N). (However, the solution can be modified to use O(K) space by storing only count.)
 *
 *@Note: If precalculated prefix comes again which means there is a number which can be divided by k
 */
public class SubarraySumsDivisibleByK {

	public static void main(String[] args) {

		SubarraySumsDivisibleByK obj = new SubarraySumsDivisibleByK();
		int[] arr = new int[] {4,5,0,-2,-3,1};
		int k = 5;
		System.out.println(obj.subarraysDivByK(arr, k));
	}

	public int subarraysDivByK(int[] arr, int k) {

		Map<Integer, Integer> count = new HashMap<>(); 

		count.put(0, 1); // let's keep this as default so that we can check if sum is there there in the map

		int prefix = 0;
		int res = 0;

		for (int a : arr) {
			////If precalculated prefix comes again which means there is a number which can be divided by k
			prefix = (prefix + a % k + k) % k; // Add a into prefix and handle a<0 case and calculate mod
			res = res + count.getOrDefault(prefix, 0);
			count.put(prefix, count.getOrDefault(prefix, 0) + 1);
		}
		return res;
	}
}
