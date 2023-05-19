package ss.week1;

import java.util.Scanner;
import java.lang.Math;

import static java.lang.Math.PI;


public class Polygon {
    public static void main(String[] args) {

        System.out.println("Enter number of sides: ");
        Scanner input = new Scanner(System.in);
        Double sides = input.nextDouble();

        System.out.println("Enter length of each side: ");
        Double length = input.nextDouble();

        Double area = (sides * (length * length)) / (4 * (Math.tan(PI / sides)));
        System.out.println("The area is: " + area);

    }
}
