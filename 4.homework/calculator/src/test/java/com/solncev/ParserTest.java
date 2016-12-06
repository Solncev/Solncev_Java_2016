package com.solncev;

import com.solncev.enums.Operator;
import com.solncev.helpers.Parser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Марат on 04.12.2016.
 */
public class ParserTest {
    private static final String INPUT = "/calculator/1+1";
    private static final String INCORRECT_INPUT = "/calculator/r+1";
    private static final int[] ARRAY = {1, 1};
    private static final Operator OPERATOR = Operator.PLUS;
    private static Parser parser;

    @BeforeClass
    public static void setUp() {
        parser = new Parser();
    }

    @Test
    public void getNumbersShouldReturnCorrectArray() {
        Assert.assertTrue(Arrays.equals(ARRAY, parser.getNumbers(INPUT)));
    }

    @Test
    public void getOperatorShouldReturnCorrectOperator() {
        Assert.assertEquals(OPERATOR, parser.getOperator(INPUT));
    }

    @Test
    public void isRequestCorrectShouldReturnTrue() {
        Assert.assertTrue(parser.isRequestCorrect(INPUT));
    }

    @Test
    public void isRequestCorrectShouldReturnFalse() {
        Assert.assertFalse(parser.isRequestCorrect(INCORRECT_INPUT));
    }
}
