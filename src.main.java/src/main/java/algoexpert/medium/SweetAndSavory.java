package src.main.java.algoexpert.medium;

import java.util.Arrays;

/**
 * 1. Sort the array and create 2 pointer
 * 2. Start from left and right, calculate sum and check if greater than target then move right pointer
 * 3. If less than target, then need to calculate the nearest which can be calculated using another variable to store closest sum
 * 
 * Time: O(NLogN)
 * Space: O(1)
 * 
 * https://www.algoexpert.io/questions/sweet-and-savory
 */
public class SweetAndSavory {

	public static void main(String[] args) {
		SweetAndSavory obj = new SweetAndSavory();
		int[] dishes = new int[] {-3, -5, 1, 7};
		int target = 8;
		int[] ans = obj.sweetAndSavory(dishes, target);
		System.out.println(ans[0]+" "+ans[1]);

	}
	
	public int[] sweetAndSavory(int[] dishes, int target) {
	    // Write your code here.

	    int left = 0;
	    int right = dishes.length-1;
	    Arrays.sort(dishes);
	    if(dishes.length == 0 || dishes[left]>0 || dishes[right]<0){
	      return new int[2];
	    }
	    int max = Integer.MIN_VALUE;
	    int[] ans = new int[2];
	    while(left<right && dishes[left]<0 && dishes[right]>0){
	      int currentSum = dishes[left] + dishes[right];
	      if(currentSum>target){
	        right--;
	      } else{
	        if(currentSum>max){
	          ans[0] = dishes[left];
	          ans[1] = dishes[right];
	          max = currentSum;
	        }
	        left++;
	      }
	    }
	    return ans;
	    // -5 -3 1 7
	  }

}
