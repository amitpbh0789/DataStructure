package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithMaxCandies {

	public static void main(String[] args) {
		KidsWithMaxCandies obj = new KidsWithMaxCandies();
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		obj.kidsWithCandies(candies, extraCandies);
	}

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

		int maxNo =0;
		for(int i=0; i<candies.length; i++){
			if(candies[i]>maxNo)
				maxNo = candies[i];
		}

		List<Boolean> list = new ArrayList<>();

		for(int i=0; i<candies.length; i++){
			if(candies[i]+extraCandies >= maxNo)
				list.add(true);
			else
				list.add(false);
		}
		return list;
	}
}
