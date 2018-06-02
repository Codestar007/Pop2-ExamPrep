import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    final static int MAX = 49;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(MAX);
        List<Integer> returnedList = new ArrayList<>(6);
        for (int i=1; i < (MAX + 1); i++){
            numbers.add(i);
        }
        // TODO - make use of the provided Choice class (which you should complete)
        // Call method from Choice class
        returnedList = new Choice().selectSixNumbers(numbers);

        // Collections.sort(returnedList); // Sort the list
        System.out.println(returnedList);
    }
}
