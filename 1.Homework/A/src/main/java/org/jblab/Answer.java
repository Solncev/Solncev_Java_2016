package org.jblab;



/**
 * Created by Марат on 13.11.2016.
 */
public class Answer {
    Divider d;
    Rest r;
    private int x;
    private int y;

    public String getAnswer(int a, int b) {
        String answer = "When you divide ";
        answer += a;
        answer += " by ";
        answer += b;
        answer += " turns";
        answer += " integer part = ";
        answer += d.getIntegerPart(a, b);
        answer += " and rest = " + r.getRest(a, b);
        return answer;
    }
}
