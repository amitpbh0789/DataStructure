package com.test.leetcode.easy;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
 */
public class MaxProfitInStocks {

	public static void main(String[] args) {
		
		
		int[] stockPriceArray = {1,1,2,4,3,11};// output - 10
		System.out.println(calculateMaxProfit(stockPriceArray));
	}
	
	private static int calculateMaxProfit(int[] stockPriceArray) {
		
		int maxValue =  stockPriceArray[0];
		int minValue = stockPriceArray[0];
		int profit = 0;
		
		for(int i = 1; i<stockPriceArray.length; i++) {
			
			if(stockPriceArray[i-1] >= stockPriceArray[i]) {
				minValue = Math.min(minValue, stockPriceArray[i]);
				maxValue = minValue;
			}
			else {
				maxValue = stockPriceArray[i];
			}
			if(maxValue>minValue) {
				profit = Math.max(profit, maxValue-minValue);
			}
		}
		
		return profit;
	}
}
