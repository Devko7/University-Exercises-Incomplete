package ss.week1;

import java.util.Scanner;

public class Fibonacci {
    public static long fibonacci(int number){

        if (number <= 1) {
            return number;
        }

        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static void main (String[] args) {

        System.out.println("Give a number: ");
        Scanner input = new Scanner(System.in);
        int given = input.nextInt();
        System.out.println(fibonacci(given));

    }
}
