package com.test.algorithm.array;
/**
 * https://www.geeksforgeeks.org/find-number-subarrays-even-sum/
 *
 * odd+odd = even
 * even + even = even
 */
public class NumberOfSubarraysWithEvenSum {

	public static void main(String[] args) {
		NumberOfSubarraysWithEvenSum obj = new NumberOfSubarraysWithEvenSum();
		int[] arr = new int[] {1, 2};
		System.out.println(obj.findEvenSumSubArrays(arr));
	}


	public int findEvenSumSubArrays(int[] arr) {

		int odd = 0;
		int even = 1;

		int sum = 0;
		int res = 0;

		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];

			if(sum%2==0) {
				res = res + even;
				even++;
			}else {
				res = res + odd;
				odd++;
			}
		}
		return res;
	}

	/**
	 * Need to understand the logic
	 */
	public int count(int[] arr) {

		int[] temp = {1, 0}; // this will contain count of even and odd subarrays. temp[0] 
		//is initialized as 0 coz single elements also considered as subarray

		int sum = 0;
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			sum = ((sum + arr[i])%2 + 2) %2; // it will calculate if adding new number makes even or odd

			temp[sum]++;

		}
		//2,3,4
		// Now we have count of even and count of odd
		result = result + (temp[0] * (temp[0] - 1) / 2);
		result = result + (temp[1] * (temp[1] - 1) / 2);

		return result;

	}
}
