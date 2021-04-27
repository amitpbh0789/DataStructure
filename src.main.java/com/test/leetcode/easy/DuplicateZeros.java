package com.test.leetcode.easy;

public class DuplicateZeros {

	public static void main(String[] args) {

//		[1,0,2,3,0,4,5,0]
		
//		[1,0,0,2,3,0,0,4][0,0,0]
		
		DuplicateZeros obj = new DuplicateZeros();
		int[] arr = {1,0,2,3,0,4,5,0};
		obj.duplicateZeros(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}
		
	}

	public void duplicateZeros(int[] arr) {

		int couuntZero = 0;

		for(int i=0; i<arr.length; i++){
			if(arr[i] == 0)
				couuntZero++;
		}

		int i = arr.length-1;
		int j = arr.length+couuntZero-1;

		while(i != j) {
			
			insert(arr, i, j--);
			if(arr[i] == 0) {
				insert(arr, i, j--);
			}
			i--;
			
		}
	}
	
	private void insert(int[] arr, int i, int j) {
	
		if(j<arr.length)
			arr[j] = arr[i];
	}
}
