package com.test.leetcode.medium;

/**
 * 
 * https://leetcode.com/problems/jump-game-iii/
 * 
 * @author amit
 *
 */
public class JumpGameIII {

	public static void main(String[] args) {

		JumpGameIII obj = new JumpGameIII();
		int[] arr = {4,2,3,0,3,1,2};
		int start = 5;
		System.out.println(obj.canReach(arr, start));
	}

	public boolean canReach(int[] arr, int start) {

		if(start>=0 && start<arr.length && arr[start]<arr.length){
			int jump = arr[start];
			//             This is to prevent stackoverflow
			arr[start] += arr.length;
			return jump==0 || canReach(arr, start+jump) || canReach(arr, start-jump);
		}
		return false;
	}
}
