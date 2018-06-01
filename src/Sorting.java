import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kjeged01 on 01/06/2018.
 */
public class Sorting {
    /*Data (Integers) stored in ArrayList.*/
    private static void sortNumbersInArrayList() {
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(10);
        integers.add(0);
        integers.add(-1);
        System.out.println("Original list: " +integers);
        Collections.sort(integers);
        System.out.println("Sorted list: "+integers);
        Collections.sort(integers, Collections.reverseOrder());
        System.out.println("Reversed List: " +integers);
    }

    public static void main(String[] args) {
        sortNumbersInArrayList();
    }

/*    Original list: [5, 10, 0, -1]
    Sorted list: [-1, 0, 5, 10]
    Reversed List: [10, 5, 0, -1]
   Collections.sort(<list>); This throws error since sort method
   accepts list not collection.
   If Object to be sorted is in a hashmap, then first convert to list
   e.g: List list = new ArrayList(integers);
   sorting can be achieved by using TreeSet.

   https://dzone.com/articles/how-to-sort-objects-in-java?edition=365216&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=Daily%20Digest%202018-03-02
*/
}
