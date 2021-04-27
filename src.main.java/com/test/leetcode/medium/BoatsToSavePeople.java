package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/boats-to-save-people/
 * Input: people = [1,2], limit = 3
	Output: 1
	Explanation: 1 boat (1, 2)

 * @author amit
 *
 */
public class BoatsToSavePeople {

	public static void main(String[] args) {
		int[] people = new int[] {5,1,4,2};
		int limit = 6;
		BoatsToSavePeople obj = new BoatsToSavePeople();
		System.out.println(obj.numRescueBoats(people, limit));

	}

	public int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);

		int i=0;
		int j= people.length-1;
		int ans = 0;

		while(i<=j){
			ans++;
			if(people[i]+people[j]<=limit){
				i++;
			}
			j--;
		}
		
		return ans; 
	}
}
