package com.test.leetcode.medium.locked;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/meeting-scheduler/
 * 
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 *
 */
public class MeetingScheduler {

	public static void main(String[] args) {
		
		MeetingScheduler obj = new MeetingScheduler();
		int[][] slots1 = new int[][] {{10,50},{60,120},{140,210}};
		int[][] slots2 = new int[][] {{0,15},{60,70}};
		int duration = 8;
		System.out.println(obj.minAvailableDuration(slots1, slots2, duration));

	}

	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

		Arrays.sort(slots1, (a,b)-> a[0]-b[0]);
		Arrays.sort(slots2, (a,b)-> a[0]-b[0]);
		
		int i=0;
		int j=0;
		
		while(i<slots1.length && j<slots2.length) {
//			if(slots1[i][0]< slots2[j][1] && slots1[i][1]>slots2[j][0]) {
			if(slots1[i][1]>slots2[j][0]) {
				
				int start = Math.max(slots1[i][0], slots2[j][0]);
				int end = Math.min(slots1[i][1], slots2[j][1]);
				
				if(end-start>=duration)
					return Arrays.asList(start, start+duration);
				
			}
			if(slots1[i][0]< slots2[j][0]) {
				i++;
			}else
				j++;
		}
		
		return null;
	}
}
