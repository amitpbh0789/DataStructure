package com.test.stack;

/**
 * Similar to Find Town Judge problem in LeetCode
 * @author amit
 *
 */
public class CelebrityProblem2_WithoutStack {

	static int MATRIX[][] = {{0, 0, 1, 0},
			{0, 0, 1, 0 },
			{0, 0, 0, 0},
			{0, 0, 1, 0}}; 
	public static void main(String[] args) {
		
		int row = MATRIX.length;
		int col = MATRIX[0].length;
		
		int[] res = new int[row];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(MATRIX[i][j] == 0)
					res[i]++;
			}
		}
		
		for(int i=0; i<row; i++) {
			if(res[i]==row) {
				System.out.println("celebrity is "+ i);
				break;
			}
				
		}
		
	}
}
