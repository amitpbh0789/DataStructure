package com.test.leetcode.medium;

/**
 * 
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * @author amit
 *
 */
public class UniquePathsII {

	public static void main(String[] args) {

		UniquePathsII obj = new UniquePathsII();
		int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
		System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		
		if(row == 0 || column == 0)
			return 0;
		
		int[][] dp = new int[row][column];
		
//		Check if given array has obstacle in each row of first column. If yes, then fill dp array with 0 else 1
		for(int i=0; i<row; i++) {
			if(obstacleGrid[i][0] != 1 )
				dp[i][0] = 1;
			else
				dp[i][0] = 0;
		}

//		Check if given array has obstacle in each column of first row. If yes, then fill dp array with 0 else 1
		for(int j=0; j<column; j++) {
			if(obstacleGrid[0][j] != 1 )
				dp[0][j] = 1;
			else
				dp[0][j] = 0;
				
		}
		
//		If current, prev or both has value 1 then ignore else keep on adding as unique path;
		for(int i=1; i<row; i++) {
			for(int j=1; j<column; j++) {
				
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[row-1][column-1];
	}
}
