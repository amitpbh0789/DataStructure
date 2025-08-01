package com.test.leetcode.medium.locked;

import java.util.Map;
import java.util.Set;

/**
 * 
 * Given two sparse vectors, compute their dot product. Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums dotProduct(vec) Compute the dot product between the instance of SparseVector and vec 

A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

Follow up: What if only one of the vectors is sparse?

Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0],     Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)

v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8

Step1: Create a map with index as key and non zero value as value.
Step2: Populate Map as part of construction 
Step3: When someone calls method, they will pass Sparse object that will have map created and populated
Step4: Now check if both map has saem index as non-zero, calculate product and add into running sum
Step5: return sum

 */
public class DotProductOfTwoSparseVectors {

}


// ACtual Class

class SparseVector{
	Map<Integer, Integer> map;
	public SparseVector(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != 0) {
				map.put(i, nums[i]);
			}
		}
	}
	
	// create an API that user can call
	public int dotProduct(SparseVector vector) {
		int result = 0;
		for(int key : map.keySet()) { // getting all non-zero indexes
			if(vector.map.containsKey(key)){
				result += map.get(key) * vector.map.get(key); 
			}
		}
		return result;
	}
}