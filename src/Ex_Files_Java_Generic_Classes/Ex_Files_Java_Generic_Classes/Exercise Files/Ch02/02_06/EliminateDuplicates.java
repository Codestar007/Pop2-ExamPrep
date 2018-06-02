/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminateduplicates;

import java.util.ArrayList;

/**
 *
 * @author Producer
 */
public class EliminateDuplicates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("red");
        list.add("green");
        list.add("blue");
        list.add("red");
        list.add("green");
        list.add("yellow");
        list.add("orange");
        list.add("blue");
        ArrayList<String> nodups = removeDups(list);
        System.out.println(list);
        System.out.println(nodups);
    }
    public static <E extends Comparable<E>> ArrayList<E> removeDups(ArrayList<E> list)
    {
        boolean found = false;
        if(list.size()==0)
            return list;
        ArrayList<E> newList = new ArrayList<>();
        newList.add(list.get(0));
        for(int i = 1; i<list.size();i++)
        {
            for(int j=0;j<newList.size();j++)
            {
                if(list.get(i).compareTo(newList.get(j))==0)
                {
                    found = true;
                    break;
                }
            }
            if(found != true)
                newList.add(list.get(i)); 
            found = false;
        }
       
        return newList;
    }
    
}
