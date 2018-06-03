package PrioritySamples;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> names = new PriorityQueue<String>();

        names.insert("Bob", 5);
        names.insert("Susan", 10);
        names.insert("Dave", 7);
        names.insert("Lisa", 3);

        while (!names.isEmpty())
            System.out.print(names.extractMax() + " ");
    }
}
