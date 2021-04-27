package com.test.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number
 * @author amit
 *
 */
public class HappyNumber {

	public static void main(String[] args) {
		int number = 19;
		boolean resp = isHappy(number);
		if(resp)
			System.out.println(number +" is a happy number!!!");
		else
			System.out.println(number +" is not a happy number!!!");
		
	}
	
	public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int sum = 0;
        while(sum != 1){
            while(n!=0){
                sum += (int)Math.pow(n%10, 2);
                n = n/10;
            }
            if(sum == 1)
                return true;
            if(!visited.add(sum))
				return false;
            n = sum;
            sum = 0;
        }
        return true;
    }
}
