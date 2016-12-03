package com.solncev.helpers;

import com.solncev.enums.Operator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Марат on 03.12.2016.
 */
public class Parser {
    private static final Pattern pattern = Pattern.compile("/calculator/(?<firstNumber>[0-9]+)(?<operator>(\\+|-|\\*|/))" +
            "(?<secondNumber>[0-9]+)");
    private int[] a = new int[2];

    public int[] getNumbers(String s) {
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            a[0] = Integer.parseInt(matcher.group("firstNumber"));
            a[1] = Integer.parseInt(matcher.group("secondNumber"));
        }
        return a;
    }

    public Operator getOperator(String s) {
        Matcher matcher = pattern.matcher(s);
        String oper = "";
        if (matcher.matches()) {
            oper = matcher.group("operator");
        }
        switch (oper) {
            case "-":
                return Operator.MINUS;
            case "*":
                return Operator.MULT;
            case "/":
                return Operator.DIV;
            default:
                return Operator.PLUS;
        }

    }
}
