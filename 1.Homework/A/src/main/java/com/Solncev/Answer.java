package com.Solncev;

import javafx.scene.control.SplitPane;

/**
 * Created by Марат on 14.11.2016.
 */
public class Answer {


    public String getAnswer(int a, int b) {
        StringBuilder builder = new StringBuilder();
        builder.append("When you divide ");
        builder.append(a);
        builder.append(" by ");
        builder.append(b);
        builder.append(" turns");
        builder.append(" integer part = ");
        Divider d = new Divider();
        builder.append(d.getIntegerPart(a, b));
        builder.append(" and rest = ");
        Rest r = new Rest();
        builder.append(r.getRest(a, b));
        return builder.toString();
    }
}
