package src.main.java.algoexpert.medium;

/**
 * https://www.algoexpert.io/questions/longest-subarray-with-sum
 * Time: O(N)
 * Space: O(1)
 */
public class LongestSubArrayWithTargetSum {

	public static void main(String[] args) {
		LongestSubArrayWithTargetSum obj = new LongestSubArrayWithTargetSum();
		int[] array = new int[] {1,2,3,4,3,3,1,2,1,2};
		int target = 10;
		
		int[] ans = obj.longestSubarrayWithSum(array, target);
		System.out.println(ans[0] +"  " +ans[1]);

	}
	
	public int[] longestSubarrayWithSum(int[] array, int targetSum) {

	    if(array == null || array.length == 0){
	      return null;
	    }

	    int sum = 0;
	    int start = 0;
	    int end = 0;
	    int max = 0;
	    int[] ans = new int[2];

	    while(end<array.length){
	      sum += array[end++];
	      if(sum<targetSum){
	        continue;
	      } else if(sum == targetSum){
	        int currLength = end - start;
	        if(currLength>max){
	          max = currLength;
	          ans[0] = start;
	          ans[1] = end-1;
	        }
	      } else {
	        while(sum > targetSum && start<end){
	          sum -= array[start++];
	        }
	      }
	      
	    }
	    return max != 0 ?  ans : new int[]{};
	  }

}
