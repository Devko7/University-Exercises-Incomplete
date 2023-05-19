package ss.week1;

import java.util.Scanner;

public class Primes {
    public static boolean isPrime(int value) {

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


    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("How many primes?");
        int number = input.nextInt();

        int p = 0;
        int i = 0;
        String s = "";

        while (p < number) {
            if (isPrime(i)) {
                s = s + " " + i;
                p++;
            }
            i++;
        }
        System.out.println(s);
    }
}