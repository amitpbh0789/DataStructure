package com.test.leetcode.medium.locked.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-distinct-islands/description/
 * 
 * Capture direction of movement of each island and store in set. 
 * When same direction found again, it will be ignored while adding into set
 * return the size of the set of unique island
 * 
 * Corner case for below case: Whenever perform backtrack, add dir as '0' to uniquely identiy the islands
 * 
 * &&&      VS &&&
 * 	&            &
 * 
 */

public class NumberOfUniqueIslands {
	
	public static void main(String[] args) {
		NumberOfUniqueIslands obj = new NumberOfUniqueIslands();
		int[][] grid = new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println("Unique Islands are--> "+obj.numDistinctIslands(grid));
	}

	public int numDistinctIslands(int[][] grid) {
		Set<String> uniqueIslands = new HashSet<>();
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				
				StringBuilder sb = new StringBuilder();
				dfs(grid, i, j, '0', sb);
				
				if(sb.length() >0) {
					uniqueIslands.add(sb.toString());
				}
			}
		}
		
		return uniqueIslands.size();
	}
	
	private void dfs(int[][] grid, int row, int col, char dir, StringBuilder sb) {
		if(row<0 || col <0 || row>=grid.length || col >= grid[0].length || grid[row][col] == 0) {
			return;
		}
		
		// Make current cell 0 that can denote visited
		grid[row][col] = 0;
		// append the direction
		sb.append(dir);
		
		
		dfs(grid, row+1, col, 'D', sb);
		dfs(grid, row-1, col, 'U', sb);
		dfs(grid, row, col+1, 'R', sb);
		dfs(grid, row, col-1, 'L', sb);
		
		sb.append('0'); // backtrack
		
	}

}
