package net.inkihong.project.euler.service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Calendar;

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
		case 5:
			answer = getAnswer5();
			break;
		case 6:
			answer = getAnswer6();
			break;
		case 8:
			answer = getAnswer8();
			break;
		case 14:
			answer = getAnswer14();
			break;
		case 16: 
			answer = getAnswer16();
			break;
		case 19:
			answer = getAnswer19();
			break;
		case 20:
			answer = getAnswer20();
			break;
		case 25:
			answer = getAnswer25();
			break;
		case 28:
			answer = getAnswer28();
			break;
		}
			
		return answer;	
	}
	
	// clear
	private int getAnswer1() {
		int answer = 0;
		for (int i = 0; i < 1000; i++) {
			if ( (i % 3 == 0) || (i % 5 == 0) ) {
				answer += i;
			}
		}
		
		return answer;
	}
	
	// clear
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
	
	// clear
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
	
	// warning - correct answer, but performance can be improved
	private int getAnswer5() {
		int answer = 1,
			counter = 0;
		
		while (counter != 20) {
			for (int i = 1; i <= 20; i++) {
				if (answer % i == 0) {
					counter++;
				}
			}
			
			if (counter != 20) {
				counter = 0;
				answer++;
			}
		}
		
		return answer;
	}
	
	// clear
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
	
	// clear
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
	
	// TODO: complete this
	private int getAnswer14() {
		int answer = 0,
			counter = 1,
			max = 0;
			
		for (int i = 1; i < 1000000; i++) {
			counter = 1;
			answer = i;
			while (answer != 1) {
				if (answer % 2 == 0) {
					answer /= 2;
				} else {
					answer = (3 * answer) + 1;
				}
				counter++;
			}
			if (counter > max) {
				max = counter;
				answer = i;
				System.out.println(String.format("%d has chain length of %d!", answer, counter));
			}
		}
		
		return answer;
	}
	
	// clear
	private long getAnswer16() {
		long answer = 0;
		
		BigInteger _1000Power = BigInteger.ONE.add(BigInteger.ONE).pow(1000);
		String strPower1000 = _1000Power.toString();
		
		for (int i = 0; i < strPower1000.length(); i++) {
			int digit = Integer.parseInt(strPower1000.substring(i, i + 1));
			answer += digit;
		}
		
		return answer;
	}
	
	// clear
	private long getAnswer19() {
		long answer = 0;
		
		Date startDate = Date.valueOf("1901-01-01"),
			 endDate = Date.valueOf("2000-12-31");
		
		Calendar c1 = Calendar.getInstance(),
				 c2 = Calendar.getInstance();
		
		c1.setTime(startDate);
		c2.setTime(endDate);
		
		while (c1.before(c2)) {
			if (c1.get(Calendar.DAY_OF_MONTH) == 1 && c1.get(Calendar.DAY_OF_WEEK) == 1) {
				answer++;
			}
			c1.add(Calendar.MONTH, 1);
		}
		
		return answer;
	}
	
	// clear
	private long getAnswer20() {

		long answer = 0;
		
		BigInteger _100Factorial = BigInteger.ONE,
				   factor = BigInteger.ONE;
		
		while (factor.intValue() != 100) {
			_100Factorial = _100Factorial.multiply(factor);
			factor = factor.add(BigInteger.ONE);
		}
		
		String str100Factorial = _100Factorial.toString(); 
		
		for (int i = 0; i < str100Factorial.length(); i++) {
			int digit = Integer.parseInt(str100Factorial.substring(i, i + 1));
			answer += digit;
		}
		
		return answer;
	}

	// clear
	private long getAnswer25() {
		long answer = 1;
		
		BigInteger prev = BigInteger.ZERO,
				   curr = BigInteger.ONE,
				   next = prev.add(curr);
		
		int digits = 0;
		
		while (digits < 1000) {
			prev = curr;
			curr = next;
			next = prev.add(curr);
			answer++;
			digits = curr.toString().length();
		}
		
		return answer;
	}

	// clear
	private long getAnswer28() {
		long answer = 1;
		
		for (int n = 1; n <= 500; n++) {
			answer += (4 * Math.pow(((2*n) + 1), 2) - (12 * n));
		}
		
		return answer;
	}

    // clear
	
}
