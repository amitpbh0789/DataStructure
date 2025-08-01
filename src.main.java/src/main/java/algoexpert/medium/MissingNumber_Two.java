package src.main.java.algoexpert.medium;

/**
 * https://www.algoexpert.io/questions/missingNumbers
 * 
 * 1. Calculate Expected SUm and Actual sum like single missing number 
 * 2. Get the average of missing total. One number will beleft of average and other will be right of the average
 * 3. Now, calculate actual and expected arrays left and right sum by dividing with the help of average 
 * 4. now get the diff of left and right. That should be the answer
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class MissingNumber_Two {
	public static void main(String[] args) {
		int[] nums = new int[] {1,4,3};
		
		MissingNumber_Two obj = new MissingNumber_Two();
		int[] ans = obj.missingNumbers(nums);
		System.out.println(ans[0]+ ".... "+ans[1]);
	}
	
	public int[] missingNumbers(int[] nums) {
	   
		// Find the total expected sum 
		
		int expectedTotalSum = 0;
		for(int i=1; i<=nums.length+2; i++) {
			expectedTotalSum += i;
		}
		
		int actualTotalSum = 0;
		for(int i=0; i<nums.length; i++) {
			actualTotalSum += nums[i];
		}
		
		int missingNUmberAverage = (expectedTotalSum - actualTotalSum)/2;
		
		// Now iterate the Array and calculate sum or left and array by comparing average value
		
		int leftSum = 0;
		int rightSum = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]<= missingNUmberAverage) {
				leftSum += nums[i];
			}else {
				rightSum += nums[i];
			}
		}
		
		int expectedLeftSum = 0;
		int expectedRightSum = 0;
		for(int i=1; i<=nums.length+2; i++) {
			if(i<= missingNUmberAverage) {
				expectedLeftSum += i;
			}else {
				expectedRightSum += i;
			}
		}
		
		
	    return new int[] {(expectedLeftSum-leftSum), (expectedRightSum-rightSum)};
	  }

}
