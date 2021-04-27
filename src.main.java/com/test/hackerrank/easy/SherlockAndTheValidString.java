package com.test.hackerrank.easy;

import java.util.Arrays;

public class SherlockAndTheValidString {

	public static void main(String[] args) {
		SherlockAndTheValidString obj = new SherlockAndTheValidString();
		String str = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		System.out.println(obj.getValid(str));
	}
	
	public String getValid(String s) {


        if(s==null || s.length() == 0){
            return "NO";
        }

        char[] arr = s.toCharArray();
        int[] res = new int[26];
        for(int i=0; i<arr.length; i++){
            res[arr[i]-'a']++;
        }

        Arrays.sort(res);
        int no = res[res.length-1] == res[res.length-2]? res[res.length-1]: res[res.length-2];
        int count = 0;
        for(int i=res.length-1; i>0; i--){
            if(res[i] != 0 && res[i] != no){
                count++;
                if(Math.abs(no-res[i])>1 && res[i]!=1){
                    return "NO";
                }
                if(count>1) {
                	return "NO";
                }
            }
        }
        return "YES";
    
	}
}
