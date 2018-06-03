package Tracing;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class Base {
    public void methodOne() {
        System.out.println("A");
        methodTwo();
    }

    public void methodOne(int a) {
        System.out.println("W");
        methodTwo();
    }

    public void methodTwo() {
        System.out.print("B");
    }
}
