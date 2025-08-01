package com.test.algorithm.mathematical;

public class SwapWithoutTempVariable {
	
	public static void main(String[] args) {
		int a = 10; // 
		int b = 5; //
		SwapWithoutTempVariable obj = new SwapWithoutTempVariable();
		int[] arr = obj.swapWithBitWise(a, b);
		System.out.println("a: "+arr[0] +" b: "+ arr[1]);
		
	}
	
	private int[] swapWithBitWise(int a, int b) {
		a = a^b;
		b = a^b;
		a = a^b;
		return new int[] {a, b};
	}

}
