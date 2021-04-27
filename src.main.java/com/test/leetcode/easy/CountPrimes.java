package com.test.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-primes/
 * 
 * @author amit
 *
 */
public class CountPrimes {

	public static void main(String[] args) {

		CountPrimes obj = new CountPrimes();
		System.out.println(obj.countPrimes(10));
	}

	public int countPrimes(int n) {
		
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		
		for(int i=2; i*i<primes.length; i++) {
			
			if(primes[i]) {
				for(int j=i; i*j<primes.length; j++) {
					primes[i*j] = false;
				}
			}
		}
		
		int count = 0;
		
		for(int i=2; i<primes.length; i++) {
			if(primes[i])
				count++;
		}
		return count;
	}
}
