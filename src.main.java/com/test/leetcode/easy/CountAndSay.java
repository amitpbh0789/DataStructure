package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/count-and-say/
 * 
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * @author amit
 *
 */
public class CountAndSay {

    public static void main(String[] args) {

        System.out.println(countAndSay(5));
    }
    private static String countAndSay(int n) {

        if(n==1)
            return "1";
        if(n==2)
            return "11";

        String result = "11";
        
        for(int i=3; i<=n; i++) {
            result +='$';
            String temp = "";
            char[] arr = result.toCharArray();
            int count = 1;
            for(int j=1; j<arr.length; j++) {

                if(arr[j] != arr[j-1]) {
//                    temp += count +0;
//                    temp += arr[j-1];
                	temp = temp.concat(String.valueOf(count)+arr[j-1]);
                    count = 1;
                }else {
                    count = count +1;
                }
            }
            result = temp;
        }

        return result;
    }
}
