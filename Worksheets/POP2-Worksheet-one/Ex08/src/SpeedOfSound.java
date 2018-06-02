import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class SpeedOfSound {
    final static int AIR_SPEED = 1100; // Speed of sound in Air, feet per second
    final static int WATER_SPEED = 4900; // Speed of sound in Water, feet per second
    final static int STEEL_SPEED = 16400; // Speed of sound in Steel, feet per second

    public static void main(String[] args) {
        double distance = 0.0; // Distance
        String medium ; // To hold "air", "water", or "steel"
        String[] menu = new String[]{"air", "water", "steel"};
        DecimalFormat formatter = new DecimalFormat("#0.0000"); // for formating the result

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Ask user to select mediun and then validate it
        do {
            System.out.print("Enter one of the following: air, water, or steel: ");
            medium = keyboard.nextLine();
        } while (!(Arrays.asList(menu).contains((medium.trim()).toLowerCase()))); //trim and convert to lowercase

        // Ask user to provide distance, then validate it
        do {
            System.out.print("Enter the distance the sound wave will travel: ");
            distance = keyboard.nextDouble();
        } while(distance < 0);

        double result = getDistanceTraveledInSeconds(medium, distance);
        System.out.println("It will take " + formatter.format(result) + " seconds.");
    }

    /**
     * Method should return the distance traveled in seconds.
     *
     * @param medium
     * @param distance
     * @return distance traveled
     * @throws NullPointerException when medium is null
     */
    static double getDistanceTraveledInSeconds(String medium, double distance) {
        if (medium == null)
            throw new NullPointerException();
        else if (medium.equalsIgnoreCase(""))
            return 0.0;
        else if (medium.equalsIgnoreCase("Air"))
            return (AIR_SPEED / distance);
        else if (medium.equalsIgnoreCase("Water"))
            return (WATER_SPEED / distance);
        else if (medium.equalsIgnoreCase("Steel"))
            return (STEEL_SPEED / distance);
        else
            return 0.0;
    }
}

/*
Sample output:

Enter one of the following: air, water, or steel: air
Enter the distance the sound wave will travel: 4500
It will take 4.090909090909091 seconds.
 */