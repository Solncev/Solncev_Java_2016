package com.solncev;

/**
 * Created by Марат on 15.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Divider divider = new Divider();
        AnswerGenerator answerGenerator = new AnswerGenerator();
        RestCalculator restCalculator = new RestCalculator();
        System.out.println(divider.getIntegerPart(5,2));
        System.out.println(restCalculator.getRest(7,3));
        System.out.println(answerGenerator.createAnswer(907,21));
    }
}
