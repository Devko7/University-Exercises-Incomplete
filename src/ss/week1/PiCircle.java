package ss.week1;

import java.util.Scanner;

import static java.lang.Math.*;

public class PiCircle {
    public static void main (String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the number of iterations.");
        int iterations = input.nextInt();

        int smallN = 0;

        for (int bigN = 0; bigN < iterations;bigN++) {

            double x = random();
            double y = random();

            if (pow(x,2) + pow(y,2) <= 1) {
                smallN++;
            }
        }

        double pie = (double) (4 * smallN) / iterations;
        System.out.println("Estimation of pi: " + pie);

    }
}