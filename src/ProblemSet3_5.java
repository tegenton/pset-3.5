/**
 * INSTRUCTIONS.
 *
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainly doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control structures we've covered. You are not permitted to use
 * recursive code in your solutions.
 *
 * Please be mindful of the expected outputs, as your code will be tested against that
 * directly. If you're unsure, please ask for clarification.
 *
 * This problem set is worth 25 points and is due no later than 11:59pm on October 28, 2018.
 */

public class ProblemSet3_5 {

	public static void main(String[] args) {
		ProblemSet3_5 ps = new ProblemSet3_5();

		ps.testPrimes();
		ps.testLeapYears();
		ps.testPalindromicNumbers();
		ps.testFibonacci();
		ps.testMultiples();
	}

	/**
	 * How many prime numbers are there between @start and @end, where @start and @end
	 * are positive integers in the range [1, @Integer.MAX_VALUE]?
	 *
	 * Print your solution in the following formats: "There is X prime number."
	 *                                               "There are X prime numbers."
	 *
	 * @param start
	 * @param end
	 */

	public void primes(int start, int end) {
		int count = 0;
		for (; start <= end; start++) {
			if (isPrime(start))
				count++;
		}
		System.out.println("There " + ((count != 1) ? "are " + count + " prime numbers." : "is " + count + " prime number."));
	}

	private boolean isPrime(int num) {
		if (num < 2) return false;
		if (num == 2) return true;
		if (num % 2 == 0) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}

	/**
	 * What are the next @count leap years?
	 *
	 * Print your solution in the following formats: "The next leap year is X."
	 *                                               "The next 2 leap years are X and Y."
	 *                                               "THe next N leap years are A, ..., X, Y, and Z."
	 *
	 * @param count
	 */
	private final int lastLeapYear = 2016;

	public void leapYears(int count) {

		if (count < 1)
			System.out.println("I don't know how to compute the next " + count +" leap years...");

		System.out.print("The next " + ((count > 1) ? count + " leap years are " : " leap year is "));
		if (count == 1)
			System.out.print(this.lastLeapYear + 4);
		else if (count == 2)
			System.out.print((this.lastLeapYear + 4) + " and " + (lastLeapYear + 8));
		else {
			for (int i = 0; i < count; i++) {
				System.out.print((this.lastLeapYear + 4 * (i + 1)) + ((count > i + 1) ? ", " : ""));
				if (i == count - 2)
					System.out.print("and ");
			}
		}
		System.out.println(".");
	}

	/**
	 * Is @number a palindromic number?
	 *
	 * Print your solution in the following formats: "X is a palindromic number."
	 *                                               "X is not a palindromic number."
	 *
	 * @param number
	 */

	public void palindromicNumbers(int number) {
		boolean palindromic = true;
		int length = (int)(Math.log10(number)+1);
		int i = 0;
		while (i < length && palindromic) {
			if ( (int) (number / Math.pow(10,length - (i + 1)) % 10) == (int) (number / Math.pow(10,i)) % 10);
			else palindromic = false;
			i++;
		}
		System.out.println(number + " is" + ((palindromic) ? "" : " not") + " a palindromic number");
	}

	/**
	 * What is the @nth Fibonacci number, where @n is a positive integer?
	 *
	 * Print your solution in the following formats: "The 21st Fibonacci number is X."
	 *                                               "The 22nd Fibonacci number is X."
	 *                                               "The 23rd Fibonacci number is X."
	 *                                               "The 24th Fibonacci number is X."
	 *
	 * @param n
	 */

	public void fibonacci(int n) {

		long previous = 1;
		long current = 1;
		long next;
		int count = n - 2;

		while (count > 0) {
			next = previous + current;
			previous = current;
			current = next;
			count--;
		}

		String indicator;
		switch ((n / 10 == 1) ? n : n % 10) {
			case 1:
				indicator = "st";
				break;
			case 2:
				indicator = "nd";
				break;
			case 3:
				indicator = "rd";
				break;
			default:
				indicator = "th";
		}
		System.out.println("The " + n + indicator + " Fibonacci number is " + current + ".");
	}

	/**
	 * What is the sum of all multiples of @x and @y less than @limit, where @x, @y, and
	 * @limit are positive integers?
	 *
	 * Print your solution in the following format: "The sum is X."
	 *
	 * @param limit
	 */

	public void multiples(int x, int y, int limit) {
		long sum = 0;
		for (int i = 0; i < limit; i++) {
			sum += (i % x == 0 || i % y == 0) ? i : 0;
		}
		System.out.println("The sum of all multiples of " + x + " and " + y + " less than " + limit + " is " + sum + ".");
	}

	/*
	 * Private method designed to test the implementation of primes.
	 */

