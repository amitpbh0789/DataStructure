package com.test.leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * 
 * Time complexity : O(n). Only two traversals of the nums array are done. 
 * 					Further, atmost 2n elements are pushed and popped from the stack.
 * Space complexity : O(n). A stack of size n is used. res array of size n is used.

 * @author amit
 *
 */
public class NextGreaterElementII {

	public static void main(String[] args) {
		
		NextGreaterElementII obj = new NextGreaterElementII();
		int[] nums = new int[] {1,2,1};
		int[] res = obj.nextGreaterElements(nums);
		for(int i : res)
			System.out.println(i);
	}
	
	public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); //  The top of the stack refers to the index of the Next Greater Element found so far
        for (int i = 2 * nums.length - 1; i >= 0; --i) { // circular so will traverse from right to left twice
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) { // if any peek of stack element found smaller than current element then remove 
            	//coz idea is to keep greater number index in stack.
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()]; // update the greater value in res
            stack.push(i % nums.length); // push the index of greater number into stack
        }
        return res;
    }
}
