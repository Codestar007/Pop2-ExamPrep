import java.util.Scanner;

public class PresentValue {

    public static void main(String[] args) {
        // Scanner object to get input
        Scanner keyboard = new Scanner(System.in);

        // Desired future value
        System.out.print("Future value? ");
        double futureValue = keyboard.nextDouble();

        // Desired Annual Interest Rate
        System.out.print("Annual Interest Rate? ");
        double annualInterestRate = keyboard.nextDouble();

        // Desired Number Of Years
        System.out.print("Number Of Years? ");
        int numberOfYears = keyboard.nextInt();

        System.out.println("you need to invest $" + calculatePresentValue(futureValue, annualInterestRate, numberOfYears));
    }

    /**
     * Method should calculate present value
     *
     * @param futureValue
     * @param annualInterestRate
     * @param numberOfYears
     * @return present value
     */
    public static double calculatePresentValue(double futureValue,
                                               double annualInterestRate, int numberOfYears) {
        // Formula   P = F/(1/r)^n
        return futureValue /(Math.pow(1 + annualInterestRate,numberOfYears));
    }
}

/*
Sample Output:

Future value? 1000
Annual interest rate? .10
Number of years? 10
You need to invest $385.5432894295314
 */