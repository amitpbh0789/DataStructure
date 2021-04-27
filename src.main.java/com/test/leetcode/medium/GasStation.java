package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/gas-station/
 * 
 * @author amit
 *
 */
public class GasStation {

	public static void main(String[] args) {

		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		GasStation obj = new GasStation();
		System.out.println(obj.canCompleteCircuit(gas, cost));

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		
		int sumGas = 0;
		int sumCost = 0;
		int tank = 0;
		int start = 0;
		
		for(int i=0; i<gas.length; i++) {
			
//			Calculate sum of Total gas
			sumGas += gas[i];
//			Calculate sum of Total Cost of reaching form a to b
			sumCost += cost[i];
			
//			Check the tank at given Gas station
			tank += gas[i] - cost[i];
			
//			If tank goes negative which which till i gas station, we can not have starting point
//			so make tank 0 and make starting point as i+1
			if(tank<0) {
				start = i + 1;
				tank =0;
			}
		}
		
//		If total gas is less than total cost then no result found else return the start value
		if(sumGas<sumCost)
			return -1;
		else 
			return start;
	}
}
