package com.test.hackerrank.easy;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 *
 */
public class MiniMaxSum {

	public static void main(String[] args) {

		int[] arr = new int[]{1,3,5,7,9};
		miniMaxSum(arr);
	}

	static void miniMaxSum(int[] arr) {

		if(arr == null || arr.length == 0){
			return;
		}
		Arrays.sort(arr);
		int first = arr[0];
		int last = arr[arr.length-1];
		int sum = 0;
		for(int i=1; i<arr.length-1; i++){
			sum += arr[i];
		}

		System.out.println((first+sum) +" "+ (last+sum));
	}
}
