package net.inkihong.project.euler.service;

import java.math.BigInteger;
import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class SolutionService {
	
	SolutionHelper helper = new SolutionHelper();
	
	public long getAnswer(int p) {
		long answer = 0;
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
		case 6:
			answer = getAnswer6();
			break;
		case 8:
			answer = getAnswer8();
			break;
		case 16: 
			answer = getAnswer16();
			break;
		case 19:
			answer = getAnswer19();
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
	
	private int getAnswer6() {
		int si = 0,
			sj = 0;
		for (int i = 1; i <= 100; i++) {
			si += (i * i);
			sj += i;
		}
		
		sj = sj * sj;
		return sj - si;
	}
	
	private long getAnswer8() {
		String bigNumber = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		long answer = 0;
		int i = 0,
			j = i + 13;
		while (j < bigNumber.length()) {
			String _13Digit = bigNumber.substring(i, j);
			long max = helper.getProduct(_13Digit);
			if (max > answer) {
				answer = max;
			}
			i++;
			j++;
		}
		return answer;
	}
	
	private long getAnswer16() {
		long answer = 0;
		
		BigInteger _1000Power = BigInteger.ONE.add(BigInteger.ONE).pow(1000);
		String strPower1000 = _1000Power.toString();
		
		for (int i = 0; i < strPower1000.length(); i++) {
			int factor = Integer.parseInt(strPower1000.substring(i, i + 1));
			answer += factor;
		}
		
		return answer;
	}
	
	private long getAnswer19() {
		long answer = 0;
		
		Date startDate = Date.valueOf("1901-01-01"),
			 endDate = Date.valueOf("2000-12-31");
		
		while (startDate.before(endDate)) {
			startDate.
		}
		
//		1 Jan 1900 was a Monday.
//		Thirty days has September,
//		April, June and November.
//		All the rest have thirty-one,
//		Saving February alone,
//		Which has twenty-eight, rain or shine.
//		And on leap years, twenty-nine.
//		A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
		
//		How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
		
		
		
		return answer;
	}
}
