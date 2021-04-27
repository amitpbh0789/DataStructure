package com.test.leetcode.medium;

/**
 * 
 * https://leetcode.com/problems/unique-paths/
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * 
 * Time: O(m*n)
 * Space: O(m*n)
 * 
 * @author amit
 *
 */
public class UniquePaths {

	public static void main(String[] args) {

		UniquePaths obj = new UniquePaths();
		int m = 7;
		int n = 3;
		
		System.out.println(obj.uniquePaths(m, n));
	}

	public int uniquePaths(int m, int n) {

		if(m==0 || n==0)
			return 0;
		
//      Create array to conatin all the ways at each index
		int[][] dp = new int[m][n];
		
//      Initialize if goes down
		for(int i=0; i<m; i++)
			dp[i][0] = 1;
		
//      Initialize if goes right
		for(int j=0; j<n; j++)
			dp[0][j] = 1;
		
//      All other position can be reached either by left or top. Fill up all the locations.
		for(int i=1; i<m; i++)
			for(int j=1; j<n; j++)
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			
//		Return the value at last index of m*n
		return dp[m-1][n-1];
	}
}
