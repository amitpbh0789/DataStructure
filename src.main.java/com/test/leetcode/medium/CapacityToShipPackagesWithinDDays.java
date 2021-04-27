package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * 
 * [1,2,3,4,5,6,7,8,9,10], 
 * min= 10 --> package with weight 10 can not be shipped partially hence min required is 10
 * max=55 --> we can ship all the packages in one ship hence max is sum of all package which is 55 here
 * 
 * now we need to fit within days given so we will use binary search for this.
 * 
 * 
 * @author amit
 *
 */
public class CapacityToShipPackagesWithinDDays {

	public static void main(String[] args) {

		CapacityToShipPackagesWithinDDays obj = new CapacityToShipPackagesWithinDDays();
		
		int[] weights= {1,2,3,4,5,6,7,8,9,10};
		int D=5;
		System.out.println(obj.shipWithinDays(weights, D));
	}

	public int shipWithinDays(int[] weights, int D) {

		int min=0;
		int max = 0;
		
//		Calculate min and max of the array
		for(int w: weights) {
			min = Math.max(w, min);
			max += w;
		}
		
//		Lets try binary search and find out the exact min limit
		int ans = 0;
		while(min<=max) {
			
			int mid = (min+max)/2;
			
			int daysRequired = calculateDaysRequired(weights, mid);
			
			if(daysRequired>D) {
				min = mid+1;
				
			}else {
				ans = mid;
				max = mid-1;
			}
		}
		return ans;
	}
	
	/**
	 * Calculate days required
	 * @param weights
	 * @param capacity
	 * @return
	 */
	private int calculateDaysRequired(int[] weights, int capacity) {
		
		int daysRequired = 1;
		
		int sum = 0;
		for(int w:weights) {
			sum += w;
			
			if(sum>capacity) {
				daysRequired++;
				sum = w;
			}
			
		}
		return daysRequired;
	}
}
