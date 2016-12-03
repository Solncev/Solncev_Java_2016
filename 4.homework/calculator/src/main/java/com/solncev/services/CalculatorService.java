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
    private Parser parser = new Parser();
    private Calculator calculator = new Calculator();
    private Pattern pattern = Pattern.compile("(/calculator/([0-9]+)((\\+|-|\\*|/))" +
            "([0-9]+))|(/calculator/)|(/calculator)");
    private int a = 0;
    private int b = 0;
    private String result = "";

    public String getResult(String s) {
        if (isRequestCorrect(s)) {
            int[] arr = parser.getNumbers(s);
            a = arr[0];
            b = arr[1];
            Operator operator = parser.getOperator(s);
            switch (operator) {
                case DIV:
                    if (b != 0) {
                        result += calculator.div(a, b);
                    } else {
                        result += "wat";
                    }
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
        } else {
            return "request is invalid";
        }
    }

    public boolean isRequestCorrect(String s) {
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
