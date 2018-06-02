import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * reads 10 numbers from the user and then prints the mean average
 * @author Kizito Jegede
 *
 */
public class ErrorHandling {

    public static void main(String[] args) {
        ErrorHandling  et = new ErrorHandling();
        et.launch();
    }

    /**
     *
     * @param prompt test to display at input prompt
     * @return  recursion until user provides correct input
     *
     */
    public int userInput(String prompt){
        Scanner keyboard = new Scanner(System.in);
        Integer myEntry;
        try {
            myEntry = keyboard.nextInt();
        } catch (InputMismatchException ex) {
            System.out.print(prompt);
            return userInput(prompt);
        }
        return myEntry;
    }

    /**
     * Main function for starting program execution
     */
    public void launch() {
        List<Integer> intList = new ArrayList<Integer>(10);
        int myEntry;
        int total = 0;

        System.out.print("How many loops? ");
        int myLoops = userInput("How many loops? ");
        for (int i = 1; i < myLoops + 1; i++) {
            System.out.print(i + ". Enter the next number ");
            myEntry = userInput(i + ". Enter the next number ");
            intList.add(myEntry);
            // System.out.println("List content after cycle " + i + " = " + intList);
            total += myEntry;
        }
        System.out.println("Average " + " = " + (total / intList.size()));
    }
}
