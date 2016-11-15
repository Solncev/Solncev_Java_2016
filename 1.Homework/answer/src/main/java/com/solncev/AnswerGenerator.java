package com.solncev;

/**
 * Created by Марат on 14.11.2016.
 */
public class AnswerGenerator {

    public String generateAnswer(int a, int b) {
        return new StringBuilder()
                .append("When you divide ")
                .append(a)
                .append(" by ")
                .append(b)
                .append(" turns")
                .append(" integer part = ")
                .append(Divider.divide(a, b))
                .append(" and rest = ")
                .append(RestCalculator.getRest(a, b)).toString();
    }

}
