import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SampleMain {
    final static int NUM_MONTHS = 12; // Months per year

    public static void main(String[] args) {
        Scanner stdin = new Scanner( System.in ); // Create the Scanner.

        Double rainAmount;   // The the amount of rainfall in a month.
        int totalYears;         // The number of years in total
        int year;          // For year iteration index
        int month;         // For month iteration index

        System.out.print("Enter the total years of rainfall: ");
        totalYears = stdin.nextInt();  // User asked for the number of years
        List<Double> rainFall = new ArrayList<>(totalYears * NUM_MONTHS);   // The list of all month rainfall.

        System.out.println("Enter the rainfall, in inches, for each month.");
        for (year = 1; year < (totalYears + 1); year++){
            for(month = 1; month < NUM_MONTHS + 1; month++){
                System.out.print("Year " + year +  " month " + month + ": ");
                rainAmount = stdin.nextDouble();
                rainFall.add(rainAmount);
            } //  end of inner for loop
        } // end of outer for loop

        System.out.print("\n"); // Print blank line
        System.out.println("Number of months: " + (totalYears * NUM_MONTHS)); // Print out total number of months
        System.out.println("Total rainfall: " + AverageRainfall.calculateTotalRainFall(rainFall) + " inches");
        System.out.println("Average monthly rainfall: " + AverageRainfall.calculateAverageRainFall(rainFall) + " inches");
    }
}

/*
Sample output:

Enter the number of years: 1
Enter the rainfall, in inches, for each month.
Year 1 month 1: 10
Year 1 month 2: 10
Year 1 month 3: 10
Year 1 month 4: 10
Year 1 month 5: 10
Year 1 month 6: 10
Year 1 month 7: 10
Year 1 month 8: 10
Year 1 month 9: 10
Year 1 month 10: 10
Year 1 month 11: 10
Year 1 month 12: 10

Number of months: 12
Total rainfall: 120.0 inches
Average monthly rainfall: 10.0 inches

 */
