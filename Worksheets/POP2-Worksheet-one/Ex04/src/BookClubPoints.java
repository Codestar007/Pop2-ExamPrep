import java.util.Scanner;

public class BookClubPoints {
    /**
     * Method should return the number of points earned based on the number of
     * books purchased
     *
     * @param numberOfBooksPurchased
     * @return points earied
     */
    public static int getPointsEarned(int numberOfBooksPurchased) {
        if (numberOfBooksPurchased < 1)
            return 0;
        else if (numberOfBooksPurchased < 2)
            return 5;
        else if (numberOfBooksPurchased < 3)
            return 15;
        else if (numberOfBooksPurchased < 4)
            return 30;
        else
            return 60;
    }

    public static void main(String[] args) {
        // Define variables
        int numberOfBooksPurchased;
        int pointsAwarded;

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the number of books purchased this month.
        System.out.print("How many books have you purchased? ");
        numberOfBooksPurchased = keyboard.nextInt();

        System.out.println("Number of point awarded to you: " + getPointsEarned(numberOfBooksPurchased));
    }
}
