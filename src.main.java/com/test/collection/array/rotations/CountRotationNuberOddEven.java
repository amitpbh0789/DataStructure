package com.test.collection.array.rotations;

/**
 * 
 * Given a number n, the task is to count all odd and even numbers
 * @author amit
 *
 */
public class CountRotationNuberOddEven {

	public static void main(String[] args) {
		int number = 24797;
		countWithoutRotation(number);
	}

	/**
	 * In this approach, no need to rotate just find out the last digit and check if its odd or even
	 * @param number
	 */
	private static void countWithoutRotation(int number) {

		int odd=0, even =0;
		do {
			int digit = number%10;
			if(digit%2 ==1) {
				odd = odd+1;
			} else {
				even = even+1;
			}
			number = number/10;
		}while(number !=0);


		System.out.println("odd number "+odd);
		System.out.println("even numbers count "+even);
		
	}
}
