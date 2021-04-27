package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * @author amit
 *
 */
public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//		int[][] intervals = {{1,4},{0,0}};
		int[][] result = merge(intervals);
		System.out.println();
	}
	private static int[][] merge(int[][] intervals) {
		
		if(intervals.length==0)
			return null;
		
		Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
		
		List<Integer[]> result = new ArrayList<>();
		result.add(new Integer[] {intervals[0][0], intervals[0][1]});
		
		
		for(int i=1; i<intervals.length; i++) {
			int[] current = intervals[i];
			Integer[] prev = null;
			while(result.size()>0 && current[0]<=result.get(result.size()-1)[1]) {
				prev = result.get(result.size()-1);
				result.remove(result.size()-1);
			}
			
			if(prev != null) {
				result.add(new Integer[] {Math.min(prev[0], current[0]), Math.max(prev[1], current[1])});
			}else {
				result.add(new Integer[] {current[0], current[1]});
			}
			
		}
		
		int[][] resp = new int[result.size()][2];
		for(int i=0;i<result.size();i++){
            for(int j=0;j<2;j++){
            	resp[i][j] = result.get(i)[j];
            }
        }
		
		return resp;
	}
}
