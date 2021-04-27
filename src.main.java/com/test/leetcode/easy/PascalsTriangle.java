package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * @author amit
 *
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		int numRows = 5;
		generate(numRows);
		
		System.out.println("geneated");
	}
	private static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows == 0)
			return result;
		
		List<Integer> prev = new ArrayList<>();
		prev.add(1);
		result.add(prev);
		
		for(int i=2; i<=numRows; i++) {
			List<Integer> current = new ArrayList<>();
			current.add(1);
			for(int j=0; j<prev.size()-1; j++) {
				current.add(prev.get(j)+prev.get(j+1));
			}
			current.add(1);
			result.add(current);
			prev = current;
		}
		return result;
    }
}
