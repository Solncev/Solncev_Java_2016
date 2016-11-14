package ru.itis.kpfu.chainofresponsability;

/**
 * Created by Марат on 13.11.2016.
 */
public class ErrorLogger extends Logger {
    public ErrorLogger() {
        super(3);
    }

    @Override
    void write(String text) {
        this.setNext(new WarnLogger());
        System.out.println("ERROR: " + text);
    }
}
