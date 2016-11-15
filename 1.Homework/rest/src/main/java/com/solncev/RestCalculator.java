package com.solncev;

/**
 * Created by Марат on 14.11.2016.
 */
public class RestCalculator {
    public int getRest(int a, int b) {
        Divider d = new Divider();
        return (a - b * d.getIntegerPart(a, b));
    }

}
