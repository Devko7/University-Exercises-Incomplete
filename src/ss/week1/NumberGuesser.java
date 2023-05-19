package ss.week1;

import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int min = 1; int max = 100;

        Integer num = (int)(Math.random() * (max - min + 1) + min);

        askAgain :

        System.out.println("Guess the number: ");
        Integer guess = input.nextInt();

        while (true) {
            if (guess == num) {
                System.out.println("You guessed the number " + num + "!");
                break;
            } else if (guess < num) {
                System.out.println("Go higher!");
                guess = input.nextInt();
            } else if (guess > num) {
                System.out.println("Go lower!");
                guess = input.nextInt();
            }
        }

    }
}
