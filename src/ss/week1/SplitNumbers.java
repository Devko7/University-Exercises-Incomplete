package ss.week1;

import java.util.Arrays;
import java.util.Scanner;

public class SplitNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter some numbers:");
        String numbersString = input.nextLine();

        //The list will be split in the places where a space is, this gives the variable split.
        //Spaces are removed.
        String[] split = numbersString.split("\\s+");

        //Defines new Array with the length of split.
        long[] numbersArray = new long[split.length];

        //Converts each string of integers within split string to an array.
        for(int n = 0; n < split.length; n++) {
            numbersArray[n] = Integer.parseInt(split[n]);
        }
        //Sorts the array.
        Arrays.sort(numbersArray);

        //Prints it to the screen with a space in between each element.
        for(int n = 0; n < split.length; n++) {
            System.out.print(numbersArray[n] + " ");
        }
    }
}
