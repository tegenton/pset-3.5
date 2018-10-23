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

        ps.primes(1, 1000);
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
            // TODO: determine if prime
        }
        System.out.println("There " + ((count != 1) ? "are " + count + " prime numbers." : "is " + count + " prime number."));
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
        int[] years = new int[count];
        for (int i = 0; i < count; i++) {
            years[i] = 2016 + (4 * i);
        }
        System.out.print("The next " + ((count > 1) ? count + " leap years are " : " leap year is "));
        if (count == 1)
            System.out.print(years[0]);
        else {
            for (int i = 0; i < count; i++) {
                System.out.print(years[i] + ((count > 2) ? ", " : " "));
                if (i == count - 1) 
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
        // TODO: test and store in bool palindromic
        String palindrome = "" + number;
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) == palindrome.charAt(palindrome.length() - i))
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
        int a = 1;
        int b = 1;
        int c = 2;
        int count = n;
        while (n > 0) {
            b = a;
            a = c;
            c = a + b;
            n--;
        }
        System.out.println("The " + count + "number is " + c + "."); // TODO: add fancy 21st/32nd whatever
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

    }
}
