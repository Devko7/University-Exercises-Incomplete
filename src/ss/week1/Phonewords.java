package ss.week1;

import java.util.Scanner;

public class Phonewords {
    public static void main (String[] args) {

        System.out.print("Please enter a word: ");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();

        char[] list = word.toCharArray();

        for (int i = 0; i < list.length; i++) {
            switch (word.charAt(i)) {
                case 'a', 'A', 'b', 'B', 'c', 'C':
                    System.out.print(2);
                    break;
                case 'd', 'D', 'e', 'E', 'f', 'F':
                    System.out.print(3);
                    break;
                case 'g', 'G', 'h', 'H', 'i', 'I':
                    System.out.print(4);
                    break;
                case 'j', 'J', 'k', 'K', 'l', 'L':
                    System.out.print(5);
                    break;
                case 'm', 'M', 'n', 'N', 'o', 'O':
                    System.out.print(6);
                    break;
                case 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S':
                    System.out.print(7);
                    break;
                case 't', 'T', 'u', 'U', 'v', 'V':
                    System.out.print(8);
                    break;
                case 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z':
                    System.out.print(9);
                    break;
            }

        }

    }
}
