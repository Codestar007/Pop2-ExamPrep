import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExceptionTester {

    public static void main(String[] args) {
        ExceptionTester  et = new ExceptionTester();
        et.launch(6);
    }


    public void launch(int userInput) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);

        try {
            // more code here list.add(newElement);
            // more code here
            System.out.println(intList.lastIndexOf(3));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
