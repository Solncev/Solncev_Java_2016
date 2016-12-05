package com.solncev.helpers;

/**
 * Created by Марат on 03.12.2016.
 */
public class Calculator {
    public int sum(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int mult(int x, int y) {
        return x * y;
    }

    public String div(int x, int y) {
        if (y != 0) {
            return "" + x / y;
        } else {
            return "wat";
        }
    }

}
