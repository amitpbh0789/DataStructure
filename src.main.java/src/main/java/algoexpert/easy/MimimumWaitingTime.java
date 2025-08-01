package src.main.java.algoexpert.easy;

import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/minimum-waiting-time
 */
public class MimimumWaitingTime {

	public static void main(String[] args) {
		MimimumWaitingTime obj = new MimimumWaitingTime();
		int[] arr = new int[] {1,5,4};
		System.out.println(obj.minimumWaitingTime(arr));

	}
	
	public int minimumWaitingTime(int[] queries) {

	    Arrays.sort(queries);
	    int lastWaitingTime = 0;
	    int lastSum = 0;
	    for(int i=1; i<queries.length; i++){
	      lastWaitingTime += queries[i-1];
	      lastSum += lastWaitingTime;
	    }
	    return lastSum;
	  }
}
