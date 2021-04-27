package com.test.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/fair-candy-swap/
 * 
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that
 *  Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange,
 *  they both have the same total amount of candy.  (The total amount of candy a person has is the sum
 *   of the sizes of candy bars they have.)Return an integer array ans where ans[0] is the size of
 *    the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 * 
 * Example 1:
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * 
 * @author amit
 *
 */
public class FairCandySwap {

	public static void main(String[] args) {
		int[] A = {1,2,5};
		int[] B = {2,4};
		int[] resp = fairCandySwap(A, B);
		System.out.println(resp[0]+" "+resp[1]);
	}
	private static int[] fairCandySwap(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		
		for(int a: A)
			sumA +=a;
		for(int b : B)
			sumB += b;
		
		int med = (sumB - sumA)/2;
		
		Set<Integer> set = new HashSet<>();
		for(int b:B)
			set.add(b);
		
		for(int a:A)
			if(set.contains(med+a))
				return new int[] {a, med+a};
			
		return null;
	}
}
