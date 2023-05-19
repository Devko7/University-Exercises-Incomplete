package ss.week1;

import java.util.Scanner;


public class Emirp {

    /**
     * isPrime returns a boolean value for if a given integer is a prime number or not.
     *
     * @param value non-negative integer
     * @returns true if a number is prime, false if it is not.
     */
    public static boolean isPrime (int value) {

        if (value <= 1) {
            return false;
        }

        for (int i = 2; i < value; i++) {

            if (value % i == 0) {
                return false;
            }

        }
        return true;
    }

    /**
     * Given a non-negative integer the method .reverse()
     * returns the number with the order of the digits in reversed order
     *
     * @param number non-negative integer.
     * @returns a number greater than 0 with its digits in reversed order.
     */
    public static int reverse (int number) {

        int n = 0;

        while(number > 0)
        {
            int remainder = number % 10;
            n = (n * 10) + remainder;
            number = number/10;
        }
        return n;
    }

    /**
     * returns true if and only if
     * the given number is an emirp, using the methods isPrime and reverse.
     *
     * @param number
     * @returns true if a number is an emirp, false if it is not.
     */
    public static boolean isEmirp (int number){

        if (isPrime(number) == true && (isPrime(reverse(number)) == true && number != reverse(number))){
            return true;
        }
        else {
            return false;
        }

    }

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("How many emirps?: ");
        int result = input.nextInt();

        int p = 0;
        int i = 0;
        String s = "";

        while (p < result) {
            if (isEmirp(i)) {
                s = s + " " + i;
                p++;
            }
            i++;
        }
        System.out.println(s);


    }
}
