package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/permutation-sequence/
 * 
 * @author amit
 *
 */
public class PermutationSequence {

	public static void main(String[] args) {

		PermutationSequence obj = new PermutationSequence();
		int n = 8;
		int k = 1047;
		System.out.println(obj.getPermutation(n, k));
	}

	public String getPermutation(int n, int k) {

		if(n<1 || k<1)
			return "";
		
		List<List<Integer>> collection = new LinkedList<>();
		boolean[] visited = new boolean[n];
		List<Integer> permutation = new ArrayList<Integer>();
		
		getPermutations(collection, visited, n, permutation, k);
		
		StringBuilder res = new StringBuilder();
		
		collection.get(k-1).forEach(e -> {
			res.append(e);
		});
		
		return res.toString();
				
	}
	
	private void getPermutations(List<List<Integer>> collection, boolean[] visited, int n, List<Integer> permutation, int k) {
		
		if(permutation.size()==n) {
			collection.add(new ArrayList<>(permutation));
			return;
		}
		
		for(int i=1; i<=n; i++) {
//			Break if it reaches to limit. No point of getting all the permutations
			if(collection.size()==k) {
				return;
			}
			
			if(!visited[i-1]) {
				
				visited[i-1] = true;
				permutation.add(i);
				getPermutations(collection, visited, n, permutation, k);
				permutation.remove(permutation.size()-1);
				visited[i-1] = false;
			}
		}
	}
}
