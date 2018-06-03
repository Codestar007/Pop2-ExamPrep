package MaxClassQ11;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class MaxClass {
    public static void main(String args[]) {
        try {
            C c = new C();
            System.out.println(c.max(13, 29));
        } catch (RuntimeException rte) {
            System.out.println(rte);
        } finally {
            System.out.println("In finally of main");
        }
    }
}
