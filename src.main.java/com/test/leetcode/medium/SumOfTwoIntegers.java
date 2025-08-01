package com.test.leetcode.medium;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		SumOfTwoIntegers obj = new SumOfTwoIntegers();
		obj.getSum(1, 2);

	}
	
	public int getSum(int x, int y) {
        if(y==0) {
			return x;
		}else {
            // First, we can use "and"("&") operation between a and b to find a carry.
            // we can use "xor" ("^") operation between x and y to find the different bit
			return getSum(x^y, (x&y)<<1);
		}
    }

}
