import java.util.Scanner;

public class PalindromeDiscoverer {

    public static void main(String[] args) {
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a word or phrase: ");
        String userInput = keyboard.nextLine();

        System.out.println("User input " + userInput + " is a palindrome? " + isPalindrome(userInput));
    }

    /**
     * Method should return true if a string is identified as a palindrome.
     * There are many ways to do a palindrome check, this is just one of them.
     * If you are performing checks on very, very long strings you may want to
     * consider another algorithm.
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        String reverseStr = "";
        //Remove all spaces and non alpha characters
        String strNew = str.replaceAll("[^A-Za-z0-9]", "");

        char[] strChrArr = strNew.toCharArray();

        for (int i = strNew.length() - 1; i >= 0; i--)
            reverseStr = reverseStr + strChrArr[i];

        // For debuging
        System.out.println("Original str = " + strNew + " | reverseStr = " + reverseStr);
        return reverseStr.equalsIgnoreCase(strNew) ;
    }
}


