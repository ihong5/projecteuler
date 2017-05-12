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
	
	public long getProduct(String s) {
		long product = 1;
		int i = 0;
		while (i < s.length()) {
			product *= Long.parseLong(s.substring(i, i + 1));
			i++;
		}
		return product;
	}

}
