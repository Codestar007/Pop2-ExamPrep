import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListRunner {
    public LinkedList<String> myLinkedList;
    public static void main(String[] args) {
        LinkedList<String> myLinkedList = new LinkedList<String>();
        myLinkedList.add("aaa");
        myLinkedList.add("bbb");
        myLinkedList.add("ccc");
        myLinkedList.add("ddd");
        myLinkedList.add("eee");
        myLinkedList.add("fff");
        myLinkedList.add("ggg");
        myLinkedList.add("hhh");
        myLinkedList.add("iii");

        Iterator<String> iter = myLinkedList.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