	private void testPrimes() {		
		System.out.print("primes(1, 2), expected       : There is 1 prime number.\n");
		System.out.print("primes(1, 2), actual         : ");
		primes(1, 2);
		System.out.println("------------------------------------------------------------------");

		System.out.print("primes(1, 10), expected      : There are 4 prime numbers.\n");
		System.out.print("primes(1, 10), actual        : ");
		primes(1, 10);
		System.out.println("------------------------------------------------------------------");

		System.out.print("primes(1, 100), expected     : There are 25 prime numbers.\n");
		System.out.print("primes(1, 100), actual       : ");
		primes(1, 100);
		System.out.println("------------------------------------------------------------------");

		System.out.print("primes(1, 1000), expected    : There are 168 prime numbers.\n");
		System.out.print("primes(1, 1000), actual      : ");
		primes(1, 1000);
		System.out.println("------------------------------------------------------------------");

		System.out.print("primes(1, 10000), expected   : There are 1229 prime numbers.\n");
		System.out.print("primes(1, 10000), actual     : ");
		primes(1, 10000);
		System.out.println("------------------------------------------------------------------");

		System.out.print("primes(1, 100000), expected  : There are 9592 prime numbers.\n");
		System.out.print("primes(1, 100000), actual    : ");
		primes(1, 100000);
		System.out.println("------------------------------------------------------------------");

		System.out.print("primes(1, 1000000), expected : There are 78498 prime numbers.\n");
		System.out.print("primes(1, 1000000), actual   : ");
		primes(1, 1000000);
		System.out.println("------------------------------------------------------------------");
	}

	/*
	 * Private method designed to test the implementation of leapYears.
	 */

	private void testLeapYears() {
		System.out.print("leapYears(-1), expected : I don't know how to compute the next -1 leap years...\n");
		System.out.print("leapYears(-1), actual   : ");
		leapYears(-1);
		System.out.println("------------------------------------------------------------------");

		System.out.print("leapYears(0), expected  : I don't know how to compute the next 0 leap years...\n");
		System.out.print("leapYears(0), actual    : ");
		leapYears(0);
		System.out.println("------------------------------------------------------------------");

		System.out.print("leapYears(1), expected  : The next leap year is 2020.\n");
		System.out.print("leapYears(1), actual    : ");
		leapYears(1);
		System.out.println("------------------------------------------------------------------");

		System.out.print("leapYears(2), expected  : The next 2 leap years are 2020 and 2024.\n");
		System.out.print("leapYears(2), actual    : ");
		leapYears(2);
		System.out.println("------------------------------------------------------------------");

		System.out.print("leapYears(10), expected : The next 10 leap years are 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, and 2056.\n");
		System.out.print("leapYears(10), actual   : ");
		leapYears(10);
		System.out.println("------------------------------------------------------------------");

		System.out.print("leapYears(26), expected : The next 26 leap years are 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096, 2104, 2108, 2112, 2116, 2120, and 2124.\n");
		System.out.print("leapYears(26), actual   : ");
		leapYears(26);
		System.out.println("------------------------------------------------------------------");
	}

	/*
	 * Private method designed to test the implementation of palindromicNumbers.
	 */

	private void testPalindromicNumbers() {
		System.out.print("palindromicNumbers(1), expected         : 1 is a palindromic number.\n");
		System.out.print("palindromicNumbers(1), actual           : ");
		palindromicNumbers(1);
		System.out.println("------------------------------------------------------------------");

		System.out.print("palindromicNumbers(101), expected       : 101 is a palindromic number.\n");
		System.out.print("palindromicNumbers(101), actual         : ");
		palindromicNumbers(101);
		System.out.println("------------------------------------------------------------------");

		System.out.print("palindromicNumbers(12321), expected     : 12321 is a palindromic number.\n");
		System.out.print("palindromicNumbers(12321), actual       : ");
		palindromicNumbers(12321);
		System.out.println("------------------------------------------------------------------");

		System.out.print("palindromicNumbers(12345), expected     : 12345 is not a palindromic number.\n");
		System.out.print("palindromicNumbers(12345), actual       : ");
		palindromicNumbers(12345);
		System.out.println("------------------------------------------------------------------");

		System.out.print("palindromicNumbers(12), expected        : 12 is not a palindromic number.\n");
		System.out.print("palindromicNumbers(12), actual          : ");
		palindromicNumbers(12);
		System.out.println("------------------------------------------------------------------");

		System.out.print("palindromicNumbers(123454321), expected : 123454321 is a palindromic number.\n");
		System.out.print("palindromicNumbers(123454321), actual   : ");
		palindromicNumbers(123454321);
		System.out.println("------------------------------------------------------------------");
	}

	/*
	 * Private method designed to test the implementation of fibonacci.
	 */

