import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BarChart {

    /**
     * Method should return the number of chars to make up the bar in the chart.
     *
     * @param sales
     * @return
     */
    final static int NUM_STORES = 5; // Number of stores

    public static String getBar(double sales) {
        double chartCharCount = ((int)(sales/100));
        return repeatChar(chartCharCount);
    }

    public static String repeatChar(double chartCharCount) {
        String strChar = "";
        for (int i  = 0; i < ((int)(chartCharCount)); i++) {
            strChar = strChar + "*";
        }
        return strChar;
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner( System.in ); // Create the Scanner.
        List<Integer> storeSales = new ArrayList<>(NUM_STORES);   // The list of Store sales
        int thisSale;

        for (int index  = 0; index < (NUM_STORES); index++){
            System.out.print("Enter today's sales for stores " + (index + 1) + ":");
            thisSale = stdin.nextInt();  // User asked for the number of years
            storeSales.add(thisSale);
        } // end of first for loop

        System.out.println("\nSales Bar Chart:"); // Print report header
        for (int index  = 0; index < (NUM_STORES); index++){
            System.out.println("Store " + (1 + index) + ": " + getBar(storeSales.get(index))); // Print report header
        }
    }

}
