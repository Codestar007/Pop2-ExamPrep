package PrioritySamples;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class Priority {
    private String name;
    private int id;

    public Priority(String name, int id){
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString()
    {
        return name + "=" + id;
    }
    public static void main(String[] args) {
        Comparator comparator = new StringLengthComparator();
        PriorityQueue<Priority> fifo = new PriorityQueue<Priority>(1, comparator);
        for(int i = 1; i< 6;i++){
            fifo.add(new Priority("Name-" + i, i));
        }

        // Printing the most priority element
        System.out.println("Head value using peek function:"
                + fifo.peek());

        // Printing all elements
        System.out.println("The queue elements:");
        Iterator itr = fifo.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        // get objects from the queue in an array and
        // print the array
        Object[] arr = fifo.toArray();
        System.out.println ( "Value in array: ");
        for (int i = 0; i<arr.length; i++)
            System.out.println ( "Value: " + arr[i].toString()) ;

        // Removing the top priority element (or head) and
        // printing the modified pQueue
        fifo.poll();
        System.out.println("After removing an element" +
                "with poll function:");
        Iterator<Priority> itr2 = fifo.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next());
    }

    public static class StringLengthComparator implements Comparator<Object>
    {
        @Override
        public int compare(Object x, Object y)
        {
            Priority a1 = (Priority)x;
            Priority a2 = (Priority)y;
            return Integer.compare(a2.getId(), a1.getId());
        }
    }
}
