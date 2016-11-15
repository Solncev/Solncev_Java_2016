package com.solncev;

/**
 * Created by Марат on 14.11.2016.
 */
public class RestCalculator {

    public static int getRest(int a, int b) {
        return a - b * Divider.divide(a, b);
    }

}
