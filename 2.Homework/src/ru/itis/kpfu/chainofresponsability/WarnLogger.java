package ru.itis.kpfu.chainofresponsability;

/**
 * Created by Марат on 13.11.2016.
 */
public class WarnLogger extends Logger {
    public WarnLogger() {
        super(2);
    }

    @Override
    void write(String text) {
        this.setNext(new InfoLogger());
        System.out.println("WARN: " + text);
    }
}
