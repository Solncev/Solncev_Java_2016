package com.solncev.services;

import com.solncev.enums.Operator;
import com.solncev.helpers.Calculator;

/**
 * Created by Марат on 18.02.2017.
 */
public class CalculatorService {
    private static final String DIVIDING_ERROR = "wat";
    private Calculator calculator = new Calculator();

    public String getResultOfCalculation(int a, int b, Operator operator) {
        String result = "";
        switch (operator) {
            case DIV:
                try {
                    result += calculator.div(a, b);
                    break;
                } catch (ArithmeticException e) {
                    return DIVIDING_ERROR;
                }
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
