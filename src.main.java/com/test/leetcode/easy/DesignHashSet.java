package com.test.leetcode.easy;

import java.util.ArrayList;

public class DesignHashSet {

	ArrayList<Integer> list = null;
	/** Initialize your data structure here. */
    public DesignHashSet() {
    	list = new ArrayList<>();
    }
    
    public void add(int key) {
    	boolean contains = list.contains(key);
    	if(!contains) {
    		list.add(key);
    	}
    }
    
    public void remove(int key) {
    	boolean contains = list.contains(key);
    	if(contains) {
    		list.remove(list.indexOf(key));
    	}
       
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }
    
    public static void main(String[] args) {
    	DesignHashSet hashSet = new DesignHashSet();
    	hashSet.add(1);
    	hashSet.add(2);
    	System.out.println(hashSet.contains(1));    // returns true
    	System.out.println(hashSet.contains(3));    // returns false (not found)
    	hashSet.add(2);
    	System.out.println(hashSet.contains(2));    // returns true
    	hashSet.remove(2);   
    	System.out.println(hashSet.contains(2));    // returns false (already removed)
	}
}
