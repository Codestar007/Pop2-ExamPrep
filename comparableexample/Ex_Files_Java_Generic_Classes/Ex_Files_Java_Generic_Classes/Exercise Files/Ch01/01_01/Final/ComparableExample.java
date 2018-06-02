/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparableexample;

import java.util.Date;


/**
 *
 * @author Producer
 */
public class ComparableExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //prior to Java 5.0
//        Comparable c = new Date();
//        System.out.println(c.compareTo("Monday"));
          Comparable<Date> c2 = new Date();
          System.out.println(c2.compareTo("Monday"));
 
    }
    
}
