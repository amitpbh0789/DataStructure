package com.test.leetcode.medium;

/**
 * 
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * The idea is that we can use the first cell of every row and column as a flag. 
 * This flag would determine whether a row or column has been set to zero. 
 * This means for every cell instead of going to M+NM+N cells and setting it to zero 
 * we just set the flag in two cells.
 * 
 * These flags are used later to update the matrix. If the first cell of a row is set to zero 
 * this means the row should be marked zero. If the first cell of a column is set to zero this 
 * means the column should be marked zero.
 * 
 * 
 * @author amit
 *
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {

		SetMatrixZeroes obj = new SetMatrixZeroes();
		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
		obj.setZeroes(matrix);
		for(int[] row : matrix) {
			System.out.println(row[0] +" "+ row[1] +" "+ row[2]);
		}

	}

	public void setZeroes(int[][] matrix) {

		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean firstColumnZero = false;
		boolean firstRowZero = false;
		
//		Check if first column has any pre-zero
		for(int i=0; i<m; i++) {
			if(matrix[i][0] == 0) {
				firstColumnZero = true;
				break;
			}
				
		}
		
//		Check if first row has any pre-zero
		for(int j=0; j<n; j++) {
			if(matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			}
				
		}
		
//		Now iterate over matrix and mark all the 0's but making corresponding first column and first row as 0
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
					
			}
		}
		
		
//		Now iterate and check if first column or first row is 0. If yes then populate matrix[i][j]=0
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++)
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
		}
		
//		Now finally check if first column has 0 initially then make full column 0
		if(firstColumnZero) {
			for(int i=0; i<m; i++)
				matrix[i][0] = 0;
		}
		
//		Now check if first row has 0 initially then make full row 0
		if(firstRowZero) {
			for(int j=0; j<n; j++)
				matrix[0][j] = 0;
		}
		
	}
}

