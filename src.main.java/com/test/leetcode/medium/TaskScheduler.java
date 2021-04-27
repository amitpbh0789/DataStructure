package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * /*
 * 
 * https://leetcode.com/problems/task-scheduler/

["A","A","A","B","B","B"], n = 2

char map [3,3,0,0,0,0,0,0,.....0]
after sort [0,0,0,0,0,0,.....,3,3]
max = 3-1 =2
idle_Slots = 2*2 = 4

return remaining ideal_Slot = 2 and length =6
2+6 = 8

*/
public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};
		int n = 2;
		TaskScheduler obj = new TaskScheduler();
		System.out.println(obj.leastInterval(tasks, n));
	}

	public int leastInterval(char[] tasks, int n) {

		int[] freq = new int[26];
		//         Iterate each task and place the frequency of each char
		for(char c: tasks){
			freq[c-'A']++;
		}
		Arrays.sort(freq);
		//         Find max count.. Greedy approach
		int max = freq[25]-1;
		int idle_Slots = max*n; //Idle slot between interval of same character

		//         Now iterate through frequency and fillup the idleslots
		for(int i=24; i>=0; i--){
			idle_Slots -= Math.min(freq[i], max);
		}

		//         If idle_slots are still remaining then add into task else return task's length
		return idle_Slots>0 ? idle_Slots+tasks.length :  tasks.length;
	}
}