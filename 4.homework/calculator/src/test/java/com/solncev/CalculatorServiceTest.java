package com.solncev;

import com.solncev.enums.Operator;
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
    private static final int A = 1;
    private static final int B = 1;
    private static final Operator OPERATOR = Operator.PLUS;
    private static final String ERROR = "request is invalid";
    private static CalculatorService calculatorService;

    @BeforeClass
    public static void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void getAnswerShouldReturnCorrectAnswer() {
        Assert.assertEquals(RESULT, calculatorService.getAnswer(INPUT));
    }

    @Test
    public void getAnswerShouldReturnErrorMessage() {
        Assert.assertEquals(ERROR, calculatorService.getAnswer(INCORRECT_INPUT));
    }

    @Test
    public void getResultShouldReturnCorrectResult() {
        Assert.assertEquals(RESULT, calculatorService.getResult(A, B, OPERATOR));
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
