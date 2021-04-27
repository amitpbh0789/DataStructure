package com.test.hackerrank.easy;
import java.util.Arrays;

public class MinimumSwaps2 {

	public static void main(String[] args) {

		int[] arr = new int[] {2, 3, 4, 1, 5};
		System.out.println(minimumSwaps(arr));
	}

	/**
	 * @Desc: Create temp array and sort it
	 * compare sorted array with original array
	 * if diff found, increase the swap counter and loop through array strating from i 
	 * and find out the actual element as per sorted Array
	 * Now swap the elements
	 * Repeat above steps
	 * 
	 */
	static int minimumSwaps(int[] arr) {
		int[] temp = arr.clone();
		Arrays.sort(temp);
		int count =0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] != temp[i]){
				count++;
				int j = i;
				while(j<arr.length){
					if(arr[j] == temp[i]){
						int curr = arr[j];
						arr[j] = arr[i];
						arr[i] = curr;
						break;
					}
					j++;
				}
			}
		}
		return count;
	}
}
