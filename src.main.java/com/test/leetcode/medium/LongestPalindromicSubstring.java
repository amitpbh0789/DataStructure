package com.test.leetcode.medium;

/**
 * 
 * Brute Force
 * @author amit
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		System.out.println(obj.longestPalindrome("klvxwqyzugrdoaccdafdfrvxiowkcuedfhoixzipxrkzbvpusslsgfjocvidnpsnkqdfnnzzawzsslwnvvjyoignsfbxkgrokzyusxikxumrxlzzrnbtrixxfioormoyyejashrowjqqzifacecvoruwkuessttlexvdptuvodoavsjaepvrfvbdhumtuvxufzzyowiswokioyjtzzmevttheeyjqcldllxvjraeyflthntsmipaoyjixygbtbvbnnrmlwwkeikhnnmlfspjgmcxwbjyhomfjdcnogqjviggklplpznfwjydkxzjkoskvqvnxfzdrsmooyciwulvtlmvnjbbmffureoilszlonibbcwfsjzguxqrjwypwrskhrttvnqoqisdfuifqnabzbvyzgbxfvmcomneykfmycevnrcsyqclamfxskmsxreptpxqxqidvjbuduktnwwoztvkuebfdigmjqfuolqzvjincchlmbrxpqgguwuyhrdtwqkdlqidlxzqktgzktihvlwsbysjeykiwokyqaskjjngovbagspyspeghutyoeahhgynzsyaszlirmlekpboywqdliumihwnsnwjc"));

	}

	public String longestPalindrome(String s) {

		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        char[] arr = s.toCharArray();
        int[] res = new int[2];
        int max = 0;
        for(int i=0; i<arr.length; i++){
            
            for(int j=i+1; j<=arr.length; j++){
                if(obj.isPalindrome(s.substring(i,j))){
                    int length = s.substring(i, j).length();
                    if(length>max){
                        max = length;
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        
        return s.substring(res[0],res[1]);
       
	}


	public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        char[] arr = s.toCharArray();
        while(i<j){
            if(arr[i] ==arr[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
