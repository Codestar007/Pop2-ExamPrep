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

        // TODO
        if (freezeAndBoilingPoints.isEthylAlchoolBoiling(temperature)) {
            System.out.println("Ethyl Alchool will boil.");
        }
        if (freezeAndBoilingPoints.isEthylAlchoolFreezing(temperature)) {
            System.out.println("Ethyl Alchool will freeze.");
        }
        if (freezeAndBoilingPoints.isOxygenBoiling(temperature)) {
            System.out.println("Oxygen will boil.");
        }
        if (freezeAndBoilingPoints.isOxygenFreezing(temperature)){
            System.out.println("Oxygen will freeze.");
        }
        if (freezeAndBoilingPoints.isWaterBoiling(temperature)) {
            System.out.println("Water will boil.");
        }
        if (freezeAndBoilingPoints.isWaterFreezing(temperature)){
            System.out.println("Water will freeze.");
        }
    }
}
