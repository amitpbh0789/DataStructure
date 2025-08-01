package com.test.leetcode.medium.locked;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
The depth of an integer is the number of lists that it is inside of. 

For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.

Return the sum of each integer in nestedList multiplied by its depth.

Example 1:

Input: nestedList = [[1,1],2,[1,1]]
Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.

Example 2:
Input: nestedList = [1,[4,[6]]]
Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.

Time: O(N), N the number of nested list of the input list
Space: O(n) queue
 */
public class NestedListWeightSum_339 {

	public static void main(String[] args) {
		
	}
	
	public int depthSum(List<NestedInteger> nestedList) {
//        return dfs(nestedList, 1);
		return bfsSolution(nestedList, 1);

    }
	
	// DFS Solution
	public int dfsSolution(List<NestedInteger> nestedList, int depth) {
		
		int count = 0;
		
		for(NestedInteger nested : nestedList) {
			if(nested.isInteger()) {
				count = count + (nested.getInteger()*depth);
			} else {
				count = count + dfsSolution(nested.getList(), depth + 1);
			}
		}
		
		return count;
		
	}
	
	// BFS Solution
	// Time: O(N), N the number of nested list of the input list
	// Space: O(n) queue
	public int bfsSolution(List<NestedInteger> nestedList, int depth) {
		int count = 0;
		Queue<NestedInteger> queue = new LinkedList<>();
		queue.addAll(nestedList);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				NestedInteger nested = queue.poll();
				
				// If its number
				if(nested.isInteger()) {
					count = count + nested.getInteger() * depth;
				} // if its List 
				else {
					queue.addAll(nested.getList());
				}
			}
			depth++;
		}
		
		return count;
	}
	
	public interface NestedInteger {
	      // Constructor initializes an empty nested list.
	      public NestedInteger();
	 
	      // Constructor initializes a single integer.
	      public NestedInteger(int value);
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // Set this NestedInteger to hold a single integer.
	      public void setInteger(int value);
	 
	      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	      public void add(NestedInteger ni);
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return empty list if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }
}



