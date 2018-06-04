package Practice_Practical;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by kjeged01 on 04/06/2018.
 */
public class SetArithmetic {

    public static void main(String[] args) {
        String operator; // to hold operator
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter set for computation: ");
        String setInput = keyboard.nextLine();
        int OpIndex = 0; // Operator index

        String[] inputSetList = setInput
                .replace("[",",")
                .replace("]",",")
                .replace(" ","")
                .trim().split(",");
        // System.out.println("inputSetList: " + inputSetList.toString());

        TreeSet<Integer> A = new TreeSet<>();
        TreeSet<Integer> B = new TreeSet<>();

        // Find operator index
        //[1, 2, 3] + [3, 5, 7]
        OpIndex = opI(inputSetList);
        operator = inputSetList[OpIndex];

        // Update set A
        updateSet(inputSetList, A,  0, OpIndex);
        //. Update set B
        updateSet(inputSetList, B,  OpIndex, inputSetList.length);

        System.out.println(A);
        System.out.println(operator);
        System.out.println(B);
    }

    private static int opI(String[] S){
        // Find operator index
        //[1, 2, 3] + [3, 5, 7]
        int OpIndex = 0;
        for(int i = 0; i < S.length; i++){
            if(!(S[i].equals(""))){
                if(S[i].trim().charAt(0)== '+'){
                    OpIndex = i;
                    break;
                }
            }
        }
        return OpIndex;
    }

    private static void updateSet(String[] inputList, TreeSet<Integer> S, int start, int end){
        for(int i = start; i < end; i++){
            if(!(inputList[i].equals(""))){
                // Skipp
                try {
                    Integer number = new Integer(Integer.valueOf(inputList[i]));
                    if (number < 0) {
                        throw new IllegalArgumentException("Only positive numbers allowed");
                    } else {
                        S.add(number);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
