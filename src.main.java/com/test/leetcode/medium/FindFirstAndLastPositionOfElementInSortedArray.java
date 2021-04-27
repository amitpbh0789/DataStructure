package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * @author amit
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(obj.searchRangeUsingBinarySearch(nums, target));
	}
	
	
	/**
	 * @Time Complexity: O(LogN)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRangeUsingBinarySearch(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
	
	private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

	/**
	 * O(N)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {

		int[] res = new int[] {-1,-1};
		if(nums == null || nums.length ==0) {
			return res;
		}
		
		int i=0;
		int j = nums.length-1;
		while(i<=j) {
			if(nums[i] == target && nums[j] == target) {
				res[0] = i;
				res[1] = j;
				break;
			} else if(nums[i] == target && nums[j] != target)
				j--;
			else if(nums[i] != target && nums[j] == target)
				i++;
			else {
				i++;
				j--;
			}
		}
		
		return res;
	}
}
