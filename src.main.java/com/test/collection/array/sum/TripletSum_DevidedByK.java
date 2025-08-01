package com.test.collection.array.sum;

public class TripletSum_DevidedByK {

	public static void main(String[] args) {
		int[] arr = new int[] {3,3,4,7,8};
		TripletSum_DevidedByK obj = new TripletSum_DevidedByK();
		System.out.println(obj.calculateTripletSum(arr, 7));
	}
	
	private int calculateTripletSum(int[] arr, int d) {
		
		int count=0;
		
		for(int i=0; i<arr.length-2; i++) {
			for(int j = i+1; j<arr.length-1; j++) {
				for(int k =j+1; k<arr.length; k++){
					if((arr[i] + arr[j] + arr[k]) %d == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
