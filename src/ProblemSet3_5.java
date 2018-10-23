/**
 * INSTRUCTIONS.
 * 
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainy doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control strucurs we've covered. You are not permitted to use
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

        // test your solutions here

        ps.primes(1,1000);
        
        ps.leapYears(10);
        
        ps.palindromicNumbers(202);
        
        ps.fibonacci(5);
        
        ps.multiples(2, 3, 20);
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
        for (; start < end; start++) {
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

    public void leapYears(int count) {
    	// TODO: dont use arrays
        System.out.print("The next " + ((count > 1) ? count + " leap years are " : " leap year is "));
        if (count == 1)
            System.out.print("2020");
        else if (count == 2)
            System.out.print(2020 + " and " + 2024);
        else {
            for (int i = 0; i < count; i++) {
                System.out.print((2016 + 4 * (i + 1)) + ((count > i + 1) ? ", " : ""));
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
        // TODO: use % and / to do with an int
        String palindrome = number + "";
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) == palindrome.charAt(palindrome.length() -  (i + 1)))
                continue;
            else 
                palindromic = false;
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
    	
    	int previous = 1;
    	int current = 1;
    	int next;
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
        System.out.println("The " + n + indicator + " number is " + current + "."); 
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
	    int sum = 0;
	    for (int i = 0; i < limit / x; i++) {
	    	sum += x * i;
	    }
	    for (int i = 0; i < limit / y; i++) {
	    	if (i % x != 0) {
	    		sum += y * i;
	    	}
	    }
	    System.out.println("The sum is " + sum + ".");
    }
}
