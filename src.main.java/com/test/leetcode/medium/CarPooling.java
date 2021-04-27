package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/car-pooling/
 * 
 * Constraints:
 * trips.length <= 1000
 * 
 * @author amit
 *
 */
public class CarPooling {

	public static void main(String[] args) {

		CarPooling obj = new CarPooling();
		int[][] trips = {{2,1,5}, {3,3,7}};
		int capacity = 5;
		System.out.println(obj.carPooling(trips, capacity));
	}

	public boolean carPooling(int[][] trips, int capacity) {

		int[] stops = new int[10001];
		
		for(int[] trip : trips) {
			
			for(int j=trip[1]; j<trip[2]; j++) {
				
				stops[j] = stops[j]+trip[0];
				
			}
		}
		
		for(int i : stops) {
			if(i>capacity)
				return false;
		}
		return true;
	}
	
	
	public boolean carPooling2(int[][] trips, int capacity) {
		
		int[] timestamp = new int[1001];
		
		for(int i=0; i<trips.length; i++) {
			timestamp[trips[i][1]] += trips[i][0];
			timestamp[trips[i][2]] -= trips[i][0];
		}
		
		int usedCapacity=0;
		for(int time : timestamp) {
			usedCapacity += time;
			if(usedCapacity>capacity)
				return false;
		}
		return true;
	}
	
}
