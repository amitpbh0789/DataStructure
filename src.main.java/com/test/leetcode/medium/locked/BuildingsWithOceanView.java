package com.test.leetcode.medium.locked;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.ca/2021-04-14-1762-Buildings-With-an-Ocean-View/
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. 
Formally, a building has an ocean view if all the buildings to its right have a smaller height.

 */
public class BuildingsWithOceanView {
	
	public static void main(String[] args) {
		int[] heights = new int[] {4,2,3,1};
		int[] res = BuildingsWithOceanView.findBuildings(heights);
		for(int i : res) {
			System.out.println(i);
		}
		
	}
	
	private static int[] findBuildings(int[] heights){
		
		int max = 0;
		List<Integer> list = new ArrayList<>();
		
		for(int i=heights.length-1; i>=0; i--) {
			if(heights[i]>max) {
				list.add(0, i);
				max = heights[i];
			}
		}
		
		return list.stream().mapToInt(i->i).toArray();
	}

}
