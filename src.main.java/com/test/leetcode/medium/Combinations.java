package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * 
 * @author amit
 *
 */
public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations obj = new Combinations();
		System.out.println(obj.combine(5,3));

	}

	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if(n==0)
			return res;

		List<Integer> combination = new ArrayList<>();

		getCombinations(res, combination, 1, n, k);

		return res;
	}

	private void getCombinations(List<List<Integer>> res, List<Integer> combination, int start, int n, int k) {

		if(k==0) {
			res.add(new ArrayList<>(combination));
			return;
		}

		for(int i=start; i<=n; i++) {

			combination.add(i);
			getCombinations(res, combination, i+1, n, k-1);
			combination.remove(combination.size()-1);

		}
	}


}