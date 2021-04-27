package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/high-five/
 * 
 * Given a list of scores of different students, return the average score of each student's top five
 * scores in the order of each student's id.Each entry items[i] has items[i][0] the student's id,
 * and items[i][1] the student's score.  The average score is calculated using integer division.
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation: 
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average 
 * converts to 88.
 * 
 * @author amit
 *
 */
public class HighFive {

    public static void main(String[] args) {
        int[][] arr = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        Map<Integer, ArrayList<Integer>> map = getHighFive(arr);
        for(Integer key : map.keySet()) {
            System.out.println("Student "+key+ " has average score of "+map.get(key));
        }
    }
    private static Map<Integer, ArrayList<Integer>> getHighFive(int[][] arr) {
        
        ArrayList<Integer> list = null;
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<arr.length; i++) {
            if(!map.containsKey(arr[i][0])) {
                list = new ArrayList<Integer>();
                list.add(arr[i][1]);
                map.put(Integer.valueOf(arr[i][0]), list);
            }else {
                map.get(arr[i][0]).add(arr[i][1]);
            }
        }
        for(Integer key : map.keySet()) {
            ArrayList<Integer> values = map.get(key);
            Collections.sort(values);
            Collections.reverse(values);
            int sum = 0;
            int maxSubjectCount = 0;
            if(values.size()>=5)
            	maxSubjectCount=5;
            else
            	maxSubjectCount = values.size();
           for(int i=0; i<maxSubjectCount; i++) {
               sum = sum + values.get(i);
           }
           sum = sum/5;
           values.clear();
           values.add(sum);
           map.put(key, values);
        }
        return map;
    }
}