	private void testFibonacci() {
		System.out.print("fibonacci(1), expected  : The 1st Fibonacci number is 1.\n");
		System.out.print("fibonacci(1), actual    : ");
		fibonacci(1);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(2), expected  : The 2nd Fibonacci number is 1.\n");
		System.out.print("fibonacci(2), actual    : ");
		fibonacci(2);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(3), expected  : The 3rd Fibonacci number is 2.\n");
		System.out.print("fibonacci(3), actual    : ");
		fibonacci(3);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(4), expected  : The 4th Fibonacci number is 3.\n");
		System.out.print("fibonacci(4), actual    : ");
		fibonacci(4);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(10), expected : The 10th Fibonacci number is 55.\n");
		System.out.print("fibonacci(10), actual   : ");
		fibonacci(10);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(21), expected : The 21st Fibonacci number is 10946.\n");
		System.out.print("fibonacci(21), actual   : ");
		fibonacci(21);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(22), expected : The 22nd Fibonacci number is 17711.\n");
		System.out.print("fibonacci(22), actual   : ");
		fibonacci(22);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(23), expected : The 23rd Fibonacci number is 28657.\n");
		System.out.print("fibonacci(23), actual   : ");
		fibonacci(23);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(24), expected : The 24th Fibonacci number is 46368.\n");
		System.out.print("fibonacci(24), actual   : ");
		fibonacci(24);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(25), expected : The 25th Fibonacci number is 75025.\n");
		System.out.print("fibonacci(25), actual   : ");
		fibonacci(25);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(50), expected : The 50th Fibonacci number is 12586269025.\n");
		System.out.print("fibonacci(50), actual   : ");
		fibonacci(50);
		System.out.println("------------------------------------------------------------------");

		System.out.print("fibonacci(75), expected : The 75th Fibonacci number is 2111485077978050.\n");
		System.out.print("fibonacci(75), actual   : ");
		fibonacci(75);
		System.out.println("------------------------------------------------------------------");
	}

	/*
	 * Private method designed to test the implementation of testMultiples.
	 */

	private void testMultiples() {
		System.out.print("multiples(2, 4, 10), expected : The sum of all multiples of 2 and 4 less than 10 is 20.\n");
		System.out.print("multiples(2, 4, 10), actual   : ");
		multiples(2, 4, 10);
		System.out.println("------------------------------------------------------------------");

		System.out.print("multiples(3, 5, 10), expected : The sum of all multiples of 3 and 5 less than 10 is 23.\n");
		System.out.print("multiples(3, 5, 10), actual   : ");
		multiples(3, 5, 10);
		System.out.println("------------------------------------------------------------------");

		System.out.print("multiples(2, 4, 100), expected : The sum of all multiples of 2 and 4 less than 100 is 2450.\n");
		System.out.print("multiples(2, 4, 100), actual   : ");
		multiples(2, 4, 100);
		System.out.println("------------------------------------------------------------------");

		System.out.print("multiples(3, 5, 100), expected : The sum of all multiples of 3 and 5 less than 100 is 2318.\n");
		System.out.print("multiples(3, 5, 100), actual   : ");
		multiples(3, 5, 100);
		System.out.println("------------------------------------------------------------------");

		System.out.print("multiples(2, 4, 1000), expected : The sum of all multiples of 2 and 4 less than 1000 is 249500.\n");
		System.out.print("multiples(2, 4, 1000), actual   : ");
		multiples(2, 4, 1000);
		System.out.println("------------------------------------------------------------------");

		System.out.print("multiples(3, 5, 1000), expected : The sum of all multiples of 3 and 5 less than 1000 is 233168.\n");
		System.out.print("multiples(3, 5, 1000), actual   : ");
		multiples(3, 5, 1000);
		System.out.println("------------------------------------------------------------------");

		System.out.print("multiples(2, 4, 10000), expected : The sum of all multiples of 2 and 4 less than 10000 is 24995000.\n");
		System.out.print("multiples(2, 4, 10000), actual   : ");
		multiples(2, 4, 10000);
		System.out.println("------------------------------------------------------------------");

		System.out.print("multiples(3, 5, 10000), expected : The sum of all multiples of 3 and 5 less than 10000 is 23331668.\n");
		System.out.print("multiples(3, 5, 10000), actual   : ");
		multiples(3, 5, 10000);
		System.out.println("------------------------------------------------------------------");

		System.out.print("multiples(2, 4, 100000), expected : The sum of all multiples of 2 and 4 less than 100000 is 2499950000.\n");
		System.out.print("multiples(2, 4, 100000), actual   : ");
		multiples(2, 4, 100000);
		System.out.println("------------------------------------------------------------------");

		System.out.print("multiples(3, 5, 100000), expected : The sum of all multiples of 3 and 5 less than 100000 is 2333316668.\n");
		System.out.print("multiples(3, 5, 100000), actual   : ");
		multiples(3, 5, 100000);
		System.out.println("------------------------------------------------------------------");
	}
}
