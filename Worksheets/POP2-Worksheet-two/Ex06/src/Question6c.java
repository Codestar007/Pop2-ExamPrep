/**
 * Question 6
 *
 * part 1 :Can you swap the contents of two Integer objects?
 *
 * Answer: No. the objects are not swapped. The parameters are passed by value in Java.
 * So the swapObj() module creates a copy of these references.
 * Hence, the change does not persist outside the module.
 * To get round this, we need to use a wrapper class as demonstrated:
 * https://www.geeksforgeeks.org/swap-exchange-objects-java/
 * */

import java.util.Scanner;

public class Question6c {
    public static void main(String[] args) {
        new Question6c().run();
    }

    void run() {
        Scanner scans = new Scanner(System.in);
        System.out.print("Enter vale of intX: ");
        int valX = scans.nextInt();
        System.out.print("Enter vale of intY: ");
        int valY = scans.nextInt();

        Integer myObjA =  valX;
        Integer myObjB = valY;

        swapObj(myObjA, myObjB); //Call method to swap values

        System.out.println("Outside SwapObj - After Swap value of myObjA: " + myObjA);
        System.out.println("Outside SwapObj - After Swap value of myObjB: " + myObjB);
    }

    public void swapObj(Integer intObjX, Integer intObjY) {
        Integer temp = intObjX; // Pass value of intX into a temporary variable
        intObjX = intObjY;
        intObjY = temp;

        System.out.println("Inside SwapObj - After Swap value of intObjX: " + intObjX);
        System.out.println("Inside SwapObj - After Swap value of intObjY: " + intObjY);

        // System.out.println("Check if intObjX is equal to intObjY: " + intObjX.equals(intObjY));
        // System.out.println("Check if intObjX == intObjY: " + (intObjX == intObjY));
    }

}
