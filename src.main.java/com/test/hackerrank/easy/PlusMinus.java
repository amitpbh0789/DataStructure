package com.test.hackerrank.easy;

/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 * @author amit
 *
 */
public class PlusMinus {

	public static void main(String[] args) {
		int[] arr = new int[] {1,1,0,-1,-1};
		calculatePlusMinus(arr);
	}

	public static void calculatePlusMinus(int[] arr) {
		double zero = 0;
		double pos = 0;
		double neg = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) {
				zero++;
			}else if(arr[i]>0) {
				pos++;
			}else {
				neg++;
			}
		}
		int n = arr.length;
		System.out.println(pos/n);
		System.out.println(neg/n);
		System.out.println(zero/n);
	}
}
