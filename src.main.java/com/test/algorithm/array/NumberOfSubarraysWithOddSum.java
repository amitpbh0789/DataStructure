package com.test.algorithm.array;

/**
 * 
 * Approach:
 * 
 * odd+odd = even
 * even + even = even
 * 
 * even + odd = odd
 * 
 * We need to add even count when odd sum occurs and odd when even sum occurs in order to get odd subarrays
 * Since, we add even, if cumulative sum is odd, lets initialize even with 1 
 *
 */
public class NumberOfSubarraysWithOddSum {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2};
		NumberOfSubarraysWithOddSum obj = new NumberOfSubarraysWithOddSum();
		System.out.println(obj.findOddSumSubArrays(arr));
	}
	
	public int findOddSumSubArrays(int[] arr) {
		
		int odd = 0;
		int even = 1;
		
		int sum = 0;
		int res = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
			
			if(sum%2==0) {
				res = res + odd;
				even++;
			}else {
				res = res + even;
				odd++;
			}
		}
		return res;
	}

}
