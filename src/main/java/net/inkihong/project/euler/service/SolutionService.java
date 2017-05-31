package net.inkihong.project.euler.service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import net.inkihong.project.euler.util.Node;

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
		case 3:
			answer = getAnswer3();
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
		case 11:
			answer = getAnswer11();
			break;
		case 12:
			answer = getAnswer12();
			break;
		case 13:
			answer = getAnswer13();
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
		case 22:
			answer = getAnswer22();
			break;
		case 25:
			answer = getAnswer25();
			break;
		case 28:
			answer = getAnswer28();
			break;
		case 29:
			answer = getAnswer29();
			break;
		case 30:
			answer = getAnswer30();
			break;
		case 31:
			answer = getAnswer31();
			break;
		case 36:
			answer = getAnswer36();
			break;
		case 48:
			answer = getAnswer48();
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
	private long getAnswer3() {
		long answer = 600851475143L;
		int factor = 1;
		while (factor < answer) {
			if (answer % factor == 0) {
				answer /= factor;
			}
			factor += 2;
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
	
	// clear - correct answer, but performance can be improved
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
		String bigNumber = SolutionHelper._8_BIG_NUMBER;
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
	
	// clear
	private long getAnswer11() {
		long answer = 0,
			 compare = 0;
		int[][] numbersGrid = SolutionHelper._11_NUMBERS_GRID;
		int len = 20;
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				for (int k = 0; k < 8; k++) {
					try {
						switch (k) {
						case 0:
							compare = numbersGrid[i][j] * numbersGrid[i + 1][j] * numbersGrid[i + 2][j] * numbersGrid[i + 3][j];
							break;
						case 1:
							compare = numbersGrid[i][j] * numbersGrid[i + 1][j + 1] * numbersGrid[i + 2][j + 2] * numbersGrid[i + 3][j + 3];
							break;
						case 2:
							compare = numbersGrid[i][j] * numbersGrid[i][j + 1] * numbersGrid[i][j + 2] * numbersGrid[i][j + 3];
							break;
						case 3:
							compare = numbersGrid[i][j] * numbersGrid[i - 1][j + 1] * numbersGrid[i - 2][j + 2] * numbersGrid[i - 3][j + 3];
							break;
						case 4:
							compare = numbersGrid[i][j] * numbersGrid[i - 1][j] * numbersGrid[i - 2][j] * numbersGrid[i - 3][j];
							break;
						case 5:
							compare = numbersGrid[i][j] * numbersGrid[i - 1][j - 1] * numbersGrid[i - 2][j - 2] * numbersGrid[i - 3][j - 3];
							break;
						case 6:
							compare = numbersGrid[i][j] * numbersGrid[i][j - 1] * numbersGrid[i][j - 2] * numbersGrid[i][j - 3];
							break;
						case 7:
							compare = numbersGrid[i][j] * numbersGrid[i + 1][j - 1] * numbersGrid[i + 2][j - 2] * numbersGrid[i + 3][j - 3];
							break;
						}
						if (compare > answer) answer = compare;
					} catch (ArrayIndexOutOfBoundsException aiEx) {
						
					}
				}
			}
		}
		
		return answer;
	}
	
	// TODO: complete this
	private long getAnswer12() {
		long answer = 0;
		int i = 1;
		boolean triNumFound = false;
		while (!triNumFound) {
			long triNum = helper.getTriangleNumber(i);
			if (helper.getNumDivisors(triNum) > 5) {
				answer = triNum;
				triNumFound = true;
			}
		}
		return answer;
	}
	
	// clear
	private long getAnswer13() {
		long answer = 0;
		
		BigInteger sum = BigInteger.ZERO,
				   num = null;
		
		String[] nArray = SolutionHelper._13_NUMBERS_LIST;
		
		for (String n : nArray) {
			num = new BigInteger(n);
			sum = sum.add(num);
		}
		
		String firstTenDigits = sum.toString().substring(0, 10);
		
		answer = Long.parseLong(firstTenDigits);
		
		return answer;
	}
	
	// TODO: complete this
	// THIS IS A MOTHER ****ING MEMORY KILLER
	private int getAnswer14() {
		int answer = 0,
			counter = 1,
			max = 0;
		
		List<Node> nodes = new ArrayList<Node>();
		
		for (int i = 999999; i > 0; i--) {
			Node node = new Node(i);
			nodes.add(node);
		}
		
		for (Node node : nodes) {
			int start = node.getStart();
			while (start != 1) {
				int next = (start % 2 == 0) ? start / 2 : (start * 3) + 1;
				node.getChain().add(next);
			}
			
			counter = node.getChain().size();
			if (counter > max) {
				max = counter;
				answer = start;
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
	private long getAnswer22() {
		long answer = 0;
		int pos = 1;
		
		String[] namesArray = SolutionHelper._22_NAMES_LIST.split(",");
		Arrays.sort(namesArray);
		
		for (String name : namesArray) {
			answer += helper.getNameScore(name, pos);
			pos++;
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
	private int getAnswer29() {
		int answer = 0;
		
		Set<BigInteger> pSet = new HashSet<BigInteger>();
		
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				BigInteger p = BigInteger.valueOf(i).pow(j);
				pSet.add(p);
			}
		}
		
		answer = pSet.size();
		
		return answer;
	}
	
	// clear; need a better implementation
	// it should include all numbers with any number of digits, not just 5 digits
	private int getAnswer30() {
		int answer = 0;
		
		for (int i = 1000000; i > 1; i--) {
			int fifthPowerSum = 0,
				j = i;
			while (j > 0) {
				fifthPowerSum += Math.pow(j % 10, 5);
				j /= 10;
			}
			if (fifthPowerSum == i) {
				answer += fifthPowerSum;
				System.out.println(fifthPowerSum);
			}
		}
		
		return answer;
	}
	
	private int getAnswer31() {
		int answer = 0;
		
		
		
		return answer;
	}
	
	// clear
	private long getAnswer36() {
		long answer = 0;
		
		for (int i = 1; i < 1000000; i++) {
			boolean isDecimalPalindrome = helper.isPalindrome(i),
					isBinaryPalindrome = helper.isPalindrome(helper.toBinary(i));
			
			if (isDecimalPalindrome && isBinaryPalindrome) {
				answer += i;
			}
		}
		
		return answer;
	}
	
	// TODO: clear
	private long getAnswer48() {
		long answer = 0;
		
		BigInteger total = BigInteger.ZERO;
		
		for (int i = 1; i <= 1000; i++) {
			BigInteger bi = BigInteger.valueOf(i),
					   selfPower = bi.pow(i);
			
			total = total.add(selfPower);		   
		}
		
		String s = total.toString(),
			   last10 = s.substring(s.length() - 10);
		
		answer = Long.parseLong(last10);

		return answer;
	}
	
}
