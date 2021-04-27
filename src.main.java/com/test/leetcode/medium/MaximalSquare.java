package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/maximal-square/
 * 
 * @author amit
 *
 */
public class MaximalSquare {

	public static void main(String[] args) {

		char[][] matrix = {};
		MaximalSquare obj = new MaximalSquare();
		System.out.println(obj.maximalSquare(matrix));
	}

	public int maximalSquare(char[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		
		int max = 0;
		
//		Populate DP array for all the rows with first column
		for(int i=0; i<rows; i++) {
			dp[i][0] = matrix[i][0] == '0' ? 0:1;
			max = Math.max(max, dp[i][0]);
		}
//		Populate DP array for all the columns with first row		
		for(int i=0; i<cols; i++) {
			dp[0][i] = matrix[0][i] == '0'? 0:1;
			max = Math.max(max, dp[0][i]);
		}
		
//		Now fill other position with the help of pre-populate dp array value
		for(int i=1; i<rows; i++) {
			for(int j=1; j<cols; j++) {
				
				if(matrix[i][j] == '1') {
//					It will take min value from above, left and dia positions + 1(coz position value is 1)
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max*max;
	}
}
