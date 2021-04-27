package com.test.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	public static void main(String[] args) {

		UniqueEmailAddresses obj = new UniqueEmailAddresses();
		String[] emails = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
		System.out.println(obj.numUniqueEmails(emails));
	}

	public int numUniqueEmails(String[] emails) {

		Set<String> set = new HashSet<>();
		for(String email : emails){ //Iterate all the emails and apply rules

			StringBuilder addres = new StringBuilder();

			boolean beforeAt = true;
			for(int i=0; i<email.length(); i++){//for each email apply rules and add into set

				char c = email.charAt(i);
				
				if(c == '@')
					beforeAt = false;
				
				
				if(beforeAt) {
					if(c=='.'){
						continue;
					} else if(c=='+'){
						while(email.charAt(i) != '@'){
							i++;
						}
						addres.append(email.substring(i)); //apend domain into sb
						break;
					} else{
						addres.append(c);
					}
				} else {
					addres.append(c);
				}

				
			}
			set.add(addres.toString());
		}
		return set.size();
	}
}
