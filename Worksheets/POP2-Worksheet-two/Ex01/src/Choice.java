import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Choice {
    final static int NUMS = 6;
    final static int MAX = 49;

    /**
     * Returns six distinct numbers between 1 and 49.
     *
     * @param intList the list of numbers from 1 to 49 inclusive
     * @return the list of six numbers
     */

    public List<Integer> selectSixNumbers(List<Integer> intList) {

        // Create Array to hold the 6 random numbers
        List<Integer> selection = new ArrayList<>(NUMS);
        int limit = MAX;
        for (int i = 0; i < NUMS; i++) {
            if (i == 0)
                /* break the maximum range into equal parts add offset
                and that to define the random search range for each iteration.*/
                limit = MAX;
            else
                limit = limit - 1;  // Subtract 1 to reflect random number removed from list.
            //System.out.println("Limit being sent to selectNumber itiration " + i + " = " + limit); //Debug
            int returnedRand = selectNumber(limit, intList);
            selection.add(returnedRand);
        }
        Collections.sort(selection);  // Return sorted the list
        return selection;  // Return sorted the list
}

    /**
     * Pick a random index between 1 and <code>limit</code> and return that element of the provided list
     * removing the element.
     *
     * @param limit the range for the numbers
     * @param intList the current list of numbers
     * @return the number selected
     */
    public Integer selectNumber(int limit, List<Integer> intList){
        Random rand = new Random();

        // Index for Random number. rand.nextInt(max - min) + min;
        int index = rand.nextInt(limit);
        int randomNum = intList.get(index); // get the Random number
        // System.out.println("Index: " + index + " RandNum : " + randomNum + " Limit: " + limit + " intList lenght : " + intList.size());
        intList.remove(index);  //Remove the random number from original List

        return randomNum;
    }
}
