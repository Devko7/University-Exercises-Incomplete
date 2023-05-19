package ss.week1;

import java.util.Scanner;

public class Taxes {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("What is your income? ");
        Double income = input.nextDouble();

        if (income < 35472) {
            Double tax = 0.0942 * income;
            System.out.println("Your income tax is: " + tax);
        }
        else if (income >= 35472 && income <= 69398){
            Double tax = 3341 + 0.3707 * (income - 35472);
            System.out.println("Your income tax is: " + tax);
        }
        else if (income > 69398) {
            Double tax = 15917 + 0.4950 * (income - 69398);
            System.out.println("Your income tax is: " + tax);
        }
    }
}
