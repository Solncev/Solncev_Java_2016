package ru.itis.kpfu.chainofresponsability;

/**
 * Created by Марат on 13.11.2016.
 */
public class InfoLogger extends Logger {

    public InfoLogger() {
        super(1);
    }

    @Override
    void write(String text) {
        System.out.println("INFO:" + text);
    }
}
