package org.jblab;

/**
 * Created by Марат on 13.11.2016.
 */
public class Rest {
    private int x;
    private int y;
    private Divider d;

    public int getRest(int a, int b) {
        return a - b * d.getIntegerPart(a, b);
    }

}
