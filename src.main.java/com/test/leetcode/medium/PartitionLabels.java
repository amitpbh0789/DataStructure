package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 * 
 * @author amit
 *
 */
public class PartitionLabels {

	public static void main(String[] args) {
		PartitionLabels obj = new PartitionLabels();
		String s = "ababcbacadefegdehijhklij";
		obj.partitionLabels(s);
	}

	public List<Integer> partitionLabels(String s) {

		List<Integer> list = new ArrayList<>();
		
		char[] arr = s.toCharArray();
		int[] position = new int[26];
//		Capture last position of each character
		for(int i=0; i<arr.length; i++) {
			position[arr[i]-'a'] = i; //It will override and keep the updated latest index of the char
		}
		
		int last = 0;
		int start = 0;
		
		for(int i=0; i<arr.length; i++) {
			
//			Keep on going until you get last index of character
			last = Math.max(last, position[arr[i]-'a']);
//		Once last index found, add length in the list and move the start pointer to next index
			if(last == i) {
				list.add(last-start + 1);
				start = last+1;
			}
			
		}
		
		return list;
	}
}
