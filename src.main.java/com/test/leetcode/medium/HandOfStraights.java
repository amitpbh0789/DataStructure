package com.test.leetcode.medium;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/hand-of-straights/
 *
 */
public class HandOfStraights {

	public static void main(String[] args) {
		HandOfStraights obj = new HandOfStraights();
		int[] hand = new int[] {1,2,3,6,2,3,4,7,8};
		int W = 3;
		System.out.println(obj.isNStraightHand(hand, W));
	}
	
	public boolean isNStraightHand(int[] hand, int W) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i : hand){
            treeMap.put(i, treeMap.getOrDefault(i,0)+1);
        }
        
        while(treeMap.size()>0){
            int first = treeMap.firstKey();
            
            for(int card=first; card<first+W; card++){
                if(!treeMap.containsKey(card)){
                    return false;
                }
                int count = treeMap.get(card);
                if(count==1)
                    treeMap.remove(card);
                else
                	treeMap.replace(card, count-1);
            }
        }
        return true;
    }
}
