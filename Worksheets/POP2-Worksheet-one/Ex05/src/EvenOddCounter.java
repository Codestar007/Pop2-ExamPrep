import java.util.Random;


public class EvenOddCounter {

    /**
     * @param num to check
     * @return true if the num is true otherwise false
     */
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {

        int evenNumberCount = 0;
        int oddNumberCount = 0;


        Random randomValue = new Random();

        // TODO
        for (int i = 0; i < 100; i++){
            if (isEven(randomValue.nextInt(100)))
                evenNumberCount = evenNumberCount + 1;
            else
                oddNumberCount = oddNumberCount + 1;
        } // end of first for loop

        System.out.println("Even numbers count: " + evenNumberCount);
        System.out.println("Odd numbers count: " + oddNumberCount);
    }

}
