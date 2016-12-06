package com.solncev.helpers;

/**
 * Created by Марат on 03.12.2016.
 */
public class Calculator {
    private static final String ERROR = "wat";

    public int sum(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int mult(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException(ERROR);
        }
        return x / y;
    }

}
