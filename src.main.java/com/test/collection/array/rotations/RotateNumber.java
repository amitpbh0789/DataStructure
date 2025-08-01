package com.test.collection.array.rotations;

/*
 * (original number*10 + firstDigit) - (first digit * (digitCount Pow 10))
 */
public class RotateNumber {

	public static void main(String[] args) {
		int number = 235;
		rotateNumber(number);

	}
	private static void rotateNumber(int number) {

		int digit = countDigit(number);

		int powTen = (int)Math.pow(10, digit-1);

		for(int i=0; i<digit;i++) {

			int firstDigit = number/powTen;

			number = ((number*10)+firstDigit) - ((firstDigit)*(int)(Math.pow(10, digit)));

			System.out.println(number);
		}

	}

	private static int countDigit(int number) {

		int count=0;
		while(number>0) {
			count++;
			number = number/10;

		}
		return count;
	}


}
