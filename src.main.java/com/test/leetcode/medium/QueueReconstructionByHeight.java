package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

	public static void main(String[] args) {
		QueueReconstructionByHeight obj = new QueueReconstructionByHeight();
		int[][] people = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] res = obj.reconstructQueue(people);
		System.out.println();
	}
	
	public int[][] reconstructQueue(int[][] people) {
	     
//      height same : asc order based on k
//      if hieght not same : desc order based on height
     Arrays.sort(people, (o1, o2)->o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]); // O(NLogN) primitive sorting will use merge sort
     
     List<int[]> list = new ArrayList<>(); //storeing each element in the list - Space -> O(N)
     for(int[] p : people){ //Looping through each entry of people array so time -> O(N)
         list.add(p[1], p);
     }
     
     return list.toArray(new int[list.size()][]);
 }
}
