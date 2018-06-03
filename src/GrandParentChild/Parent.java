package GrandParentChild;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class Parent extends GrandParent {
    @Override
    public boolean good() {
        System.out.println(getAge());
        System.out.println(getMore());
        return getAge() < getMore();
    }

    public int getAge() {
        return 42;
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Ahh.........!");
    }
}
