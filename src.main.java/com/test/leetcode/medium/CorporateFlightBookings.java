package com.test.leetcode.medium;

/**
 * 
 * Solution2: based on populating starting positio. Similar to taxi probelm

Time: O(N)
Space: O(N)

 */
public class CorporateFlightBookings {

	public static void main(String[] args) {
		
		CorporateFlightBookings obj = new CorporateFlightBookings();
		int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
		int n = 5;
		int[] res = obj.corpFlightBookings(bookings, n);
		
		for(int i : res)
			System.out.println(i);
	}
	
	/**
	 * Idea: Since ranges are continuous, what if we add reservations to the first flight in the range, 
	 * and remove them after the last flight in range? 
	 * Then use the running sum to update reservations for all flights.
	 */
	public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        
        for(int[] booking : bookings){
            result[booking[0]-1] += booking[2]; // keep track of starting booking
            if(booking[1]< n){
                result[booking[1]] -= booking[2]; // if not yet reached at final destination then no need to add destination bookings. coz later we will add everythig
            }
        }
        
        for(int i=1; i<n; i++){
            result[i] += result[i-1];
        }
        return result;
    }
}
