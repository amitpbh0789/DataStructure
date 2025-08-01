package com.test.leetcode.medium.locked.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Merge two sorted (ascending) lists of interval and return it as a new sorted list. 
 * The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.
 * 
 * The intervals in the given list do not overlap.
 * The intervals in different lists may overlap
 */
public class MergeTwoIntervalLists {
	
	public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> results = new ArrayList<>();

		int i=0; 
		int j=0;
		while(i<list1.size() && j<list2.size()){
			if(list1.get(i).start <= list2.get(j).start) {
				merge(results, list1.get(i++));
			} else {
				merge(results, list2.get(j++));
			}
		}
		
		while(i<list1.size()) {
			merge(results, list1.get(i++));
		}
		while(j<list2.size()) {
			merge(results, list2.get(j++));
		}
		
		return results;
	}
	
	
	private void merge(List<Interval> mergedList, Interval curr) {
		if(mergedList.size() == 0) {
			mergedList.add(curr);
			return;
		}
		
		Interval prev = mergedList.get(mergedList.size()-1);
		
		if(prev.end < curr.start) {
			mergedList.add(curr);
		} else {
			prev.end = Math.max(prev.end, curr.end);
		}
	}
	

}


class Interval{
	int start;
	int end;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}