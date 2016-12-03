package com.solncev;

import com.solncev.services.CalculatorService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Марат on 04.12.2016.
 */
public class CalculatorServiceTest {
    private static final String INPUT = "/calculator/1+1";
    private static final String INCORRECT_INPUT = "/calculator/r+1";
    private static final String RESULT = "2";
    private static final String ERROR = "request is invalid";
    private static CalculatorService calculatorService;

    @BeforeClass
    public static void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void getResultShouldReturnCorrectResult() {
        Assert.assertEquals(RESULT, calculatorService.getResult(INPUT));
    }

    @Test
    public void getResultShouldReturnErrorMessage() {
        Assert.assertEquals(ERROR, calculatorService.getResult(INCORRECT_INPUT));
    }

    @Test
    public void isRequestCorrectShouldReturnTrue() {
        Assert.assertTrue(calculatorService.isRequestCorrect(INPUT));
    }

    @Test
    public void isRequestCorrectShouldReturnFalse() {
        Assert.assertFalse(calculatorService.isRequestCorrect(INCORRECT_INPUT));
    }

}
