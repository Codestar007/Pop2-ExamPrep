package PrioritySamples;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class PriorityQueue<T> {
    private ArrayList<QueueEntry<T>> elements;

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    private class QueueEntry<T> { // private inner class
        private int priority;
        private T elm;
        public QueueEntry(T elm, int priority) {
            this.priority = priority;
            this.elm = elm;
        }
    }

    public PriorityQueue() {
        // YOUR CODE HERE (1)
        elements = new ArrayList<QueueEntry<T>>();
    }
    public void insert(T elm, int priority) {
        int index;
        for (index = 0; index < elements.size(); index++)
            // if (/* YOUR CODE HERE (2) */) // check for the correct position
            if(priority < elements.get(index).priority){
                break;
            }

        // YOUR CODE HERE (3) --- insert the element
        elements.add(index,new QueueEntry(elm, priority));
    }
    public T extractMax() {
        if (elements.isEmpty()) {
            // YOUR CODE HERE (4)
            throw new NoSuchElementException("NoSuchElement");
        }
        // elements in increasing order, max element is in the last slot
        // YOUR CODE HERE (5)
        QueueEntry<T> qe = elements.get(elements.size()-1);
        elements.remove(elements.size()-1);
        return qe.elm;
    }
}
