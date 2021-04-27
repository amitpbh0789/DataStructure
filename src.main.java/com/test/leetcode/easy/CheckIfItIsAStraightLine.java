package com.test.leetcode.easy;

public class CheckIfItIsAStraightLine {

	public static void main(String[] args) {

		int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		CheckIfItIsAStraightLine obj = new CheckIfItIsAStraightLine();
		System.out.println(obj.checkStraightLine(coordinates));
	}

	public boolean checkStraightLine(int[][] coordinates) {
		if(coordinates == null || coordinates.length<3)
			return false;

		int[] p = coordinates[0];
		int[] q = coordinates[1];

		for(int i=2; i<coordinates.length; i++){

			if((q[0]-p[0])*(q[1]-p[1]) != (coordinates[i][0]-q[0])*(coordinates[i][1]-q[1]))
				return false;
			p = coordinates[i-1];
			q = coordinates[i];
		}
		return true;
	}
}
