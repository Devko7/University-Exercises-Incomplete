package ss.week1;

import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {

        System.out.println("Give us your name");
        Scanner input = new Scanner(System.in);
        String name1 = input.nextLine();

        System.out.println("Give us your age");
        Integer age1 = input.nextInt();

        System.out.println(name1 + " age: " + age1);
    }
}