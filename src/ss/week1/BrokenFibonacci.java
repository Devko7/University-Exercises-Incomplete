package ss.week1;

public class BrokenFibonacci {
    /**
     * Calculates the nth number in the fibonacci sequence
     * using arrays to store every number.
     * @param n the index of the nth number in the sequence
     * @return the nth fibonacci number
     */

    public static long fibonacci(int n) {

        if (n == 1){   // Added if statement for case when n = 1
            return 0;
        }





        if (n <= 1) {
            // Here the if statement has an incorrect condition for the fibonacci sequence n > 2
            // It should be set to n <= 1
            return n;
        } else {
            long[] array = new long[n];         // changed n + 1 to n because it shifts the position by 1
            array[0] = 1;
            array[1] = 1;                      // changed from 2 to 1, should be equal to 1 because of fib(2) = 1
            for (int i = 2; i < n; i++) {                // i = 2 from i = 0 because we have conditions for 0 and 1
                array[i] = array[i - 1] + array[i - 2];  // changed the "-" to "+" because of the formula
            }
            return array[n - 1];
        }
    }
}
