import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a temperature: ");
        double temperature = keyboard.nextDouble();

        // close keyboard
        keyboard.close();

        FreezingAndBoilingPoints freezeAndBoilingPoints = new FreezingAndBoilingPoints(temperature);

        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(freezeAndBoilingPoints.isFreezing(temperature, elm)) //if freezing point
                System.out.println(elm + " will freeze.");
            else if (freezeAndBoilingPoints.isBoiling(temperature, elm)) // if boiling point
                System.out.println(elm + " will boil.");
            else // nothing to be done
                System.out.print("");
    }
}
