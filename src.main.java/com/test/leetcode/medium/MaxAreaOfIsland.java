package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * 
 * https://www.youtube.com/watch?v=W8VuDt0eb5c
 * 
 * @author amit
 *
 */
public class MaxAreaOfIsland {

	public static void main(String[] args) {

		MaxAreaOfIsland obj = new MaxAreaOfIsland();
		int[][] grid = {
				 {0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}
				 };
		System.out.println(obj.maxAreaOfIsland(grid));
	}

	public int maxAreaOfIsland(int[][] grid) {

		int max = 0;

		if(grid == null || grid.length == 0)
			return max;

//		Iterate and find out the island first, once island is found check the neighbor 
//		by calling dfs and find max between existing and new max
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){

				if(grid[i][j] == 1){
					max = Math.max(max, dfs(grid, i, j));    
				}
			}
		}
		return max;
	}

	private int dfs(int[][] grid, int i, int j){

//		Boundary check, should not go out of limit in left, right, top and down and cell value
//		is not 1 then return 0
		if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] != 1){
			return 0;
		}

//		Since cell value is 1 assign to max and make cell 0 so that next
//		time this cell doesnt get visited again.
		int max = 1;
		grid[i][j] = 0;

		max += dfs(grid, i+1, j);
		max += dfs(grid, i-1, j);
		max += dfs(grid,i, j+1);
		max += dfs(grid,i, j-1);

		return max;

	}
}
