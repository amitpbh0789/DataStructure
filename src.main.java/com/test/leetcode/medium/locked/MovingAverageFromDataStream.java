package com.test.leetcode.medium.locked;

import java.util.LinkedList;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size. double next(int val) 

Returns the moving average of the last size values of the stream.

Input: ["MovingAverage", "next", "next", "next", "next"] [[3], [1], [10], [3], [5]] 			
Output: [null, 1.0, 5.5, 4.66667, 6.0]

Idea: Add nums into dequeue and maintain count. 
 * 
 */
public class MovingAverageFromDataStream {

	public static void main(String[] args) {
		MovingAverageFromDataStream obj = new MovingAverageFromDataStream(3);
		System.out.println(obj.next(1));
		System.out.println(obj.next(10));
		System.out.println(obj.next(3));
		System.out.println(obj.next(5));
	}
	
	private int windowSize;
    private LinkedList<Integer> queue;
    private double sum;
    int count = 0;
 
    
    public MovingAverageFromDataStream(int size) {
        windowSize = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
    	if(count == windowSize) { // if window limit reached
    		queue.removeLast();
    		count--;
    	}
    	queue.push(val);
    	sum = sum + val;
    	count++;
    	double result = sum/count;
    	
    	
    	return result;
    }
    
    
}
