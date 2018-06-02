/**
 * Question 6
 *
 * part 1 :Why can't you implement a Java method that swaps the contents
 * of two int variables?*
 *
 * Answer: because the primitive type parameters are passed by vale to the method,
 * and so any change within the method is not reflected outside it*/

import java.util.Scanner;
public class Question6a {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter vale of intX: ");
        int valX = scan.nextInt();
        System.out.print("Enter vale of intY: ");
        int valY = scan.nextInt();

        swapVal(valX, valY);
        System.out.println("After Swap value of valX: " + valX);
        System.out.println("After Swap value of valY: " + valY);
    }

    static void swapVal(int intX, int intY) {
            int temp = intX; // Pass value of intX into a temporary variable
            intX = intY;
            intY = temp;
        }
}
