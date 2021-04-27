package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {

	public static void main(String[] args) {

		List<String> answer = fizzBuzz(15);
		answer.forEach(ans -> {
			System.out.println(ans);
		});
	}

	private static List<String> fizzBuzz(int number) {
		List<String> answer = new ArrayList<>();
		Map<Integer, String> map = new HashMap<Integer, String>() {
			private static final long serialVersionUID = 1L;

			{
				put(3, "Fizz");
				put(5, "Buzz");
			}
		};

		for(int i=1; i<=number; i++) {
			String str = "";
			for(Integer key : map.keySet()) {
				if(i%key == 0) {
					str +=map.get(key);
				}
			}

			if(str.equals("")) {
				str = String.valueOf(i);
			}
			answer.add(str);
		}
		return answer;
	}
}
