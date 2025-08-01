package com.test.collection.cache;

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

public class LFUCache{
	public static void main(String[] args) {
		MyLFUCache obj = new MyLFUCache(3);
		obj.put(1, 100);
		obj.put(2, 200);
		obj.put(3, 300);
		obj.put(4, 400);
		obj.put(5, 500);
		System.out.println(obj.get(1));
	}
}
class MyLFUCache {

    int capacity; // Initial Capacity
    Map<Integer,LFUNode> map; // For Actual cache
    PriorityQueue<LFUNode> pq; // To manage Frequency of uses

    public MyLFUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<Integer,LFUNode>();
        pq=new PriorityQueue<LFUNode>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	LFUNode node=map.get(key);
            node.frequency = node.frequency+1;
            node.ltime=java.time.LocalTime.now();
            pq.remove(node);
            pq.add(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
        	LFUNode node=map.get(key);
            node.frequency = node.frequency+1;
            node.ltime=java.time.LocalTime.now();
            node.value=value;
            pq.remove(node);
            pq.add(node);
        }else{
            
            if( (pq!=null) && (!pq.isEmpty()) && (pq.size() >= capacity)){
            	LFUNode tempNode=pq.poll(); 
                map.remove(tempNode.key);
            }

            if( (pq!=null) && (pq.size() < capacity)){
            	LFUNode newNode=new LFUNode(key,value);
                pq.add(newNode);
                map.put(key,newNode);
            }
        }
    }
}
class LFUNode implements Comparable<LFUNode>{
   int key; 
   int value; 
   Integer frequency;
   java.time.LocalTime ltime;
   public LFUNode(int key,int value){
       this.key=key;
       this.value=value;
       frequency=1;
       ltime=java.time.LocalTime.now();
   }
   public boolean equals(LFUNode node){
       return key==node.key && value==node.value;
   }
   @Override
	public int compareTo(LFUNode o) {
        if(this.frequency==o.frequency){
            return this.ltime.compareTo(o.ltime);
        }else{
            return this.frequency.compareTo(o.frequency);
        }
		
	}
}
