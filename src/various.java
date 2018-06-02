import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by kjeged01 on 01/06/2018.
 */
public class various {
    public static void main(String[] args) {
        //System.out.println("Hello World!!");
        //System.out.println("Hello World!!   --- UPDATED");
        System.out.println(getInfo(50, "Kizi"));

        ArrayList list = new ArrayList();
        list.add("P");
        list.add("Q");
        list.add("R");
        list.set(2, "s");
        list.add(2, "T");
        list.add("u");
        System.out.println("ArrayList list: " + list);

    }
    public static String getInfo(Integer age, String myName){
        //ArrayList myList = new ArrayList(Arrays.asList("WE", "Are", "Doing", "Fine"));
        List<Integer> list = new ArrayList<>();
        List<Integer>  myList = new ArrayList(Arrays.asList("WE", "Are", "Doing", "Fine"));

        System.out.println("\n Divisions and Remainders========================================================\n");
        System.out.println("/: " + (double)2/3);
        System.out.println("%: " + 2%3);

        System.out.println("\n Maps and Hashmap========================================================\n");
        Map <String, String> eDetails = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            eDetails.put("Kizi" +i, "Value"+i);
        }
        List<String> maplist = new ArrayList<String>(eDetails.values());
        Collections.sort(maplist);
        System.out.println("Sorted maplist of values: " + maplist);
        System.out.println("Entry set for eDetails: " + eDetails.entrySet());
        System.out.println("Key set for eDetails: " + eDetails.keySet());
        System.out.println("eDetails: " + eDetails);
        System.out.println(eDetails.get("Kizi3"));
        System.out.println("\n Add to list========================================================\n");

        for (int i = 1; i < 6; i++) {
            list.add(i*2);
        }
        System.out.println("List double: " + list);

        System.out.println("\n========================================================\n");

        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Forward print: ");
            System.out.println(myList.get(i));
        }

        System.out.println("\n Array List========================================================\n");
        String[] array = {"Phil", "Mary", "Betty", "bob"};
        List<String> myList2 = Arrays.asList(array);
        Collections.sort(myList2);

        System.out.println("\n========================================================\n");

        for (int i = myList.size() - 1; i > -1; i--) {
            System.out.println("Reverse print: ");
            System.out.println(myList.get(i));
        }
        //return("\nMy name is " + myName + " and I am " + age + " years old!");
        return null;
    }
}
