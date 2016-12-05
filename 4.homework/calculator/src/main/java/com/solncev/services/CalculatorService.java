package com.solncev.services;

import com.solncev.enums.Operator;
import com.solncev.helpers.Calculator;
import com.solncev.helpers.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Марат on 03.12.2016.
 */
public class CalculatorService {
    private static final String ERROR_MESSAGE = "request is invalid";
    private Parser parser = new Parser();
    private Calculator calculator = new Calculator();
    private Pattern pattern = Pattern.compile("(/calculator/([0-9]+)((\\+|-|\\*|/))" +
            "([0-9]+))|(/calculator/)|(/calculator)");
    private int a = 0;
    private int b = 0;

    public String getAnswer(String s) {
        if (isRequestCorrect(s)) {
            int[] numbers = parser.getNumbers(s);
            a = numbers[0];
            b = numbers[1];
            Operator operator = parser.getOperator(s);
            return getResultOfCalculation(a, b, operator);
        } else {
            return ERROR_MESSAGE;
        }
    }

    public boolean isRequestCorrect(String s) {
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public String getResultOfCalculation(int a, int b, Operator operator) {
        String result = "";
        switch (operator) {
            case DIV:
                result += calculator.div(a, b);
                break;
            case MINUS:
                result += calculator.sub(a, b);
                break;
            case MULT:
                result += calculator.mult(a, b);
                break;
            case PLUS:
                result += calculator.sum(a, b);
                break;
        }
        return result;
    }
}
