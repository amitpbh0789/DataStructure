package com.test.leetcode.medium;

public class PartitionToKEqualSumSubsets_Knapsack {

	public static void main(String[] args) {
		
		int[] nums = {2,2,2,2,3,4,5};
		int k = 4;
		PartitionToKEqualSumSubsets_Knapsack obj = new PartitionToKEqualSumSubsets_Knapsack();
		System.out.println(obj.canPartitionKSubsets(nums,k));
		

	}
	
	 public boolean canPartitionKSubsets(int[] nums, int k) {
	        if(nums==null || nums.length==0)
	            return false;
	        
	        int sum = 0;
	        for(int i=0; i<nums.length; i++){
	            sum += nums[i];
	        }
	        
	        if(sum%k != 0)
	            return false;
	        else{
	            
	            int targetSum = sum/k;
	            return findSubsetCount(nums, nums.length, targetSum, k);
	        }
	    }
	
	public boolean findSubsetCount(int[] nums, int n, int targetSum, int k){
        int[][] dp = new int[n+1][targetSum+1];
        for(int i=0; i<=n; i++)
            dp[i][0] = 1;
        
        for(int j=1; j<=targetSum; j++)
            dp[0][j] = 0;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=targetSum; j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][targetSum]>=k;
    }

}
