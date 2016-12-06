package com.solncev;

import com.solncev.enums.Operator;
import com.solncev.helpers.Calculator;
import com.solncev.services.CalculatorService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Марат on 04.12.2016.
 */
public class CalculatorServiceTest {
    private static final String INPUT = "/calculator/1+0";
    private static final String INCORRECT_INPUT = "/calculator/r+1";
    private static final String INPUT_FOR_DIVIDING = "/calculator/1/0";
    private static final String RESULT = "1";
    private static final int A = 1;
    private static final int B = 0;
    private static final Operator OPERATOR = Operator.PLUS;
    private static final String ERROR = "request is invalid";
    private static final String DIVIDING_ERROR = "wat";
    private static CalculatorService calculatorService;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculatorService = new CalculatorService();
        calculator = mock(Calculator.class);
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
    public void getAnswerShouldReturnDividingErrorMessage() {
        when(calculator.div(A, B)).thenThrow(new ArithmeticException(DIVIDING_ERROR));
        Assert.assertEquals(DIVIDING_ERROR, calculatorService.getAnswer(INPUT_FOR_DIVIDING));
    }

    @Test
    public void getResultOfCalculationShouldReturnCorrectResult() {
        when(calculator.sub(A, B)).thenReturn(Integer.valueOf(RESULT));
        Assert.assertEquals(RESULT, calculatorService.getResultOfCalculation(A, B, OPERATOR));
    }
}
