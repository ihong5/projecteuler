package net.inkihong.project.euler.service;

import org.springframework.stereotype.Service;

@Service
public class SolutionService {
	
	SolutionHelper helper = new SolutionHelper();
	
	public int getAnswer(int p) {
		int answer = 0;
		switch (p) {
		case 1:
			answer = getAnswer1(); 
			break;
		case 2:
			answer = getAnswer2();
			break;
		case 4:
			answer = getAnswer4();
			break;
		}
			
		return answer;	
	}
	
	private int getAnswer1() {
		int answer = 0;
		for (int i = 0; i < 1000; i++) {
			if ( (i % 3 == 0) || (i % 5 == 0) ) {
				answer += i;
			}
		}
		
		return answer;
	}
	
	private int getAnswer2() {
		int answer = 0,
			prev = 1,
			curr = 2,
			next = 0;
		while (curr < 4000000) {
			if (curr % 2 == 0) {
				answer += curr;
			}
			
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		
		return answer;
	}
	
	private int getAnswer4() {
		int answer = 0;
		
		for (int i = 999; i >= 900; i--) {
			for (int j = 999; j >= 900; j--) {
				answer = i * j;
				if (helper.isPalindrome(answer)) {
					i = 0;
					break;
				}
			}
		}
		
		return answer;
	}
}
