package ss.week1;

import java.util.Scanner;

public class GrossAndDozens {
    public static void main(String[] args) {

        System.out.println("How many eggs do you have?");
        Scanner input = new Scanner(System.in);
        Integer num = input.nextInt();
        Integer gross = num / 144;
        Integer dozen = (num / 12) - (gross * 12);
        Integer diff = num % 12;

        System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + diff);

    }
}
