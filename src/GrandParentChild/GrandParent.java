package GrandParentChild;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public abstract class GrandParent {
    private final static int HowMuch;

    static {
        System.err.println("jkahdjkashd");
        HowMuch = 100;
    }

    public abstract boolean good();

    public static int getMore() {
        return HowMuch;
    }

    public void eat() {
        if (good())
            System.out.println("Good!");
        else
            System.out.println("Bad!");
    }

}
