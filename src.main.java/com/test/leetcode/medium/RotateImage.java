package com.test.leetcode.medium;

/**
 * 
 * https://leetcode.com/problems/rotate-image/
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3


 * @author amit
 *
 */
public class RotateImage {

	public static void main(String[] args) {

		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		RotateImage obj = new RotateImage();
		obj.rotate(matrix);
		System.out.println("generated");
	}

	public void rotate(int[][] matrix) {

		int left =0;
		int right = matrix.length-1;
		
		while(left<right) {
			int[] temp = matrix[left];
			matrix[left] = matrix[right];
			matrix[right] = temp;
			left++;
			right--;
		}
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=i+1; j<matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
	}
}
