package com.test.collection.array.rotations;

/**
 * Generate all rotations of a number
 * 
 * https://www.geeksforgeeks.org/generate-all-rotations-of-a-number/
 * Given an integer n, the task is to generate all the left shift numbers possible. 
 * A left shift number is a number that is generated when all the digits of the number 
 * are shifted one position to the left and the digit at the first position is shifted to the last.
 * 
 * Approach:
	Assume n = 123.
	Multiply n with 10 i.e. n = n * 10 = 1230.
	Add the first digit to the resultant number i.e. 1230 + 1 = 1231.
	Subtract (first digit) * 10k from the resultant number where k is the number of digits in the original number (in this case, k = 3).
	1231 – 1000 = 231 is the left shift number of the original number.
 * 
 * Formula: (original number*10 + firstDigit) - (first digit * (digitCount Pow 10))
 * @author amit
 * 
 *
 */
public class PossibleRotationOfANumber {

	public static void main(String[] args) {
		int number = 1234;
		countTheRotation(number);
	}

	private static void countTheRotation(int number) {

		int digit = countTheDigit(number);
		int powTen = (int)(Math.pow(10, digit-1));

		for(int i=0; i<digit; i++) {

			int firstDigit = number/powTen;

			number = (number*10+firstDigit) - (firstDigit*(int)(Math.pow(10, digit)));
			System.out.println(number);
		}
	}


	private static int countTheDigit(int number) {

		int count = 0;
		while(number>0) {
			count++;
			number /= 10;
		}
		return count;
	}

}
