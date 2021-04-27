package com.test.leetcode.hard;

/*
 * 
https://leetcode.com/problems/median-of-two-sorted-arrays/

Try to cut samller array into binary search way. If we cut 1st array at i then we cut second array
on (m+n+1)/2-i -> m - length of arr1 and n length of arr2, 1 is 

Now try to find out a[i-1] <= b[j] and b[j-1]<=a[i]

so this i is the position around whic median lies.

Time: O(Log(min(m,n)))
 * 
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		
		int[] nums1 = new int[] {2};
		int[] nums2 = new int[] {};
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if(nums1.length>nums2.length){
			return findMedianSortedArrays(nums2, nums1); // to make sue nums1 is less than nums2
		}

		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;

		while(low<=high){
			int partitionX = (low+high)/2;
			int partitionY = (x+y+1)/2 - partitionX;

			// find max if left and min of right in nums1 where you cut the array
			int maxLeftX = partitionX==0 ? Integer.MIN_VALUE : nums1[partitionX-1];
			int minRightX = partitionX==x ? Integer.MAX_VALUE : nums1[partitionX];
			// find max of left and min of right in nums2 where you cut the array
			int maxLeftY = partitionY==0 ? Integer.MIN_VALUE : nums2[partitionY-1];
			int minRightY = partitionY==y ? Integer.MAX_VALUE : nums2[partitionY];

			// now check the condition

			if(maxLeftX<=minRightY && maxLeftY<=minRightX){
				// means partition is at correct place
				if((x+y)%2==0){
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else{
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if(maxLeftX>minRightY){
				// we need to move binary search to left direction from the cut
				high = partitionX-1;
			} else{
				// move to right direction
				low = partitionX+1;
			}
		}
		return -1.0;
	}
}
