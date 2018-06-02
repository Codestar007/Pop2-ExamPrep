/**
 * Question 6
 *
 * part 1 :Why can't you implement a Java method that swaps the contents
 * of two int variables?*
 *
 * Answer: because the primitive type parameters are passed by vale to the method,
 * and so any change within the method is not reflected outside it*/


import org.omg.CORBA.IntHolder;

import java.util.Scanner;

public class Question6b {
    public static void main(String[] args) {
        new Question6b().run();
    }

    void run() {
        Scanner scans = new Scanner(System.in);
        System.out.print("Enter vale of intX: ");
        int valX = scans.nextInt();
        System.out.print("Enter vale of intY: ");
        int valY = scans.nextInt();

        IntHolder myIntHolderA = new IntHolder(valX);
        IntHolder myIntHolderB = new IntHolder(valY);

        swapObj(myIntHolderA, myIntHolderB); //Call method to swap values

        System.out.println("After Swap value of myIntHolderA: " + myIntHolderA);
        System.out.println("After Swap value of myIntHolderB: " + myIntHolderB);
        }

    private void swapObj(IntHolder intObjX, IntHolder intObjY) {
        IntHolder temp = intObjX; // Pass value of intX into a temporary variable
        intObjX = intObjY;
        intObjY = temp;
    }

}
