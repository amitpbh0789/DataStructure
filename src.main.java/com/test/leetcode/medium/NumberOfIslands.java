package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/number-of-islands/
 * 
 * https://www.youtube.com/watch?v=o8S2bO3pmO4
 * 
 * @author amit
 *
 */
public class NumberOfIslands {

	public static void main(String[] args) {

		NumberOfIslands obj = new NumberOfIslands();
		char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
		System.out.println(obj.numIslands(grid));
	}

	private int numIslands(char[][] grid) {

		int numsIsland = 0;
		
		if(grid == null || grid.length == 0)
			return numsIsland;
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				
				if(grid[i][j] == '1') {
					numsIsland += dfs(grid, i, j);
				}
			}
		}
		return numsIsland;
		
	}

	private int dfs(char[][] grid, int i, int j) {
		
		if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0')
			return 0;
		
		grid[i][j] = '0';
		
		dfs(grid, i-1, j);
		dfs(grid, i+1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j+1);
		
		return 1;
	}

}
