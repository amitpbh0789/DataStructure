package com.test.leetcode.hard;

/**
 * 
Code flow for input array: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Left array:  [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
Right Array: [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]

https://leetcode.com/problems/trapping-rain-water/
 * 
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater obj = new TrappingRainWater();
		int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(obj.trap(height));

	}
	
	public int trap(int[] height) {
        int result = 0;
        if(height==null || height.length<=2)
            return result;
        int left[] = new int[height.length];
        int right[]= new int[height.length];
        //scan from left to right
        int max = height[0];
        left[0] = height[0];
        for(int i=1; i<height.length; i++){
            if(height[i]<max){
                left[i]=max;
            }
            else {
                left[i]=height[i];
                max = height[i];
            }
        }
        //scan from right to left
        max = height[height.length-1];
        right[height.length-1]=height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            if(height[i]<max){
                right[i]=max;  
            }
            else{  
                right[i]=height[i];
                max = height[i];
            }
        }
    
    // find min between left and right for each index and reduce the block height. This will give us the space left for water collection
        for(int i=0; i<height.length; i++){
            result+= Math.min(left[i],right[i])-height[i];
        }
        return result;
    }

}
