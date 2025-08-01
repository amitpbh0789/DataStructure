package com.test.leetcode.hard;

public class LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		LongestIncreasingPathInAMatrix obj = new LongestIncreasingPathInAMatrix();
		int[][] matrix = new int[][] {{9,9,4},{6,6,8},{2,1,1}};
		System.out.println(obj.longestIncreasingPath(matrix));

	}
	
	public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int logenstpath = Integer.MIN_VALUE;

        for(int i=0; i<row; i++){
            for(int j =0; j<col; j++){
                logenstpath = Math.max(logenstpath, calculateLongestPathForIndex(matrix, dp, i, j, -1));
            }
        }
        return logenstpath;
    }

    private int calculateLongestPathForIndex(int[][] matrix, int[][] dp, int row, int col, int prevVal){

        if(row<0 || row>=matrix.length || col<0 || col>=matrix[0].length || matrix[row][col] <= prevVal){
            return 0;
        }

        if(dp[row][col] != 0){
            return dp[row][col];
        }
        int curr = matrix[row][col];
        int res = 1;
        res = Math.max(res, 1 + calculateLongestPathForIndex(matrix, dp, row+1, col, curr));
        res = Math.max(res, 1 + calculateLongestPathForIndex(matrix, dp, row-1, col, curr));
        res = Math.max(res, 1 + calculateLongestPathForIndex(matrix, dp, row, col+1, curr));
        res = Math.max(res, 1 + calculateLongestPathForIndex(matrix, dp, row, col-1, curr));

        dp[row][col] = res;
        return res;
    }

}
