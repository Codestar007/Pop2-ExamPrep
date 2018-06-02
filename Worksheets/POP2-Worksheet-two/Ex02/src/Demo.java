import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a temperature: ");
        double temperature = keyboard.nextDouble();

        // close keyboard
        keyboard.close();

        FreezingAndBoilingPoints freezeAndBoilingPoints = new FreezingAndBoilingPoints(temperature);

        // TODO
        if (freezeAndBoilingPoints.isEthylAlchoolBoiling()) {
            System.out.println("Ethyl Alchool will boil.");
        }
        if (freezeAndBoilingPoints.isEthylAlchoolFreezing()) {
            System.out.println("Ethyl Alchool will freeze.");
        }
        if (freezeAndBoilingPoints.isOxygenBoiling()) {
            System.out.println("Oxygen will boil.");
        }
        if (freezeAndBoilingPoints.isOxygenFreezing()){
            System.out.println("Oxygen will freeze.");
        }
        if (freezeAndBoilingPoints.isWaterBoiling()) {
            System.out.println("Water will boil.");
        }
        if (freezeAndBoilingPoints.isWaterFreezing()){
            System.out.println("Water will freeze.");
        }
    }
}
