package com.test.algorithm.mathematical;

/**
 * https://www.geeksforgeeks.org/c-program-find-gcd-hcf-two-numbers/
 * 
 * @author amit
 *
 */
public class FindGCD {

	public static void main(String[] args) {
		int a = 20;
		int b = 28;
		FindGCD obj = new FindGCD();
		System.out.println(obj.findGCD(a, b));
		System.out.println(obj.findGCDMath(a, b));
		
		System.out.println("find GCD or HCF of an Array");
		int[] arr = new int[] {2, 4, 6, 8};
		System.out.println(obj.findGCDOfArray(arr));
	}
	
	/**
	 * @Simple way 
	 * @param a
	 * @param b
	 * @return
	 */
	public int findGCD(int a, int b) {
		
		if(a==0)
			return b;
		if(b==0)
			return a;
		if(a==b)
			return a;
		
		if(a>b)
			return findGCD(a-b, b);
		return findGCD(a, b-a);
	}
	
	/**
	 * @Desc Mathematical way
	 * @param a
	 * @param b
	 * @return
	 */
	public int findGCDMath(int a, int b) {
		if(b==0)
			return a;
		return findGCDMath(b, a%b);
	}
	
	public int findGCDOfArray(int[] arr) {
		int result = 0;
		
		for(int i=0; i<arr.length; i++) {
			result = findGCDMath(result, arr[i]);
			if(result ==1)
				return result;
		}
		return result;
	}
}
