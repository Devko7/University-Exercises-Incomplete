package ss.week1;

import java.util.Scanner;

public class Mortgage {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("What is the amount borrowed? ");
        Double P = input.nextDouble();

        System.out.println("What is the yearly interest rate (in %)? ");
        Double R = input.nextDouble();

        System.out.println("What is the number of years? ");
        Double N = input.nextDouble();

        Double C = ((((R / 100) / 12) / (1 - Math.pow((1 + ((R / 100) / 12)), (-N * 12)))) * P);
        System.out.println("The monthly payment is " + Math.round(C));

    }
}
