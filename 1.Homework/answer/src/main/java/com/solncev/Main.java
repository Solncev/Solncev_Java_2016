package com.solncev;

/**
 * Created by Марат on 15.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        AnswerGenerator answerGenerator = new AnswerGenerator();
        System.out.println(Divider.divide(5, 2));
        System.out.println(RestCalculator.getRest(7, 3));
        System.out.println(answerGenerator.generateAnswer(907, 21));
    }

}
