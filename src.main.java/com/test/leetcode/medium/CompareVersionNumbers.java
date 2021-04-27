package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 *
 */
public class CompareVersionNumbers {

	public static void main(String[] args) {
		String version1="7.5.2.04";
		String version2="7.5.003";
		
		System.out.println(compareVersion(version1, version2));
	}

	public static int compareVersion(String version1, String version2) {
		String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int length = Math.max(ver1.length, ver2.length);
        
        for(int i=0; i<length; i++){
            int v1 = i<ver1.length? Integer.parseInt(ver1[i]):0;
            int v2 = i<ver2.length? Integer.parseInt(ver2[i]):0;
            if(v1<v2)
            	return -1;
            if(v1>v2)
            	return 1;
        }
        return 0;
	}
}
