package net.inkihong.project.euler.service;

public class SolutionHelper {
	
	public boolean isPalindrome(Integer i) {
		boolean isPalindrome = true;
		char[] num = i.toString().toCharArray();
		int j = 0,
			k = num.length - 1;
		
		while (j <= k) {
			if (num[j] != num[k]) {
				isPalindrome = false;
				break;
			}
			j++;
			k--;
		}
		
		return isPalindrome;
	}

}
