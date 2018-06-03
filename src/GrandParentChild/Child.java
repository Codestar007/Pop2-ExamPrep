package GrandParentChild;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class Child extends Parent {
    @Override
    public int getAge() {
        return super.getAge() / 2;
    }

    public static int getMore() {
        return 30;
    }
}
