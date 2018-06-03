package ConstructorExamples;

import ConstructorExamples.SubConstructor;

/**
 * Created by kjeged01 on 03/06/2018.
 */
class SubSubConstructor extends SubConstructor {
    private String s;

    public SubSubConstructor() {
        super("item");
        s = super.s;
        x++;
        System.out.println("[6] [s = " + this.s + "] " + this);
    }

    public String toString() {
        return "******* " + super.toString();
    }
}
