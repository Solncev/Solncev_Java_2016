package com.solncev;

import com.solncev.helpers.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Марат on 03.12.2016.
 */
public class CalculatorTest {
    private static final int X = 2;
    private static final int Y = 5;
    private static final int Z = 0;
    private static final String ERROR = "wat";
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void sumShouldReturnCorrectSum() {
        Assert.assertEquals(X + Y, calculator.sum(X, Y));
    }

    @Test
    public void subShouldReturnCorrectSub() {
        Assert.assertEquals(X - Y, calculator.sub(X, Y));
    }

    @Test
    public void multShouldReturnCorrectMult() {
        Assert.assertEquals(X * Y, calculator.mult(X, Y));
    }

    @Test
    public void divShouldReturnCorrectDiv() {
        Assert.assertEquals(X / Y, calculator.div(X, Y));
    }

    @Test(expected = ArithmeticException.class)
    public void divShouldReturnErrorMessage() {
        Assert.assertEquals(ERROR, calculator.div(X, Z));
    }

}
