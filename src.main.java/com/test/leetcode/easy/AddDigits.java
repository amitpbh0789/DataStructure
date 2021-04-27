package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/add-digits/
 * 
 * @author amit
 *
 */
public class AddDigits {

	public static void main(String[] args) {

		AddDigits obj = new AddDigits();
		int num = 517;
		System.out.println(obj.addDigits(num));
	}

	public int addDigits(int num) {

		if(num == 0)
			return 0;

		while(num>=10){
			int sum = 0;
			while(num != 0){
				int lastDigit = num%10;
				sum = sum + lastDigit;
				num = num/10;
			}
			num = sum;
		}
		return num;
	}
}
