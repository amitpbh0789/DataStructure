package src.main.java.algoexpert.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.algoexpert.io/questions/zero-sum-subarray
 * 
 * Time: O(N)
 * Space: O(1)
 */
public class ZeroSumSubArray {

	public static void main(String[] args) {
		int[] nums = new int[] {-5, -5, 2, 3, -2};
		ZeroSumSubArray obj = new ZeroSumSubArray();
		System.out.println(obj.zeroSumSubarray(nums));

	}
	
	public boolean zeroSumSubarray(int[] nums) {
	    
		Set<Integer> set = new HashSet<>();
		
		int sum = 0;
		for(int i : nums) {
			
			sum += i;
			
			if(i == 0 || sum == 0 || !set.add(sum)) {
				return true;
			}
		}
		
	    return false;
	  }

}
