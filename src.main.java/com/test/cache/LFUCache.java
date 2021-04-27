package com.test.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/lfu-cache/
 * 
 * Time: O(LogN)
 * 
 * Check Leetcode
 *
 */
public class LFUCache {

	Map<Integer, ListNode> map = new HashMap<>();
    PriorityQueue<ListNode> pq = null;
    int capacity;
    int size;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        pq = new PriorityQueue<ListNode>((p1, p2)-> p1.frequency==p2.frequency? p1.frequency-p2.frequency : p1.value-p2.value);
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){
        	ListNode node = map.get(key);
            remove(node);
            add(new ListNode(node.key, node.value, node.frequency+1));
            return node.value;
        }else 
            return -1;
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key)) {
        	ListNode node = map.get(key);
            remove(node);
            add(new ListNode(key, value, node.frequency+1));
        } else {
            if (capacity!=0) {
                if (map.size()==capacity) 
                    remove(pq.peek());
                add(new ListNode(key, value, 1));
            }
        }
        
    }
    
    private void remove(ListNode node) {
        map.remove(node.key);
        pq.remove(node);
    }
    private void add(ListNode node) {
        map.put(node.key, node);
        pq.offer(node);
    }
}

class ListNode{
	int key;
    int value;
    int frequency;
    public ListNode(int key, int value, int frequency){
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
}
