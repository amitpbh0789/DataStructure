package com.test.leetcode.medium.locked;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 *  (si < ei), find the minimum number of conference rooms required.
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * @author amit
 *
 */
public class MeetingRoomsII {

	public static void main(String[] args) {
		int[][] intervals = {{0, 30},{5, 10},{15, 20},{20, 25}};
//		int[][] intervals = {{7,10},{2,4}};
		int result = minMeetingRooms(intervals);
		System.out.println(result);
	}
	private static int minMeetingRooms(int[][] intervals) {
		
		int roomNeeded = 1;
		Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
		for(int i=1; i<intervals.length; i++) {
			
			int[] current = intervals[i];
			if(current != null && current[0]<intervals[i-1][1]) {
				roomNeeded++;
			}
		}
		
		return roomNeeded;
	}
}
