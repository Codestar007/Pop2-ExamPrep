package Tracing;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class Derived extends Base {
    public void methodOne(int a) {
        super.methodOne();
        System.out.print("X");
    }

    public void methodOne(Integer a) {
        super.methodOne();
        System.out.print("C");
    }

    public void methodTwo() {
        super.methodTwo();
        System.out.print("D");
    }
}
