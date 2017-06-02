package net.inkihong.project.euler.service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import net.inkihong.project.euler.util.Node;
import net.inkihong.project.euler.util.TriNode;
import net.inkihong.project.euler.util.Triangle;

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
		case 9:
			answer = getAnswer9();
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
		case 17:
			answer = getAnswer17();
			break;
		case 18:
			answer = getAnswer18();
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
		case 54:
			answer = getAnswer54();
			break;
		case 56:
			answer = getAnswer56();
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
	private int getAnswer9() {
		int answer = 0;
		
		for (int i = 1; i < 1000; i++) {
			for (int j = 1; j < 1000; j++) {
				for (int k = 1; k < 1000; k++) {
					int iSq = i * i,
						jSq = j * j,
						kSq = k * k;
					if ( (iSq + jSq == kSq) && (i + j + k == 1000) ) {
						answer = i * j * k;
					}
				}
			}
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
	
	// TODO: complete this
	private int getAnswer17() {
		int answer = 0;
		
		Map<Integer, String> nwPair = new HashMap<Integer, String>();
		
		nwPair.put(1, "one");
		nwPair.put(2, "two");
		nwPair.put(3, "three");
		nwPair.put(4, "four");
		nwPair.put(5, "five");
		nwPair.put(6, "six");
		nwPair.put(7, "seven");
		nwPair.put(8, "eight");
		nwPair.put(9, "nine");
		nwPair.put(10, "ten");
		nwPair.put(11, "eleven");
		nwPair.put(12, "twelve");
		nwPair.put(13, "thirteen");
		nwPair.put(14, "fourteen");
		nwPair.put(15, "fifteen");
		nwPair.put(16, "sixteen");
		nwPair.put(17, "seventeen");
		nwPair.put(18, "eighteen");
		nwPair.put(19, "nineteen");
		nwPair.put(20, "twenty");
		nwPair.put(30, "thirty");
		nwPair.put(40, "forty");
		nwPair.put(50, "fifty");
		nwPair.put(60, "sixty");
		nwPair.put(70, "seventy");
		nwPair.put(80, "eighty");
		nwPair.put(90, "ninety");
		nwPair.put(100, "hundred");
		nwPair.put(1000, "thousand");
		
		for (int i = 1; i <= 1000; i++) {
			if (nwPair.containsKey(i)) {
				if ( (i == 100) || (i == 1000) ) {
					answer += 3;
				}
				int nl = nwPair.get(i).length();
				answer += nl;
			} else if ( (i > 20) && (i < 100) ) {
				int ones = i % 10,
					nl = nwPair.get(ones).length(),
					tens = i - ones,
					nl2 = nwPair.get(tens).length();
				answer += nl;
				answer += nl2;
			} else if ( (i > 100) && (i < 1000) ) {
				int last2Digits = i % 100;
				if ( (last2Digits > 0) && (last2Digits <= 20) ) {
					int hundreds = i / 100,
						nl = nwPair.get(hundreds).length(),
						nl2 = nwPair.get(100).length(),
						nl3 = nwPair.get(last2Digits).length();
					answer += nl; // one, two, three, etc.. hundred
					answer += nl2; // hundred
					answer += 3; // and
					answer += nl3; // remaining 2 digits
				} else {
					int hundreds = i / 100,
						nl = nwPair.get(hundreds).length(), // one, two, three, etc.. hundred
						nl2 = nwPair.get(100).length(), // hundred
						ones = i % 10,
						nl3 = nwPair.get(ones).length(), // one, two, three, etc. last digit
						tens = i - (hundreds * 100) - ones,
						nl4 = nwPair.get(tens).length(); // thirty, forty, firty, etc..
					answer += nl;
					answer += nl2;
					answer += 3; // and
					answer += nl3;
					answer += nl4;		
				}
			}
		}
		
		return answer;
	}
	
	// TODO: clear; clean up the code
	private int getAnswer18() {
		int answer = 0,
			candidate = 0;
		
		final int[][] NUM = {
				{75},
				{95, 64},
				{17, 47, 82},
				{18, 35, 87, 10},
				{20, 4, 82, 47, 65},
				{19, 1, 23, 75, 3, 34},
				{88, 2, 77, 73, 7, 63, 67},
				{99, 65, 4, 28, 6, 16, 70, 92},
				{41, 41, 26, 56, 83, 40, 80, 70, 33},
				{41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
				{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
				{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
				{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
				{63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
				{4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
		};
		
		Triangle t = new Triangle();
		
		TriNode base = null;
		
		for (int[] r : NUM) {
			if (r.length > 2) {
				for (int i = 1; i < r.length; i++) {
					if (i == 1) { // left most
						t.addChildren(base, r[0], r[i]);
						base = base.rightSibling;
					} else if ( (i > 1) && (i < r.length - 1) ) { // in the middle
						t.addChildren(base, r[i]);
						base = base.rightSibling;
					} else if (i == r.length - 1) { // right most
						t.addChildren(base, r[i]);
						while (base.leftSibling != null) {
							base = base.leftSibling;
						}
						base = base.leftChild;
					}
				}
			} else if (r.length == 1) {
				t.setRoot(new TriNode(r[0]));
			} else if (r.length == 2) {
				TriNode root = t.getRoot();
				t.addChildren(root, r[0], r[1]);
				base = root.leftChild;
			}
		}
		
		for (int i = 16383; i >= 0; i--) { // i = 2^14 = 16384, 2^3 = 8 (example)
			TriNode parent = t.getRoot();
			candidate = t.getRoot().getValue();
			Integer[] binary = helper.toBinary(i, 14);
			System.out.println("\n\n");
			for (Integer b : binary) {				
				if (b.intValue() == 0) {
					candidate += parent.leftChild.getValue();
					System.out.println(parent.leftChild.getValue());
					parent = parent.leftChild;
				} else {
					candidate += parent.rightChild.getValue();
					System.out.println(parent.rightChild.getValue());
					parent = parent.rightChild;
				}
			}
			
			if (candidate > answer) {
				answer = candidate;
				candidate = t.getRoot().getValue();
			}
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
	
	// clear
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
	
	// TODO: complete this
	private int getAnswer54() {
		int answer = 0;
		
		return answer;
	}
	
	// TODO: complete this
	private long getAnswer56() {
		long answer = 0,
			 candidate = 0;
		
		final int SIDE = 99;
		
		for (int i = SIDE; i > 0; i--) {
			for (int j = SIDE; j > 0; j--) {
				String n = BigInteger.valueOf(i + 1).pow(j + 1).toString();
				for (int k = 0; k < n.length() - 1; k++) {
					int d = Integer.parseInt(n.substring(k, k + 1));
					candidate += d;
				}
				
				if (candidate > answer) {
					answer = candidate;
					candidate = 0;
				}
			}
		}
		
		return answer;
	}
	
}
